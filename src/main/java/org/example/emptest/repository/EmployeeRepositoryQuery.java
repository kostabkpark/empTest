package org.example.emptest.repository;

import org.example.emptest.dto.EmployeeDepartmentDto;
import org.example.emptest.dto.EmployeeSearchCond;
import org.example.emptest.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeRepositoryQuery {

    List<Employee> dynamicSearch(EmployeeSearchCond seachCond);
    Page<EmployeeDepartmentDto> dynamicSearchPagination(EmployeeSearchCond seachCond, Pageable pageable);
}
