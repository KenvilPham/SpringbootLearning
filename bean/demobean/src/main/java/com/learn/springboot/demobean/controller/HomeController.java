package com.learn.springboot.demobean.controller;

import com.learn.springboot.demobean.bean.Car;
import com.learn.springboot.demobean.bean.FunRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Autowired
    private Car myCar;

    @Autowired
 //   @Qualifier("funrepoengine")
    private FunRepository funRepository;

    @ResponseBody
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String getHome() {
        return myCar.toString();
    }

    // @ResponseBody
    // @GetMapping(value = "/funrepo", produces = MediaType.TEXT_HTML_VALUE)
    // public String getFunRepo() {
    //     return myCar.toString();
    // }

}