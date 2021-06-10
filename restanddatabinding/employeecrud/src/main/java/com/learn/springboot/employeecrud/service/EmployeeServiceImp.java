package com.learn.springboot.employeecrud.service;

import java.util.List;

import com.learn.springboot.employeecrud.exception.ResourceNotFoundException;
import com.learn.springboot.employeecrud.model.Employee;
import com.learn.springboot.employeecrud.model.EmployeePOJO;
import com.learn.springboot.employeecrud.repository.IEmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImp implements IEmployeeService {

    @Autowired
    private IEmployeeRepository repository;

    @Override
    public List<Employee> findAllEmployees() {
        return repository.findAll();
    }

    @Override
    public List<Employee> findByEmailId(String emailId) {
        return repository.findByEmailId(emailId);
    }

    @Override
    public Employee findById(long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not found this employee have id: " + id));
    }

    @Override
    public Employee saveEmployee(EmployeePOJO employeePOJO) {
        Employee newEmployee = new Employee(employeePOJO.getFirstName(), employeePOJO.getLastName(),
                employeePOJO.getEmailId(), employeePOJO.getPassportNumber());
        return repository.save(newEmployee);
    }

    @Override
    public Employee updateEmployee(long id, EmployeePOJO employeePOJO) {
        Employee currentEmployee = this.findById(id);
        currentEmployee.setFirstName(employeePOJO.getFirstName());
        currentEmployee.setLastName(employeePOJO.getLastName());
        currentEmployee.setEmailId(employeePOJO.getEmailId());
        currentEmployee.setPassportNumber(employeePOJO.getPassportNumber());

        return repository.save(currentEmployee);
    }

    @Override
    public void deleteById(long id) {
        Employee curEmployee = this.findById(id);
        repository.delete(curEmployee);
    }

    @Override
    public void updateFirstNameEmployee(long id, String firstName) {
        Employee currentEmployee = this.findById(id);
        currentEmployee.setFirstName(firstName);
        repository.save(currentEmployee);
    }

    

}