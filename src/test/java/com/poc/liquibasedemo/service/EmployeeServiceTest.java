package com.poc.liquibasedemo.service;

import com.poc.liquibasedemo.EmployeeMother;
import com.poc.liquibasedemo.entity.Employee;
import com.poc.liquibasedemo.exception.EmployeeException;
import com.poc.liquibasedemo.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeService employeeService;

    @Test
    void testGetEmployeeById_SUCCESS() {
        Employee employee = EmployeeMother.createEmployee();

        when(employeeRepository.findById(anyInt())).thenReturn(Optional.ofNullable(employee));

        Employee actualEmployee = assertDoesNotThrow(() -> employeeService.getEmployeeById(1));
        assertNotNull(actualEmployee);
        assertEquals(employee, actualEmployee);
    }

    @Test
    void testGetEmployeeById_EMPLOYEE_NOT_FOUND() {
        when(employeeRepository.findById(anyInt())).thenReturn(Optional.empty());

        assertThrows(EmployeeException.class, () -> employeeService.getEmployeeById(1));
    }

    @Test
    void testGetEmployeeById_EMPLOYEE_ID_IS_NULL() {
        when(employeeRepository.findById(anyInt())).thenThrow(IllegalArgumentException.class);

        assertThrows(IllegalArgumentException.class, () -> employeeService.getEmployeeById(1));
    }
}
