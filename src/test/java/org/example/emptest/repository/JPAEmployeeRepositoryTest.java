package org.example.emptest.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.example.emptest.entity.EmpType;
import org.example.emptest.entity.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JPAEmployeeRepositoryTest {
    //@PersistenceContext
//    @Autowired
//    EntityManager em;

    @Autowired
    EmployeeRepository employeeRepository ;
    //= new JPAEmployeeRepository(em);
       
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void 전체사원정보가져오기() {
        //given
        //when
        List<Employee> all = employeeRepository.findAll();
        //then
        assertThat(all.size()).isEqualTo(5);
    }

    @Test
    void 사원정보저장() {
        //given
        Employee employee = new Employee(1, "test", null, EmpType.A, "2024-05-24", 100L, null);
        //when
        Employee saved = employeeRepository.save(employee);
        Employee byId = employeeRepository.findById(1).get();
        //then
        assertThat(byId.getEmpId()).isEqualTo(saved.getEmpId());
    }

    @Test
    void deleteById() {
        //given
        //when
        //then
    }
}