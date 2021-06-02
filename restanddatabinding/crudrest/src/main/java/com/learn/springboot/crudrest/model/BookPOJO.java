package com.learn.springboot.crudrest.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
public class BookPOJO {
    @NotBlank
    @Size(min = 5, max = 400, message = "The lenght of book name from 5 to 400 characters")
    @Schema(description = "Name of book", example = "De men phieu luu ky", required = true)
    private String title;

    @NotBlank
    @Size(min = 5, max = 200, message = "The lenght of book author from 5 to 200 characters")
    @Schema(description = "Author of book", example = "To Hoai", required = true)
    private String author;
}
