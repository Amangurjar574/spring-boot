package com.example.demo.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler extends RuntimeException{


    @ExceptionHandler(UserNotFoundException.class)
    public String userNotFound(UserNotFoundException e)
    {
        return e.getMessage();
    }
}
