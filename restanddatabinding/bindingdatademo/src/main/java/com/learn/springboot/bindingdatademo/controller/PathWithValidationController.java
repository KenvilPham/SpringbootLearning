package com.learn.springboot.bindingdatademo.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import com.learn.springboot.bindingdatademo.model.Food;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class PathWithValidationController {
    
    @GetMapping("/api/food-validation")
    public String getFood(@RequestParam @Positive(message = "food id must be > 0") int id, @RequestParam @NotBlank String type, @RequestParam(required = false) String description) {
        return "Food id: " + id + ", type: " + type + ", description: " + (description == null ? "No description" : description);
    }

    @GetMapping("/city-validation/id/{id}")
    public String getCityID(@PathVariable(name = "id") @Min(5) int cityId) {
        return "City id: " + cityId;
    }

    @PostMapping("/api/foods-validation")
    public ResponseEntity<Food> createFood(@Valid @RequestBody Food food) {
        return ResponseEntity.ok(new Food(10, food.getFoodName(), food.getType(), food.getDescription()));
    }
}
