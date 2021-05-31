package com.learn.springboot.componentdemo.controller;

import com.learn.springboot.componentdemo.component.ApplicationContextAwareDemoComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/firstController")
@Controller
public class ApplicationContextController {
    @Autowired
    private ApplicationContextAwareDemoComponent awareDemoComponent;

    @ResponseBody
    @GetMapping(value = "/appcontextaware", produces = MediaType.TEXT_HTML_VALUE)
    public String getAppContextDemo() {
        return awareDemoComponent.getBothApplicationContext();
    }
}
