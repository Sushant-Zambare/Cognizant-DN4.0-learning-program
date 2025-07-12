package com.cognizant.spring_learn.service.impl;

import com.cognizant.spring_learn.dao.EmployeeDao;
import com.cognizant.spring_learn.exception.EmployeeNotFoundException;
import com.cognizant.spring_learn.model.Employee;
import com.cognizant.spring_learn.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee = employeeDao.getEmployee(id);
        if (employee == null) {
            throw new EmployeeNotFoundException("Employee with ID " + id + " not found");
        }
        return employee;
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        if (employeeDao.getEmployee(employee.getId()) == null) {
            throw new EmployeeNotFoundException("Cannot update. Employee with ID " + employee.getId() + " not found");
        }
        employeeDao.updateEmployee(employee);
    }

    @Override
    public void deleteEmployee(int id) {
        if (employeeDao.getEmployee(id) == null) {
            throw new EmployeeNotFoundException("Cannot delete. Employee with ID " + id + " not found");
        }
        employeeDao.deleteEmployee(id);
    }
}
