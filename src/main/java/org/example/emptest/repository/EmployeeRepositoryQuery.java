package org.example.emptest.repository;

import org.example.emptest.dto.EmployeeSearchCond;
import org.example.emptest.entity.Employee;

import java.util.List;

public interface EmployeeRepositoryQuery {

    List<Employee> dynamicSearch(EmployeeSearchCond seachCond);
}
