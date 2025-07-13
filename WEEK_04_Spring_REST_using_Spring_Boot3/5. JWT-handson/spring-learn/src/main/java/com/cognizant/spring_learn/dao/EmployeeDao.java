package com.cognizant.spring_learn.dao;

import com.cognizant.spring_learn.exception.EmployeeNotFoundException;
import com.cognizant.spring_learn.model.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class EmployeeDao {

    private final List<Employee> employeeList;

    public EmployeeDao() {
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        this.employeeList = new ArrayList<>((List<Employee>) context.getBean("employeeList"));
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployee(int id) {
        return employeeList.stream()
                .filter(emp -> emp.getId() == id)
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("Employee with ID " + id + " not found"));
    }

    public void addEmployee(Employee employee) {
        boolean exists = employeeList.stream()
                .anyMatch(emp -> Objects.equals(emp.getId(), employee.getId()));
        if (exists) {
            throw new EmployeeNotFoundException("Employee with ID " + employee.getId() + " already exists");
        }
        employeeList.add(employee);
    }


    public void updateEmployee(Employee employee) {
        int index = -1;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == employee.getId()) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            throw new EmployeeNotFoundException("Employee with ID " + employee.getId() + " not found");
        }
        employeeList.set(index, employee);
    }

    public void deleteEmployee(int id) {
        boolean removed = employeeList.removeIf(e -> e.getId() == id);
        if (!removed) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
    }
}
