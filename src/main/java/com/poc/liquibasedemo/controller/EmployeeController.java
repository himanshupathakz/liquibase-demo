package com.poc.liquibasedemo.controller;

import com.poc.liquibasedemo.entity.Employee;
import com.poc.liquibasedemo.exception.EmployeeException;
import com.poc.liquibasedemo.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{empId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("empId") int employeeId) {
        try {
            return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
        } catch (EmployeeException ex) {
            log.error(ex.getMessage());
            return ResponseEntity.notFound().build();
        } catch (Exception ex) {
            log.error("Something went wrong while fetching Employee", ex);
            return ResponseEntity.internalServerError().build();
        }

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
