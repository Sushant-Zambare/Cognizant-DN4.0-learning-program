package com.example.employee_management;

import com.example.employee_management.model.Employee;
import com.example.employee_management.springdata.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJPATest implements CommandLineRunner {

    private final EmployeeService employeeService;

    public SpringDataJPATest(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJPATest.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Employee emp1 = new Employee("Sushant", "Zambare", "sushant@example.com", 50000.0);
        Employee emp2 = new Employee("Yash", "Dutonde", "yash@example.com", 60000.0);

        employeeService.addEmployee(emp1);
        employeeService.addEmployee(emp2);

        System.out.println("All Employees:");
        employeeService.getEmployees().forEach(System.out::println);

        System.out.println("Employees named John:");
        employeeService.findByFirstName("Sushant").forEach(System.out::println);

        System.out.println("High salary employees (>55000):");
        employeeService.findHighSalaryEmployees(55000.0).forEach(System.out::println);
    }
}