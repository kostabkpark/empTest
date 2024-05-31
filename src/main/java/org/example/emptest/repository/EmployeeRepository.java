package org.example.emptest.repository;

import org.example.emptest.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    List<Employee> findAll();
    Optional<Employee> findById(String empId);
    Employee save(Employee employee);
    void deleteById(String empId);
}
