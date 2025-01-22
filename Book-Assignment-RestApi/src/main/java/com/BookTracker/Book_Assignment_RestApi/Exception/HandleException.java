package com.BookTracker.Book_Assignment_RestApi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleException {
    @ExceptionHandler
    public ResponseEntity<BookResponse> handleExc(BookNotFound exc){
        BookResponse error = new BookResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage("Exception::"+exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error , HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<BookResponse> handleAllExc(Exception exc){
        BookResponse error = new BookResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Exception::"+exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error , HttpStatus.BAD_REQUEST);
    }
}
