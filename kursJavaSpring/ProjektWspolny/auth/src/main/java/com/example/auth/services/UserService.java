package com.example.auth.services;

import com.example.auth.entity.*;
import com.example.auth.exceptions.UserDontExistException;
import com.example.auth.exceptions.UserExistingWithEmail;
import com.example.auth.exceptions.UserExistingWithName;
import com.example.auth.repository.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CookieService cookieService;
    private final EmailService emailService;
    @Value("${jwt.exp}")
    private int exp;
    @Value("${jwt.refresh.exp}")
    private int refreshExp;
    private User saveUser(User user)
    {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.saveAndFlush(user);
    }

    public String generateToken(String username,int exp)
    {
        return jwtService.generateToken(username,exp);
    }

    public void validateTocken(HttpServletRequest request, HttpServletResponse response) throws ExpiredJwtException, IllegalArgumentException
    {
        String token = null;
        String refresh = null;
        if (request.getCookies() != null)
        {
            for (Cookie value : Arrays.stream(request.getCookies()).toList())
            {
                if (value.getName().equals("Authorization"))
                {
                    token = value.getValue();
                }
                else if (value.getName().equals("Refresh"))
                {
                    refresh = value.getValue();
                }
            }
        }
        else
        {
            throw new IllegalArgumentException("Token can't be null");
        }
        try
        {
            jwtService.validateToken(token);
        }
        catch(IllegalArgumentException | ExpiredJwtException e)
        {
            jwtService.validateToken(refresh);
            Cookie refreshCookie = cookieService.generateCookie("Refresh", jwtService.refreshToken(refresh,refreshExp), refreshExp);
            Cookie cookie = cookieService.generateCookie("Authorization", jwtService.refreshToken(refresh,exp), exp);
            response.addCookie(cookie);
            response.addCookie(refreshCookie);
        }
    }

    public void register(UserRegisterDTO userRegisterDTO) throws UserExistingWithEmail,UserExistingWithName
    {
        userRepository.findUserByLogin(userRegisterDTO.getLogin()).ifPresent(value->{
            throw new UserExistingWithName("Użytkownik o tej nazwie już istnieje");
        });
        userRepository.findUserByEmail(userRegisterDTO.getEmail()).ifPresent(value->{
            throw new UserExistingWithEmail("Użytkownik o tym adresie e-mail już istnieje");
        });
        User user = new User();
        user.setLock(true);
        user.setLogin(userRegisterDTO.getLogin());
        user.setEmail(userRegisterDTO.getEmail());
        user.setPassword(userRegisterDTO.getPassword());
        if(userRegisterDTO.getRole() != null)
        {
            user.setRole(userRegisterDTO.getRole());
        }
        else
        {
            user.setRole(Role.USER);
        }
        saveUser(user);
        emailService.sendActivation(user);
    }

    public ResponseEntity<?> login(HttpServletResponse response, User authRequest)
    {
        User user = userRepository.findUserByLoginAndLockAndEnabled(authRequest.getUsername()).orElse(null);
        if (user != null)
        {
            Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
            if (authenticate.isAuthenticated())
            {
                Cookie refresh = cookieService.generateCookie("Refresh", generateToken(authRequest.getUsername(),refreshExp), refreshExp);
                Cookie cookie = cookieService.generateCookie("Authorization", generateToken(authRequest.getUsername(),exp), exp);
                response.addCookie(cookie);
                response.addCookie(refresh);
                return ResponseEntity.ok(
                        UserRegisterDTO
                                .builder()
                                .login(user.getUsername())
                                .email(user.getEmail())
                                .role(user.getRole())
                                .build());
            }
            else
            {
                return ResponseEntity.ok(new AuthResponse(Code.A1));
            }
        }
        return ResponseEntity.ok(new AuthResponse(Code.A2));
    }

    public ResponseEntity<?> loginByToken(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            validateTocken(request,response);
            String refresh=null;
            for (Cookie value : Arrays.stream(request.getCookies()).toList())
            {
                if (value.getName().equals("Refresh"))
                {
                    refresh = value.getValue();
                }
            }
            String login = jwtService.getSubject(refresh);
            User user = (User) userRepository.findUserByLoginAndLockAndEnabled(login).orElse(null);
            if (user != null)
            {
                return ResponseEntity.ok(UserRegisterDTO.builder().login(user.getUsername()).email(user.getEmail()).role(user.getRole()).build());
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse(Code.A1));
        }
        catch(ExpiredJwtException | IllegalArgumentException e)
        {
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new AuthResponse(Code.A3));
        }
    }

    public ResponseEntity<LoginResponse> loggedIn(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            validateTocken(request,response);
            return  ResponseEntity.ok(new LoginResponse(true));
        }
        catch(ExpiredJwtException | IllegalArgumentException e)
        {
            return  ResponseEntity.ok(new LoginResponse(false));
        }
    }

    public void activateUser(String uid) throws UserDontExistException
    {
        User user = userRepository.findUserByUuid(uid).orElse(null);
        if(user != null)
        {
            user.setLock(false);
            user.setEnabled(true);
            userRepository.save(user);
            return;
        }
        throw new UserDontExistException("User don't exist");

    }

    public void recoveryPassword(String email) throws  UserDontExistException
    {
        User user = userRepository.findUserByEmail(email).orElse(null);
        if(user != null)
        {
            emailService.sendPasswordRecovery(user);
            return;
        }
        throw new UserDontExistException("User don't exist");
    }

    public void resetPassword(ChangePasswordData changePasswordData) throws UserDontExistException
    {
        User user = userRepository.findUserByUuid(changePasswordData.getUid()).orElse(null);
        if(user != null)
        {
            user.setPassword(changePasswordData.getPassword());
            saveUser(user);
            return;
        }
        throw new UserDontExistException("User don't exist");
    }
}
