package com.learning.springboot.recordexample.controller;
import java.time.LocalDateTime;
import java.util.List;

import com.learning.springboot.recordexample.model.Color;
import com.learning.springboot.recordexample.model.Colour;
import com.learning.springboot.recordexample.model.Person;
import com.learning.springboot.recordexample.service.ColorServiceImp;
import com.learning.springboot.recordexample.service.ColourServiceImp;
import com.learning.springboot.recordexample.service.PersonServiceImp;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class ApiController {
    private final Logger logger;

    @Autowired
    private PersonServiceImp personService;

    @Autowired
    private ColourServiceImp colourService;

    @Autowired
    private ColorServiceImp colorServiceImp;

    public ApiController(Logger logger) {
        this.logger = logger;
    }

    @ResponseBody
    @GetMapping("/person")
    public List<Person> getPersons() {
        logger.info("Get all person from list at {}", LocalDateTime.now());
		return personService.getAllItemObject();
    }

    @ResponseBody
    @GetMapping("/colour")
    public List<Colour> getColours() {
        logger.info("Get all Colours from list at {}", LocalDateTime.now());
        return colourService.getAllItemObject();
    }

    @ResponseBody
    @GetMapping("/color")
    public List<Color> getColors() {
        logger.info("Get all Color from list at {}", LocalDateTime.now());
        return colorServiceImp.getAllItemObject();
    }
}
