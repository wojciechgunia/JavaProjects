package com.example.auth.fasade;

import com.example.auth.entity.*;
import com.example.auth.exceptions.UserDontExistException;
import com.example.auth.exceptions.UserExistingWithEmail;
import com.example.auth.exceptions.UserExistingWithName;
import com.example.auth.services.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Slf4j
public class AuthController
{
    public final UserService userService;

    @RequestMapping(path="/register",method = RequestMethod.POST)
    public ResponseEntity<AuthResponse> addNewUser(@Valid @RequestBody UserRegisterDTO user)
    {
        try
        {
            log.info("--START Register user");
            userService.register(user);
            log.info("--STOP Register user");
            return ResponseEntity.ok(new AuthResponse(Code.SUCCESS));
        }
        catch (UserExistingWithEmail e)
        {
            log.info("User exist in database with email");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthResponse(Code.A5));
        }
        catch (UserExistingWithName e)
        {
            log.info("User exist in database with name");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthResponse(Code.A4));
        }

    }

    @RequestMapping(path="/login",method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response)
    {
        log.info("--TRY Login user");
        return userService.login(response, user);
    }

    @RequestMapping(path = "/logout",method = RequestMethod.GET)
    public ResponseEntity<?> logout( HttpServletResponse response,HttpServletRequest request){
        log.info("--TRY Logout user");
        return userService.logout(request, response);
    }


    @RequestMapping(path="/auto-login",method = RequestMethod.GET)
    public ResponseEntity<?> autoLogin(HttpServletRequest request, HttpServletResponse response)
    {
        log.info("--TRY Auto-login user");
        return userService.loginByToken(request,response);
    }

    @RequestMapping(path="/logged-in",method = RequestMethod.GET)
    public ResponseEntity<?> loggedIn(HttpServletRequest request, HttpServletResponse response)
    {
        log.info("--CHECK User logged-in");
        return userService.loggedIn(request,response);
    }

    @RequestMapping(path="/validate",method = RequestMethod.GET)
    public ResponseEntity<AuthResponse> validateToken(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            log.info("--START Validate token");
            userService.validateTocken(request, response);
            log.info("--STOP Validate token");
            return ResponseEntity.ok(new AuthResponse(Code.PERMIT));
        }
        catch (IllegalArgumentException | ExpiredJwtException e)
        {
            log.info("Token not correct");
            return ResponseEntity.status(401).body(new AuthResponse(Code.A3));
        }
    }

    @RequestMapping(path="/activate",method = RequestMethod.GET)
    public ResponseEntity<AuthResponse> activateUser(@RequestParam String uid)
    {
        try
        {
            log.info("--START Activate user");
            userService.activateUser(uid);
            log.info("--STOP Activate user");
            return ResponseEntity.ok(new AuthResponse(Code.SUCCESS));
        }
        catch(UserDontExistException e)
        {
            log.info("User dont exist in database");
            return ResponseEntity.status(400).body(new AuthResponse(Code.A6));
        }
    }

    @RequestMapping(path="/reset-password",method = RequestMethod.POST)
    public ResponseEntity<AuthResponse> sendMailRecovery(@RequestBody ResetPasswordData resetPasswordData)
    {
        try
        {
            log.info("--START Send Mail Recovery");
            userService.recoveryPassword(resetPasswordData.getEmail());
            log.info("--STOP Send Mail Recovery");
            return ResponseEntity.ok(new AuthResponse(Code.SUCCESS));
        }
        catch(UserDontExistException e)
        {
            log.info("Cant send mail");
            return ResponseEntity.status(400).body(new AuthResponse(Code.A6));
        }
    }

    @RequestMapping(path="/reset-password",method = RequestMethod.PATCH)
    public ResponseEntity<AuthResponse> passwordReset(@RequestBody ChangePasswordData changePasswordData)
    {
        try
        {
            log.info("--START Password Reset");
            userService.resetPassword(changePasswordData);
            log.info("--STOP Password Reset");
            return ResponseEntity.ok(new AuthResponse(Code.SUCCESS));
        }
        catch(UserDontExistException e)
        {
            log.info("User dont exist in database");
            return ResponseEntity.status(400).body(new AuthResponse(Code.A6));
        }
    }

    @RequestMapping(path = "/authorize",method = RequestMethod.GET)
    public ResponseEntity<AuthResponse> authorize(HttpServletRequest request,HttpServletResponse response) {
        try{
            log.info("--START authorize");
            userService.validateTocken(request,response);
            userService.authorize(request);
            log.info("--STOP authorize");
            return ResponseEntity.ok(new AuthResponse(Code.PERMIT));
        }catch (IllegalArgumentException | ExpiredJwtException e){
            log.info("Token is not correct");
            return ResponseEntity.status(401).body(new AuthResponse(Code.A3));
        }catch (UserDontExistException e1){
            log.info("User dont exist");
            return ResponseEntity.status(401).body(new AuthResponse(Code.A1));
        }
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationMessage handleValidationExceptions(MethodArgumentNotValidException ex)
    {
        return new ValidationMessage(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
