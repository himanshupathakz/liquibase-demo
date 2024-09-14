package com.poc.liquibasedemo.service;

import com.poc.liquibasedemo.controller.EmployeeController;
import com.poc.liquibasedemo.entity.Employee;
import com.poc.liquibasedemo.exception.EmployeeException;
import com.poc.liquibasedemo.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

	/*
	 * public Employee getEmployeeById(int employeeId) { try { Optional<Employee>
	 * employee = employeeRepository.findById(employeeId); if (employee.isPresent())
	 * { log.info("Employee: {}", employee.get()); return employee.get(); } else {
	 * log.error("Employee Not found!"); throw new
	 * EmployeeException("Employee not found!"); } } catch (IllegalArgumentException
	 * ex) { log.error("EmployeeId is null, please pass a valid ID"); throw ex; } }
	 * 
	 * public void addEmployee(Employee employee) {
	 * employeeRepository.save(employee); }
	 */

	/*
	 * public Employee updateEmployee(Employee updatedEmployee, int employeeId) {
	 * Employee employee = employeeRepository.findById(employeeId).orElse(null);
	 * 
	 * if(employee == null) throw new EmployeeException("Employee Not Found");
	 * 
	 * Optional.ofNullable(updatedEmployee).ifPresent(emp -> { if(emp.getCompany()
	 * != null) { employee.setCompany(emp.getCompany()); } if(emp.getEmail() !=
	 * null) { employee.setEmail(emp.getEmail()); } if(emp.getName() != null) {
	 * employee.setName(emp.getName()); } });
	 */
       

	/*
	 * return employee; }
	 */
}
