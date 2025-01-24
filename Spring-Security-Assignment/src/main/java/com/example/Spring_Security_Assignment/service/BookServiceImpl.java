package com.example.Spring_Security_Assignment.service;

import com.example.Spring_Security_Assignment.entity.Book;
import com.example.Spring_Security_Assignment.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BookServiceImpl implements BookService {
    BookRepository bookRepository;
    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }
    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Book Not Found id- "+id)
        );
    }

    @Override
    public String deleteById(int id) {
        findById(id);
        bookRepository.deleteById(id);
        return "Success";
    }
}
