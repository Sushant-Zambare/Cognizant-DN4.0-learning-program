package com.example.employee_management;

import com.example.employee_management.hibernate.HibernateEmployeeDAO;
import com.example.employee_management.model.Employee;

import java.util.List;

public class HibernateTest {

    public static void main(String[] args) {
        HibernateEmployeeDAO dao = new HibernateEmployeeDAO();

        Employee emp1 = new Employee("Sushant", "Zambare", "sushant@example.com", 50000.0);
        Employee emp2 = new Employee("Yash", "Dutonde", "yash@example.com", 60000.0);

        Integer id1 = dao.addEmployee(emp1);
        Integer id2 = dao.addEmployee(emp2);

        List<Employee> employees = dao.getEmployees();
        System.out.println("All Employees:");
        employees.forEach(System.out::println);

        dao.updateEmployee(id1, 55000.0);

        dao.deleteEmployee(id2);

        employees = dao.getEmployees();
        System.out.println("After operations:");
        employees.forEach(System.out::println);
    }
}