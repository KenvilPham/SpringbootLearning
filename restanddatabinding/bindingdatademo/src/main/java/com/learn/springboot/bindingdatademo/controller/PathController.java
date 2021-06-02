package com.learn.springboot.bindingdatademo.controller;

import java.util.Map;

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
public class PathController {
    // http://localhost:8080/city/hanoi
    @GetMapping("/city/{city}")
    public String getCityName(@PathVariable("city") String cityNames) {
        return "getCityName() - City name: " + cityNames;
    }

    // http://localhost:8080/city/id/1
    @GetMapping("/city/id/{cityId}")
    public String getCityID(@PathVariable int cityId) {
        return "getCityID() - City id: " + cityId;
    }

    // http://localhost:8080/city/vietnam/hanoi
    @GetMapping("/city/{country}/{city}")
    public String getCity(@PathVariable(name = "country", required = false) String countryName,
            @PathVariable(name = "city") String cityName) {
        return "getCity() - City name: " + cityName + (countryName == null ? "" : " of country: " + countryName);
    }

    // http://localhost:8080/food?id=abc
    @GetMapping("/food")
    public String getFoodByIdQueryParam(@RequestParam String id) {
        return "Food id: " + id;
    }

    // http://localhost:8080/foods?id=abc&type=mexico
    @GetMapping("/foods")
    public String getFoodByIdAndType(@RequestParam(name = "id") String foodId, @RequestParam String type) {
        return "Food id: " + foodId + ", type: " + type;
    }

    // http://localhost:8080/foods-plus?id=abc&type=mexico
    @GetMapping("/foods-plus")
    public String getFoodByIdAndTypeAndDescription(@RequestParam(name = "id") String foodId, @RequestParam String type,
            @RequestParam(required = false) String description) {
        return "Food id: " + foodId + ", Type: " + type + ", Description: "
                + (description == null ? "No description" : description);
    }

    // http://localhost:8080//api/foos?id=abc&type=mexico
    @GetMapping("/api/foos")
    public String getFoos(@RequestParam Map<String, String> allParams) {
        return "All params is: " + allParams.entrySet();
    }

    @PostMapping("/api/foods")
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        return ResponseEntity.ok(new Food(10, food.getFoodName(), food.getType(), food.getDescription()));
    }
}
