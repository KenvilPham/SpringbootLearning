package com.learn.springboot.crudrest.repository;

import com.learn.springboot.crudrest.model.Contact;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    
}
