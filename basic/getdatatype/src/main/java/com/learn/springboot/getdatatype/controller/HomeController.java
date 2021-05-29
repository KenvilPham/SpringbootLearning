package com.learn.springboot.getdatatype.controller;

import com.learn.springboot.getdatatype.service.JsonParserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
    @Autowired
    private JsonParserService jsonParserService;

    @ResponseBody
    @GetMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String getHome() {
        return "This is home page";
    }

    @ResponseBody
    @GetMapping(value = "/bookjson", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getJsonValue() {
        //return "{'book' : ['De men phieu luu ky', 'Mat biec']}";
        return "{'error': 'cannot return books'}";
    }

    @ResponseBody
    @GetMapping(value = "/bookxml", produces = MediaType.TEXT_XML_VALUE)
    public String getXmlValue() {
        return "<books><book>De men phieu luu ky</book><book>Cuon theo chieu gio</book></books>";
    }

    @ResponseBody
    @GetMapping(value = "/bookparser", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getListBook() {
        return jsonParserService.getBook();
    }

    @ResponseBody
    @GetMapping(value = "/car", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getListCar() {
        return jsonParserService.getCar();
    }

    @ResponseBody
    @GetMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
    public String getListPerson() {
        return jsonParserService.getPerson();
    }
}
