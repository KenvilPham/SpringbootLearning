package com.learn.springboot.crudrest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "book")
@Table(name = "book")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "unique id of book", example = "11", required = true)
    private Long id;
    

    @Column(nullable = false)
    @Schema(description = "Name of book", example = "De men phieu luu ky", required = true)
    private String title;

    @Column(nullable = false)
    @Schema(description = "Author of book", example = "To Hoai", required = true)
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

}
