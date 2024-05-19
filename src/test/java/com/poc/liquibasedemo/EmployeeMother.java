package com.poc.liquibasedemo;

import com.poc.liquibasedemo.entity.Employee;

public class EmployeeMother {

    public static Employee createEmployee() {
        return Employee.builder()
                .id(1)
                .name("Chandan")
                .email("chandan@test.com")
                .company("TestCompany")
                .build();
    }
}
