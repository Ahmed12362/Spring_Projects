package com.example.Spring_Security_Assignment.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {
    @ExceptionHandler
    public ResponseEntity<ExceptionResponse> BookNotFound(RuntimeException exc){
        ExceptionResponse error = new ExceptionResponse();
        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setTime_stamp(System.currentTimeMillis());
        return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
    }
}
