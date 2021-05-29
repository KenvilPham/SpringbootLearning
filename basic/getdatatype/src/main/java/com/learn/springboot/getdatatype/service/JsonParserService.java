package com.learn.springboot.getdatatype.service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.springboot.getdatatype.model.Car;
import com.learn.springboot.getdatatype.model.Person;

import org.springframework.stereotype.Service;

@Service
public class JsonParserService {

    private ObjectMapper objectMapper = new ObjectMapper();

    public String getBook() {
        List<String> books = new ArrayList<>();
        books.add("De men phieu luu ky");
        books.add("Mat Biec");
        books.add("Cuon theo chieu gio");

        try {
            return objectMapper.writeValueAsString(books);
        } catch (Exception e) {
            return "{'error' : 'can not return books'}";
        }

    }

    public String getCar() {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("Xpander", "Mistubishi"));
        carList.add(new Car("Ranger", "Ford"));
        carList.add(new Car("Fadil", "VinFast"));
        carList.add(new Car("Camry", "Toyota"));

        try {
            return objectMapper.writeValueAsString(carList);
        } catch (Exception e) {
            return "{'error' : '" + e.toString() + "'}";
        }
    }

    public String getPerson() {
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Sang", 28, "kenvil.pham92@gmail.com"));
        personList.add(new Person("Minh", 31, "kenvil.pham93@gmail.com"));
        personList.add(new Person("Dung", 29, "kenvil.pham94@gmail.com"));
        personList.add(new Person("Khoa", 4, "kenvil.pham95@gmail.com"));

        try {
            return objectMapper.writeValueAsString(personList);
        } catch (Exception e) {
            return "{'error' : '" + e.toString() + "'}";
        }
    }
}
