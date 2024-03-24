package com.hegazy.mohammed.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestControllerHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDetails>userNotFoundException( ){
        ErrorDetails details=new ErrorDetails("user Doesn't exist", HttpStatus.BAD_REQUEST.value());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(details);
    }
}
