package com.learning.springboot.recordexample.service;

import java.util.ArrayList;
import java.util.List;

import com.learning.springboot.recordexample.model.Person;

import org.springframework.stereotype.Service;

@Service
public class PersonService implements IService<Person> {

    @Override
    public List<Person> getAllItemObject() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Pham Duc Sang", "kenvil.pham@gamil.com"));
        persons.add(new Person(2, "Phan Duy Dang", "kenvil.pham@gamil.com"));
        persons.add(new Person(3, "Pham Duc Minh", "kenvil.pham@gamil.com"));
        persons.add(new Person(4, "Tran Duc Hoa", "kenvil.pham@gamil.com"));
        return persons;
    }
    
}
