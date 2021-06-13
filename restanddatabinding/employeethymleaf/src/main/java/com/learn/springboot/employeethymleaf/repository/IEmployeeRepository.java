package com.learn.springboot.employeethymleaf.repository;

import java.util.List;

import com.learn.springboot.employeethymleaf.model.Employee;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, Integer>{
    List<Employee> findByName(String name);
}
