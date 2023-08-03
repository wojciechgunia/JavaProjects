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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController
{
    public final UserService userService;

    @RequestMapping(path="/register",method = RequestMethod.POST)
    public ResponseEntity<AuthResponse> addNewUser(@Valid @RequestBody UserRegisterDTO user)
    {
        try
        {
            userService.register(user);
            return ResponseEntity.ok(new AuthResponse(Code.SUCCESS));
        }
        catch (UserExistingWithEmail e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthResponse(Code.A5));
        }
        catch (UserExistingWithName e)
        {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AuthResponse(Code.A4));
        }

    }

    @RequestMapping(path="/login",method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody User user, HttpServletResponse response)
    {
        return userService.login(response, user);
    }

    @RequestMapping(path="/auto-login",method = RequestMethod.GET)
    public ResponseEntity<?> autoLogin(HttpServletRequest request, HttpServletResponse response)
    {
        return userService.loginByToken(request,response);
    }

    @RequestMapping(path="/logged-in",method = RequestMethod.GET)
    public ResponseEntity<?> loggedIn(HttpServletRequest request, HttpServletResponse response)
    {
        return userService.loggedIn(request,response);
    }

    @RequestMapping(path="/validate",method = RequestMethod.GET)
    public ResponseEntity<AuthResponse> validateToken(HttpServletRequest request, HttpServletResponse response)
    {
        try
        {
            userService.validateTocken(request, response);
            return ResponseEntity.ok(new AuthResponse(Code.PERMIT));
        }
        catch (IllegalArgumentException | ExpiredJwtException e)
        {
            return ResponseEntity.status(401).body(new AuthResponse(Code.A3));
        }
    }

    @RequestMapping(path="/activate",method = RequestMethod.GET)
    public ResponseEntity<AuthResponse> activateUser(@RequestParam String uid)
    {
        try
        {
            userService.activateUser(uid);
            return ResponseEntity.ok(new AuthResponse(Code.SUCCESS));
        }
        catch(UserDontExistException e)
        {
            return ResponseEntity.status(400).body(new AuthResponse(Code.A6));
        }
    }

    @RequestMapping(path="/reset-password",method = RequestMethod.POST)
    public ResponseEntity<AuthResponse> sendMailRecovery(@RequestBody ResetPasswordData resetPasswordData)
    {
        try
        {
            userService.recoveryPassword(resetPasswordData.getEmail());
            return ResponseEntity.ok(new AuthResponse(Code.SUCCESS));
        }
        catch(UserDontExistException e)
        {
            return ResponseEntity.status(400).body(new AuthResponse(Code.A6));
        }
    }

    @RequestMapping(path="/reset-password",method = RequestMethod.PATCH)
    public ResponseEntity<AuthResponse> passwordReset(@RequestBody ChangePasswordData changePasswordData)
    {
        try
        {
            userService.resetPassword(changePasswordData);
            return ResponseEntity.ok(new AuthResponse(Code.SUCCESS));
        }
        catch(UserDontExistException e)
        {
            return ResponseEntity.status(400).body(new AuthResponse(Code.A6));
        }
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ValidationMessage handleValidationExceptions(MethodArgumentNotValidException ex)
    {
        return new ValidationMessage(ex.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }
}
