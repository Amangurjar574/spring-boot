package com.example.demo.exception;

import com.example.demo.utility.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;


@RestControllerAdvice
public class GlobalExceptionHandler{

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseStatus userNotFound(UserNotFoundException e)
    {
       return new ResponseStatus(HttpStatus.NOT_FOUND.value(),e.getMessage());
    }
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseStatus resourceNotFound(NoHandlerFoundException e)
    {
        return new ResponseStatus(HttpStatus.BAD_REQUEST.value(),e.getMessage());
    }
    @ExceptionHandler(Exception.class)
    public ResponseStatus exception(Exception e)
    {
        return new ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage());
    }
}
