package com.learn.springboot.crudrest.service;

import java.util.List;
import java.util.Optional;

import com.learn.springboot.crudrest.model.Book;
import com.learn.springboot.crudrest.model.BookPOJO;

public interface IBookService {
    List<Book> findAll();
    Optional<Book> findById(Long id);
    Book save(BookPOJO book);
    void update(long id, BookPOJO book);
    void updateTitle(long id, String title);
    void updateAthor(long id, String author);
    void deleteById(long id);
}
