package com.learn.springboot.crudrest.repository;
import com.learn.springboot.crudrest.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
