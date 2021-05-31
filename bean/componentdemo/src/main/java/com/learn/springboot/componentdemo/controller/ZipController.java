package com.learn.springboot.componentdemo.controller;

import com.learn.springboot.componentdemo.component.ZipComponent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/secondController")
@Controller
public class ZipController {
    @Autowired
    private ZipComponent zipComponent1;

    @Autowired
    private ZipComponent zipComponent2;

    private ZipComponent zipComponent3;

    @Autowired
    private ApplicationContext appContext;

    @ResponseBody
    @GetMapping(value = "/appcontext", produces = MediaType.TEXT_HTML_VALUE)
    public String getHome() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Display name: " + appContext.getDisplayName() + "<br><br>");
        String[] allBeanName = appContext.getBeanDefinitionNames();

        for (String str : allBeanName) {
            stringBuilder.append(str + "<br>");
        }

        return stringBuilder.toString();
    }

    @ResponseBody
    @GetMapping(value = "/zipcomponent", produces = MediaType.TEXT_HTML_VALUE)
    public String getZipComponent() {
        StringBuilder stringBuilder = new StringBuilder();
        zipComponent3 = new ZipComponent();

        stringBuilder.append("zipcompoent1: " + zipComponent1.toString() + "<br>");
        stringBuilder.append("zipcompoent2: " + zipComponent2.toString() + "<br>");
        stringBuilder.append("zipcompoent3: " + zipComponent3.toString());

        return stringBuilder.toString();
    }
}
