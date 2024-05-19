package com.poc.liquibasedemo.controller;

import com.poc.liquibasedemo.EmployeeMother;
import com.poc.liquibasedemo.entity.Employee;
import com.poc.liquibasedemo.exception.EmployeeException;
import com.poc.liquibasedemo.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeControllerTest {
    @Mock
    EmployeeService employeeService;

    @InjectMocks
    EmployeeController employeeController;

    @Test
    void testGetEmployeeById_SUCCESS() {
        Employee employee = EmployeeMother.createEmployee();

        when(employeeService.getEmployeeById(anyInt())).thenReturn(employee);

        ResponseEntity<Employee> response = assertDoesNotThrow(() -> employeeController.getEmployeeById(1));
        assertNotNull(response);
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    void testGetEmployeeById_EMPLOYEE_NOT_FOUND() {
       when(employeeService.getEmployeeById(anyInt())).thenThrow(EmployeeException.class);

        ResponseEntity<Employee> response = assertDoesNotThrow(() -> employeeController.getEmployeeById(1));
        assertNotNull(response);
        assertTrue(response.getStatusCode().is4xxClientError());
    }
}
