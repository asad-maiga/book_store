package com.asadmaiga.bookstore.controller;

import com.asadmaiga.bookstore.DTO.BookDTO;
import com.asadmaiga.bookstore.mapper.BookMapper;
import com.asadmaiga.bookstore.model.Book;
import com.asadmaiga.bookstore.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/books")
public class BookController
{
    private final BookService bookService;

    public  BookController(BookService bookService)
    {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks()
    {
        List<BookDTO> books = bookService.findAll()
                .stream()
                .map(BookMapper::bookToBookDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id)
    {
        return bookService.findById(id)
                .stream()
                .map(BookMapper::bookToBookDTO)
                .map(ResponseEntity::ok)
                .findAny().orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO)
    {
        Book saved = bookService.save(BookMapper.toBook(bookDTO));
        return new ResponseEntity<>(BookMapper.bookToBookDTO(saved), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO)
    {
        return bookService.update(id,bookDTO)
                .map(updated -> ResponseEntity.ok(BookMapper.bookToBookDTO(updated)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id)
    {
        if (bookService.deleteById(id))
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
