package com.asadmaiga.bookstore.repository;

import com.asadmaiga.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    List<Book> id(Long id);
}
