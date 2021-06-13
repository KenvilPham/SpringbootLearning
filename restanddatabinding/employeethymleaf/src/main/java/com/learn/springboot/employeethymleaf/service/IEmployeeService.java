package com.learn.springboot.employeethymleaf.service;

import java.util.List;

import com.learn.springboot.employeethymleaf.model.Employee;

public interface IEmployeeService {
    Iterable<Employee> findAll();

    List<Employee> search(String name);

    Employee findById(Integer id);

    void save(Employee emp);

    void delete(Integer id);
}
