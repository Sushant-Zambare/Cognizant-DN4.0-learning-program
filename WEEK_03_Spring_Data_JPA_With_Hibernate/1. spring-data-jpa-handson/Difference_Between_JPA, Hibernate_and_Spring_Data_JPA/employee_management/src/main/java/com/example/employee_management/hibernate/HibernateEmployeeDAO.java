package com.example.employee_management.hibernate;

import com.example.employee_management.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateEmployeeDAO {

    private static SessionFactory factory;

    static {
        factory = new Configuration().configure().buildSessionFactory();
    }

    public Integer addEmployee(Employee employee) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Integer employeeID = (Integer) session.save(employee);
        tx.commit();
        session.close();
        return employeeID;
    }

    public List<Employee> getEmployees() {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        List<Employee> employees = session.createQuery("FROM Employee", Employee.class).list();
        tx.commit();
        session.close();
        return employees;
    }

    public void updateEmployee(Integer employeeID, Double salary) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Employee employee = session.get(Employee.class, employeeID);
        employee.setSalary(salary);
        session.update(employee);
        tx.commit();
        session.close();
    }

    public void deleteEmployee(Integer employeeID) {
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        Employee employee = session.get(Employee.class, employeeID);
        session.delete(employee);
        tx.commit();
        session.close();
    }
}