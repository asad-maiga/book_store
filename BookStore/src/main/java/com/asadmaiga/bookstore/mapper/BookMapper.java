package com.asadmaiga.bookstore.mapper;

import com.asadmaiga.bookstore.DTO.BookDTO;
import com.asadmaiga.bookstore.model.Book;
import org.springframework.stereotype.Service;

@Service
public class BookMapper
{
    public static BookDTO bookToBookDTO(Book book)
    {
        return new BookDTO
                (
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        book.getIsbn(),
                        book.getPublisher(),
                        book.getLanguage(),
                        book.getCategory(),
                        book.getFormat(),
                        book.getPublicationYear(),
                        book.getEdition(),
                        book.getPages(),
                        book.getDescription(),
                        book.getPrice(),
                        book.getQuantity(),
                        book.getImageUrl(),
                        book.getRating(),
                        book.getNumberOfReviews(),
                        book.getDiscount(),
                        book.getIsDigital(),
                        book.getDownloadUrl(),
                        book.getUpdatedAt(),
                        book.getCreatedAt()

                );
    }
    public static Book toBook(BookDTO bookDTO)
    {
        Book book = new Book();
        book.setTitle(bookDTO.title());
        book.setAuthor(bookDTO.author());
        book.setIsbn(bookDTO.isbn());
        book.setPublisher(bookDTO.publisher());
        book.setLanguage(bookDTO.language());
        book.setCategory(bookDTO.category());
        book.setFormat(bookDTO.format());
        book.setPublicationYear(bookDTO.publicationYear());
        book.setEdition(bookDTO.edition());
        book.setPages(bookDTO.pages());
        book.setDescription(bookDTO.description());
        book.setPrice(bookDTO.price());
        book.setQuantity(bookDTO.quantity());
        book.setImageUrl(bookDTO.imageUrl());
        book.setRating(bookDTO.rating());
        book.setNumberOfReviews(bookDTO.numberOfReviews());
        book.setDiscount(bookDTO.discount());
        book.setIsDigital(bookDTO.isDigital());
        book.setDownloadUrl(bookDTO.downloadUrl());
        book.setUpdatedAt(bookDTO.updatedAt());
        book.setCreatedAt(bookDTO.createdAt());
        return book;
    }
}
