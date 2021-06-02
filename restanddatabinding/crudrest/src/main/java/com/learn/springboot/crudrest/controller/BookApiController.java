package com.learn.springboot.crudrest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.learn.springboot.crudrest.model.Book;
import com.learn.springboot.crudrest.model.BookPOJO;
import com.learn.springboot.crudrest.service.IBookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book-api")
public class BookApiController {
    
    @Autowired
    private IBookService service;

    @GetMapping(value = "/allbooks")
    public ResponseEntity<List<Book>> findAllBook() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/books/{bookId}")
    public ResponseEntity<Book> findBookById(@PathVariable long bookId) {
        if (service.findById(bookId).isPresent()) {
            return ResponseEntity.ok(service.findById(bookId).get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


    @PostMapping("/books")
    public ResponseEntity<Book> addBook(@RequestBody BookPOJO bookPOJO) {
        Book newBook = service.save(bookPOJO);
        try {
            return ResponseEntity.created(new URI("/book-api/books/" + newBook.getId())).body(newBook);
        } catch (URISyntaxException e) {
            //TODO: handle exception
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/books/{bookId}")
    public ResponseEntity<Void> updateBook(@RequestBody BookPOJO bookPOJO, @PathVariable long bookId) {
        try {
            service.update(bookId, bookPOJO);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            //TODO: handle exception
            return ResponseEntity.notFound().build();
        }
    }


    @PatchMapping("/books/{bookId}")
    public ResponseEntity<Void> updateBookTitle(@RequestBody String title, @PathVariable long bookId) {
        try {
            service.updateTitle(bookId, title);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            //TODO: handle exception
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/bookss/{bookId}")
    public ResponseEntity<Void> updateBookAuthor(@RequestBody String author, @PathVariable long bookId) {
        try {
            service.updateAthor(bookId, author);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            //TODO: handle exception
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(path = "/books/{bookId}")
    public ResponseEntity<Void> deleteBookById(@PathVariable long bookId) {
        try {
            service.deleteById(bookId);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException e) {
            //TODO: handle exception
            return ResponseEntity.notFound().build();
        }
    }
}
