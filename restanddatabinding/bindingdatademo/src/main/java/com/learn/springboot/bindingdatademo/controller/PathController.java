package com.learn.springboot.bindingdatademo.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class PathController {
    @GetMapping("/city/{city}")
    public String getCityName(@PathVariable("city") String cityNames) {
        return "getCityName() - City name: " + cityNames;
    }

    @GetMapping("/city/id/{cityId}")
    public String getCityID(@PathVariable int cityId) {
        return "getCityID() - City id: " + cityId;
    }

    @GetMapping("/city/{country}/{city}")
    public String getCity(@PathVariable(value = "country",required = false) String countryName, @PathVariable(value = "city") String cityName) {
        return "getCity() - City name: " + cityName + (countryName == null ? "" : " of country: " + countryName);
    }

    @GetMapping("/food")
    public String getFoodByIdQueryParam(@RequestParam String id) {
        return "Food id: " + id;
    }


    @GetMapping("/foods")
    public String getFoodByIdAndType(@RequestParam(value = "id") String foodId, @RequestParam String type) {
        return "Food id: " + foodId + ", type: " + type;
    }
}
