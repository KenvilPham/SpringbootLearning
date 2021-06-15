package com.learn.springboot.employeethymleaf.repository;

import java.util.List;

import com.learn.springboot.employeethymleaf.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer>{
    List<Employee> findByEmailId(String email);
}
