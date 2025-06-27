package com.asadmaiga.bookstore.DTO;

import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record BookDTO
        (
                Long id,

                @NotBlank
                @Size(max = 200)
                String title,

                @NotBlank
                @Size(max = 200)
                String author,

                @NotBlank
                @Pattern(regexp = "\\d{10}|\\d{13}", message = "ISBN must be 10 or 13 digits")
                String isbn,

                @NotBlank
                String publisher,

                @NotBlank
                String language,

                @NotBlank
                String format,

                @NotBlank
                String category,

                @Min(1800)
                @Max(2100)
                Integer publicationYear,

                @Min(1)
                Integer edition,

                @Min(1)
                Integer pages,

                @Size(max = 2500)
                String description,

                java.math.@NotNull @DecimalMin(value = "0.0", inclusive = false) @Digits(integer = 6, fraction = 2) BigDecimal price,

                @NotNull
                @Min(0)
                Integer quantity,

                String imageUrl,

                java.math.@DecimalMin("0.0") @DecimalMax("5.0") BigDecimal rating,

                @Min(0)
                Integer numberOfReviews,

                java.math.@DecimalMin("0.0") @DecimalMax("5.0") BigDecimal discount,

                Boolean isDigital,

                String downloadUrl,

                LocalDateTime createdAt,
                LocalDateTime updatedAt

        ) {}
