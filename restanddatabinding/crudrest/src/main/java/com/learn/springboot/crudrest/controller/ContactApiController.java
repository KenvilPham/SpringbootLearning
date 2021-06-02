package com.learn.springboot.crudrest.controller;

import java.util.List;

import com.learn.springboot.crudrest.model.Contact;
import com.learn.springboot.crudrest.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/api/contacts")
public class ContactApiController {
    @Autowired
    private ContactRepository contactRepository;
  
    @Operation(summary = "Get all contacts")
    @GetMapping(value = "/")
    public ResponseEntity<List<Contact>> findAllContacts() {
       List<Contact> contacts = contactRepository.findAll();
      return ResponseEntity.ok(contacts);
    }
}
