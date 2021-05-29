package com.learning.springboot.recordexample.controller;

import java.util.ArrayList;
import java.util.List;

import com.learning.springboot.recordexample.model.Colour;
import com.learning.springboot.recordexample.model.Person;
import com.learning.springboot.recordexample.service.ColourService;
import com.learning.springboot.recordexample.service.IService;
import com.learning.springboot.recordexample.service.PersonService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ApiController {
    private final Logger logger;

    @Autowired
    private PersonService personService;

    @Autowired
    private ColourService colourService;

    public ApiController(Logger logger) {
        this.logger = logger;
    }

    @ResponseBody
    @GetMapping(value = "/person", produces = MediaType.TEXT_HTML_VALUE)
    public List<Person> getPerson() {
		ArrayList<Person> people = new ArrayList<>();
		people.add(new Person(1, "Trịnh Minh Cường", "fdgsdfg"));
		people.add(new Person(2, "Đoàn Xuân Dũng", "fdgsdfg"));
		people.add(new Person(3, "Phạm Nhật Vượng", "fdgsdfg"));
		return people;
    }

    @ResponseBody
    @GetMapping("/")
    public List<Colour> getHome() {
        return colourService.getAllItemObject();
    }
}
