package com.learn.springboot.employeecrud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "employee")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @Size(min = 2, message = "First name should have atleast 2 characters")
    @NotNull
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(min = 2, message = "Last name should have atleast 2 characters")
    @NotNull
    private String lastName;

    @Column(name = "email_address", nullable = false)
    @NotBlank
    @Email
    private String emailId;

    @Column(name = "passport_number", nullable = false)
    @Size(min = 10, message = "Passport number should have atleast 10 characters")
    @NotNull
    private String passportNumber;

    public Employee(String firstName, String lastName, String emailId, String passportNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.passportNumber = passportNumber;
    }

    
}