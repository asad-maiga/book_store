package com.asadmaiga.bookstore.service;

import com.asadmaiga.bookstore.DTO.BookDTO;
import com.asadmaiga.bookstore.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService
{
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book save(Book book);
    boolean deleteById(Long id);
    Optional<Book> update(Long id, BookDTO bookDTO);
}
