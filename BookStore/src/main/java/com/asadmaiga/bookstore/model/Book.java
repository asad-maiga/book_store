package com.asadmaiga.bookstore.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(
        name = "books",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "isbn")
        }
)
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 200)
    private String title;

    @NotBlank
    @Size(max = 200)
    private String author;

    @NotBlank
    @Column(unique = true, length = 13, nullable = false)
    @Pattern(regexp = "\\d{10}|\\d{13}", message = "ISBN must be 10 or 13 digits")
    private String isbn;

    @NotBlank
    @Size(max = 200)
    private String publisher;

    @Min(1800)
    @Max(2100)
    private Integer publicationYear;

    @Size(max = 2500)
    private String description;

    @NotBlank
    @Size(max = 100)
    private String language;

    @NotBlank
    @Size(max = 100)
    private String category;

    @NotBlank
    @Size(max = 50)
    private String format;

    @Min(1)
    private Integer edition;

    @Min(1)
    private Integer pages;

    @NotNull
    @DecimalMin(value = "0.0", inclusive = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;

    @NotNull
    @Min(0)
    private Integer quantity;

    @DecimalMin("0.0")
    @DecimalMax("5.0")
    private BigDecimal rating;

    @Size(max = 600)
    private String imageUrl;

    @Min(0)
    private Integer numberOfReviews;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    @DecimalMin("0.0")
    @DecimalMax("5.0")
    private BigDecimal discount;

    private Boolean isDigital;

    @Size(max = 600)
    private String downloadUrl;

    @PrePersist
    public void prePersist()
    {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    @PreUpdate
    public void preUpdate()
    {
        updatedAt = LocalDateTime.now();
    }
}
