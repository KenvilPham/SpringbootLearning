package com.learn.springboot.bindingdatademo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Food {
    @Positive
    private int id;

    @NotNull
    private String foodName;

    @NotNull
    private String type;

    @Size(min = 1, max = 50)
    private String description;
}
