package com.cognizant.employee.model;

import lombok.Data;

import java.util.List;

@Data
public class Employee {
    private int id;
    private String name;
    private Department department;
    private List<String> skills;
}
