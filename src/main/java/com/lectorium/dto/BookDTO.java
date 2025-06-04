package com.lectorium.dto;

import com.lectorium.model.Category;
import com.lectorium.model.Publisher;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
    private Integer idBook;
    private String title;
    @NotBlank (message = "Subtitle is required")
    private String subtitle;
    private String description;
    private Publisher publisher;
    private Category category;
    private Integer idPublisher;
    private Integer idCategory;
}

