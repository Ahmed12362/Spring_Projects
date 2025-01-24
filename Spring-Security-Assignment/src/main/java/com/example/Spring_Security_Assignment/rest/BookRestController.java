package com.example.Spring_Security_Assignment.rest;

import com.example.Spring_Security_Assignment.entity.Book;
import com.example.Spring_Security_Assignment.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {
    BookService bookService;
    BookRestController(BookService bookService){
        this.bookService = bookService;
    }
    @GetMapping("/books")
    List<Book> getAll(){
        return bookService.findAll();
    }
    @GetMapping("/books/{bookId}")
    Book getBook(@PathVariable int bookId){
       return bookService.findById(bookId);
    }
    @PostMapping("/books")
    Book addBook(@RequestBody Book book){
        book.setId(0);
        return bookService.save(book);
    }
    @PutMapping("/books/{bookId}")
    Book updateBook(@PathVariable int bookId , @RequestBody Book book){
        book.setId(bookId);
        return bookService.save(book);
    }
    @DeleteMapping("/books/{bookId}")
    String deleteBook(@PathVariable int bookId){
        return bookService.deleteById(bookId);
    }
}
