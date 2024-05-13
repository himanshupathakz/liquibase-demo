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
@Table(name = "student")
public class Student {
    @Id
    @Column(name = "stuId")
    private int id;

    @Column(name = "stuName")
    private String name;

    @Column(name = "stuSchool")
    private String school;

    @Column(name = "stuEmail")
    private String email;

    @Column(name = "stuMarks")
    private int marks;
}
