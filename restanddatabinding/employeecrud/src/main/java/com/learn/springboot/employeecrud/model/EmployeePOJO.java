package com.learn.springboot.employeecrud.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class EmployeePOJO {
    @Size(min = 2, message = "First name should have atleast 2 characters")
    @NotNull
    private String firstName;

    @Size(min = 2, message = "Last name should have atleast 2 characters")
    @NotNull
    private String lastName;

    @NotBlank
    @Email
    private String emailId;

    @Size(min = 10, message = "Passport number should have atleast 10 characters")
    @NotNull
    private String passportNumber;
}