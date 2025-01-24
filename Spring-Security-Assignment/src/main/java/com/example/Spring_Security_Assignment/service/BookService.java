package com.example.Spring_Security_Assignment.service;

import com.example.Spring_Security_Assignment.entity.Book;

import java.util.List;

public interface BookService {
    Book save(Book book);
    List<Book>findAll();
    Book findById(int id);
    String deleteById(int id);
}
