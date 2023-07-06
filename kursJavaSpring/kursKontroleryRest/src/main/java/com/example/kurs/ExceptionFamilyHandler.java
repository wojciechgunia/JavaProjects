package com.example.kurs;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionFamilyHandler {

    @ExceptionHandler
    public ResponseEntity<HttpErrorFamily> arrowFamilyResponseEntity (FamilyLenghtException e )
    {
        HttpErrorFamily httpErrorFamily = new HttpErrorFamily();
        httpErrorFamily.setStatus(HttpStatus.FORBIDDEN.value());
        httpErrorFamily.setMessage(e.getMessage());
        httpErrorFamily.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(httpErrorFamily,HttpStatus.FORBIDDEN);
    }
}
