package com.BookTracker.Book_Assignment_RestApi.rest;

import com.BookTracker.Book_Assignment_RestApi.Exception.BookNotFound;
import com.BookTracker.Book_Assignment_RestApi.Exception.BookResponse;
import com.BookTracker.Book_Assignment_RestApi.entity.Book;
import com.BookTracker.Book_Assignment_RestApi.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {
    BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping("/books")
    public List<Book> getBooks(){
        return bookService.findAll();
    }
    @GetMapping("/books/{bookId}")
    public Book getBook(@PathVariable int bookId){
        return bookService.findById(bookId);
    }
    @PostMapping("/books")
    public Book addBook(@RequestBody Book book){
        book.setId(0);
        return bookService.save(book);
    }
    @PutMapping("/books")
    public Book updateBook(@RequestBody Book book){
        return bookService.save(book);
    }
    @DeleteMapping("/books/{bookId}")
    public String deleteBook(@PathVariable int bookId){
        return bookService.deleteById(bookId);
    }
    @DeleteMapping("/books")
    public String deleteAllBook(){
        return bookService.deleteAll();
    }
}
