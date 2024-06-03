package org.example.emptest.repository;

import org.assertj.core.api.Assertions;
import org.example.emptest.dto.EmployeeSearchCond;
import org.example.emptest.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class EmployeeRepositoryImplTest {
    @Autowired
    EmployeeRepository repository;

    @Test
    void dynamicSearch() {
        //given
        EmployeeSearchCond cond = new EmployeeSearchCond(1, null, 0);
        //when
        List<Employee> employees = repository.dynamicSearch(cond);
        //then
        Assertions.assertThat(employees.size()).isEqualTo(5);
    }
}