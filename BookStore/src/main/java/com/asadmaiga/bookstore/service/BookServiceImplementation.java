package com.asadmaiga.bookstore.service;

import com.asadmaiga.bookstore.DTO.BookDTO;
import com.asadmaiga.bookstore.model.Book;
import com.asadmaiga.bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImplementation implements BookService
{
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImplementation(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findAll()
    {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id)
    {
        return bookRepository.findById(id);
    }

    @Override
    public Book save(Book book)
    {
        return bookRepository.save(book);
    }

    @Override
    public Optional<Book> update(Long id, BookDTO bookDTO)
    {
        return bookRepository.findById(id)
                .map(exiting -> {
                    Book updatedBook = new Book();
                    updatedBook.setId(exiting.getId());
                    return bookRepository.save(updatedBook);
                });
    }

    @Override
    public boolean deleteById(Long id)
    {
        if (bookRepository.existsById(id))
        {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
