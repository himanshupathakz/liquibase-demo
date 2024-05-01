package com.poc.liquibasedemo.controller;

import com.poc.liquibasedemo.entity.Employee;
import com.poc.liquibasedemo.exception.EmployeeException;
import com.poc.liquibasedemo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") int employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @PostMapping
    public ResponseEntity addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{empId}")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee updatedEmployee, @PathVariable("empId") int employeeId) {
        try {
            return ResponseEntity.ok(employeeService.updateEmployee(updatedEmployee, employeeId));
        } catch (EmployeeException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
