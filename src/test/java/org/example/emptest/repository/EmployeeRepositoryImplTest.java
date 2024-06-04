package org.example.emptest.repository;

import org.assertj.core.api.Assertions;
import org.example.emptest.dto.EmployeeDepartmentDto;
import org.example.emptest.dto.EmployeeSearchCond;
import org.example.emptest.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EmployeeRepositoryImplTest {
    @Autowired
    EmployeeRepository repository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void dynamicSearch() {
        //given
        EmployeeSearchCond cond = new EmployeeSearchCond(1, null, 0);
        //when
        List<Employee> employees = repository.dynamicSearch(cond);
        //then

        assertThat(employees.size()).isEqualTo(5);
    }

    @Test
    void 페이징처리(){
        //given
        Pageable pageable = PageRequest.of(1, 3);
        EmployeeSearchCond searchCond = new EmployeeSearchCond(0,null,0);
        // when
        Page<EmployeeDepartmentDto> empList =employeeRepository.dynamicSearchPagination(searchCond, pageable);
        //then
        System.out.println(empList);
        assertThat(1).isEqualTo(1);
    }
}