package com.poc.liquibasedemo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee")
public class Employee {
    @Id
    @Column(name = "empId")
    private int id;

    @Column(name = "empName")
    private String name;

    @Column(name = "empCompany")
    private String company;

    @Column(name = "empEmail")
    private String email;
}
