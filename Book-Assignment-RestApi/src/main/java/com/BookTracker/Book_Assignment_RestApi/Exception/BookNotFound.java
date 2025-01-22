package com.BookTracker.Book_Assignment_RestApi.Exception;

public class BookNotFound extends RuntimeException {
    public BookNotFound(String message) {
        super(message);
    }
}
