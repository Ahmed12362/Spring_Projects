package com.example.Spring_Security_Assignment.repository;

import com.example.Spring_Security_Assignment.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
