package com.poc.liquibasedemo.service;

import com.poc.liquibasedemo.entity.Employee;
import com.poc.liquibasedemo.exception.EmployeeException;
import com.poc.liquibasedemo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee updatedEmployee, int employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);

        if(employee == null)
            throw new EmployeeException("Employee Not Found");

        Optional.ofNullable(updatedEmployee).ifPresent(emp -> {
            if(emp.getCompany() != null) {
                employee.setCompany(emp.getCompany());
            }
            if(emp.getEmail() != null) {
                employee.setEmail(emp.getEmail());
            }
            if(emp.getName() != null) {
                employee.setName(emp.getName());
            }
        });

        return employee;
    }
}
