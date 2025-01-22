package com.BookTracker.Book_Assignment_RestApi.dao;

import com.BookTracker.Book_Assignment_RestApi.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book , Integer> {
}
