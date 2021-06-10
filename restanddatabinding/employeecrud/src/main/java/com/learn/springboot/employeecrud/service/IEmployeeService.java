package com.learn.springboot.employeecrud.service;

import java.util.List;

import com.learn.springboot.employeecrud.model.Employee;
import com.learn.springboot.employeecrud.model.EmployeePOJO;

public interface IEmployeeService {
    List<Employee> findAllEmployees();

    List<Employee> findByEmailId(String emailId);

    Employee findById(long id);

    Employee saveEmployee(EmployeePOJO employeePOJO);

    Employee updateEmployee(long id, EmployeePOJO employeePOJO);

    void deleteById(long id);

    void updateFirstNameEmployee(long id, String firstName);
}