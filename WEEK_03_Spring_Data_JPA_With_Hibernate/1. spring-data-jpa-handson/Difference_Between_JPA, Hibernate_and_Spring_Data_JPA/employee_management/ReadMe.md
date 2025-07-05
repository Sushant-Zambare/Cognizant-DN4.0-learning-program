# Employee Management System

A Spring Boot application demonstrating the differences between **JPA**, **Hibernate**, and **Spring Data JPA** through a simple employee management system.

##  Project Overview

This project showcases three different approaches to data persistence in Java:
- **Pure Hibernate** with manual session management
- **Spring Data JPA** with repository pattern
- **JPA** specifications implemented through both approaches

- Demonstrates CRUD operations using different persistence approaches

##  Key Differences

### JPA (Java Persistence API)
- A specification/standard for ORM in Java
- Defines interfaces and annotations
- Requires an implementation (like Hibernate)

### Hibernate
- A popular ORM framework and JPA implementation
- Manual session management
- Direct control over transactions
- More configuration required

**Example from project:**
- Manual session and transaction management
- Session session = factory.openSession();
- Transaction tx = session.beginTransaction();
- Integer employeeID = (Integer) session.save(employee);
- tx.commit();
- session.close();

### Spring Data JPA
- Spring's abstraction layer over JPA
- Repository pattern implementation
- Automatic transaction management
- Query methods from method names

**Example from project:**

- public interface EmployeeRepository extends JpaRepository<Employee, Integer>
    - List<Employee> findByFirstName(String firstName);
    - List<Employee> findBySalaryGreaterThan(Double salary);

