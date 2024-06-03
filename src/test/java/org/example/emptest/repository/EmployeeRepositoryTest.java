package org.example.emptest.repository;

import org.assertj.core.api.Assertions;
import org.example.emptest.entity.EmpType;
import org.example.emptest.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class EmployeeRepositoryTest {
    @Autowired
    EmployeeRepository employeeRepository;
    @Test
    void 부서_사원코드_급여() {
        List<Employee> emps =
                employeeRepository.findAllBySalaryGreaterThanEqualAndEmpTypeAndDepartment_DeptId(
                300, EmpType.B, 2
        );
        assertThat(emps.size()).isEqualTo(1);
    }

}