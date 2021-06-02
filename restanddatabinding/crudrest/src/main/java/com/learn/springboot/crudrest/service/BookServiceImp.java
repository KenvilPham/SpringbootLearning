package com.learn.springboot.crudrest.service;

import java.util.List;
import java.util.Optional;

import com.learn.springboot.crudrest.model.Book;
import com.learn.springboot.crudrest.model.BookPOJO;
import com.learn.springboot.crudrest.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImp implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> findAll() {
        // TODO Auto-generated method stub
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        // TODO Auto-generated method stub
        return bookRepository.findById(id);
    }

    @Override
    public Book save(BookPOJO book) {
        // TODO Auto-generated method stub
        Book newBook = new Book(book.getTitle(), book.getAuthor());
        return bookRepository.save(newBook);
    }

    @Override
    public void update(long id, BookPOJO book) {
        // TODO Auto-generated method stub
        Book updateBook = new Book(id, book.getTitle(), book.getAuthor());
        if(this.findById(id).isPresent()) {
            bookRepository.save(updateBook);
        } else {
            throw new ResourceNotFoundException();
        }
        
    }

    @Override
    public void updateTitle(long id, String title) {
        // TODO Auto-generated method stub
        if (this.findById(id).isPresent()) {
            Book currentBook = this.findById(id).get();
            currentBook.setTitle(title);
            bookRepository.save(currentBook);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public void updateAthor(long id, String author) {
        // TODO Auto-generated method stub
        if (this.findById(id).isPresent()) {
            Book currentBook = this.findById(id).get();
            currentBook.setAuthor(author);
            bookRepository.save(currentBook);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public void deleteById(long id) {
        // TODO Auto-generated method stub
        if(this.findById(id).isPresent()) {
            bookRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException();
        }
    }
    
}
