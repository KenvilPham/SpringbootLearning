package com.learn.springboot.employeecrud.repository;

import java.util.List;

import com.learn.springboot.employeecrud.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByEmailId(String emailId);
}