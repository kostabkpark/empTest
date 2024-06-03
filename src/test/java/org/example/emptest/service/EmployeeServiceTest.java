package org.example.emptest.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.example.emptest.entity.EmpType;
import org.example.emptest.entity.Employee;
import org.example.emptest.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    void 사원정보저장(){
        //given
        //Employee employee = new Employee("202470", "test", "test", EmpType.A, "2024-05-24", 100L);
        //when
        //employeeService.addEmployee(employee);
        Employee employeeById = employeeService.getEmployeeById(1);
        //then
        assertThat(employeeById.getEmpId()).isEqualTo("202470");
    }
}