package com.learn.springboot.employeethymleaf.service;

import java.util.List;

import com.learn.springboot.employeethymleaf.exception.ResourceNotFoundException;
import com.learn.springboot.employeethymleaf.model.Employee;
import com.learn.springboot.employeethymleaf.repository.IEmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class EmployeeServiceImp implements IEmployeeService{

    @Autowired
    private IEmployeeRepository repository;
    
    @Override
    public Iterable<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public List<Employee> search(String email) {
        return repository.findByEmailId(email);
    }

    @Override
    public Employee findById(Integer id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not have employee have id: " + id));
    }

    @Override
    public void save(Employee emp) {
        repository.save(emp);
        
    }

    @Override
    public void delete(Integer id) {
        Employee currentEmployee = this.findById(id);
        repository.delete(currentEmployee);
        
    }
    
}
