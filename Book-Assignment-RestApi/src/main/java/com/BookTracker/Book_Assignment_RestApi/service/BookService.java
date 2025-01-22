package com.BookTracker.Book_Assignment_RestApi.service;

import com.BookTracker.Book_Assignment_RestApi.entity.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    Book findById(int id);
    List<Book> findAll();
    String deleteById(int id);
    String deleteAll();

}
