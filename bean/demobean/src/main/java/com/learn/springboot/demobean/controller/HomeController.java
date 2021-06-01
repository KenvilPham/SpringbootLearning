package com.learn.springboot.demobean.controller;

import com.learn.springboot.demobean.bean.Car;
import com.learn.springboot.demobean.bean.FunRepository;
import com.learn.springboot.demobean.bean.StreetMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Autowired
    private Car myCar;

    @Autowired
    private FunRepository funRepository;

    @ResponseBody
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String getHome() {
        return myCar.toString();
    }

    @ResponseBody
    @GetMapping(value = "/streetroute", produces = MediaType.TEXT_HTML_VALUE)
    public String getStreetRoute() {
        return myCar.navigation();
    }

}