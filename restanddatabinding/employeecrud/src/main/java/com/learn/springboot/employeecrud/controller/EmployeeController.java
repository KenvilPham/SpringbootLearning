package com.learn.springboot.employeecrud.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.learn.springboot.employeecrud.model.Employee;
import com.learn.springboot.employeecrud.model.EmployeePOJO;
import com.learn.springboot.employeecrud.service.EmployeeServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api")
@Validated
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp serviceImp;

    @Operation(summary = "get all employees or get employee by email")
    @GetMapping(value = "/employees")
    public List<Employee> getEmployees(@RequestParam(name = "email", required = false) String emailId) {
        if (StringUtils.hasText(emailId)) {
            return serviceImp.findByEmailId(emailId);
        } else {
            return serviceImp.findAllEmployees();
        }
    }

    @Operation(summary = "get employee by Id")
    @GetMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id) {
        return ResponseEntity.ok().body(serviceImp.findById(id));
    }

    @Operation(summary = "add an employee")
    @PostMapping(value = "/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody EmployeePOJO employeePOJO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(serviceImp.saveEmployee(employeePOJO));
    }

    @Operation(summary = "update employee info")
    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<Employee> updateEmployeeInfo(@PathVariable(name = "id") long employeeId, @RequestBody EmployeePOJO employeePOJO) {
        return ResponseEntity.ok().body(serviceImp.updateEmployee(employeeId, employeePOJO));
    }

    @Operation(summary = "delete an employee by Id")
    @DeleteMapping(value = "/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(name = "id") long employeeId) {
        serviceImp.deleteById(employeeId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", true);
        return response;
    }

    @PatchMapping(value = "/employees/{id}")
    public ResponseEntity<Void> updateFirstName(@PathVariable(name = "id") long employeeId, @RequestBody String firstName) {
        serviceImp.updateFirstNameEmployee(employeeId, firstName);
        return ResponseEntity.ok().build();
    }
}
