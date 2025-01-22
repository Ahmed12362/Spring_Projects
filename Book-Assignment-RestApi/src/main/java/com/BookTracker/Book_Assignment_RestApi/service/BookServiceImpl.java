package com.BookTracker.Book_Assignment_RestApi.service;

import com.BookTracker.Book_Assignment_RestApi.Exception.BookNotFound;
import com.BookTracker.Book_Assignment_RestApi.dao.BookRepository;
import com.BookTracker.Book_Assignment_RestApi.entity.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService{
    BookRepository bookRepository;
   public BookServiceImpl(BookRepository bookRepository){
       this.bookRepository = bookRepository;
   }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
       return bookRepository.findById(id)
               .orElseThrow( ()->new BookNotFound("Book ID Not Found") );
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public String deleteById(int id) {
       Book book = findById(id);
       bookRepository.deleteById(id);
        return "Deleted Success";
    }
}
