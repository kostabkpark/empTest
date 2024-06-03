package org.example.emptest.repository;

import org.example.emptest.entity.EmpType;
import org.example.emptest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> ,
                                            EmployeeRepositoryQuery {
//    List<Employee> findAll();
//    Optional<Employee> findById(String empId);
//    Employee save(Employee employee);
//    void deleteById(String empId);
    List<Employee> findAllBySalaryGreaterThanEqualAndEmpTypeAndDepartment_DeptId(int salary, EmpType empType, int departmentId);
}
