package com.learn.springboot.bookcollection.controller;

import java.util.ArrayList;
import java.util.List;

import com.learn.springboot.bookcollection.model.Book;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookStoreController {

    @Value("${spring.application.name}")
    private String appName;

    static final String APP_NAME = "app_name";
    static final String BOOK_LIST = "book_list";

    @GetMapping(value = "/")
    public String getHomePage(Model model) {
        model.addAttribute(APP_NAME, appName);
        return "home";
    }

    @GetMapping(value = "/about")
    public String getAboutPage(Model model) {
        model.addAttribute(APP_NAME, appName);
        return "about";
    }

    @GetMapping(value = "/book1")
    public String getBook(Model model) {
        List<String> books = new ArrayList<>();
        books.add("Deep work");
        books.add("Nha gia kim");
        books.add("Dev up");
        books.add("Ong gia va bien ca");

        model.addAttribute(APP_NAME, appName);
        model.addAttribute(BOOK_LIST, books);
        return "book1";
    }

    @GetMapping(value = "/book2")
    public String getBook2(Model model) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Cafe cung tony", "Tony"));
        books.add(new Book(2, "DevUp", "Hien Nguyen"));
        books.add(new Book(3, "Doi thua", "Nam Cao"));

        model.addAttribute(APP_NAME, appName);
        model.addAttribute(BOOK_LIST, books);
        return "book2";
    }

    @GetMapping(value = "/book3")
    public String getBook3(Model model) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Cafe cung tony", "Tony"));
        books.add(new Book(2, "De men phieu luu ky", "To Hoai"));
        books.add(new Book(3, "DevUp", "Hien Nguyen"));
        books.add(new Book(4, "Ong gia va bien ca", "HeMingway"));

        model.addAttribute(APP_NAME, appName);
        model.addAttribute(BOOK_LIST, books);
        return "book3";
    }

    @GetMapping(value = "/book4")
    public String getBook4(Model model) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Cafe cung tony", "Tony"));
        books.add(new Book(2, "De men phieu luu ky", "To Hoai"));
        books.add(new Book(3, "DevUp", "Hien Nguyen"));
        books.add(new Book(4, "Ong gia va bien ca", "HeMingway"));

        model.addAttribute(APP_NAME, appName);
        model.addAttribute(BOOK_LIST, books);
        return "book4";
    }

    @GetMapping(value = "/book5")
    public String getBook5(Model model) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Cafe cung tony", "Tony"));
        books.add(new Book(2, "De men phieu luu ky", "To Hoai"));
        books.add(new Book(3, "DevUp", "Hien Nguyen"));
        books.add(new Book(4, "Ong gia va bien ca", "HeMingway"));

        model.addAttribute(APP_NAME, appName);
        model.addAttribute(BOOK_LIST, books);
        return "book5";
    }
}
