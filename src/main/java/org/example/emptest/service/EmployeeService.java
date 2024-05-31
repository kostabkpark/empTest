package org.example.emptest.service;

import lombok.RequiredArgsConstructor;
import org.example.emptest.dto.EmployeeInquiryDto;
import org.example.emptest.dto.EmployeeUpdateDto;
import org.example.emptest.entity.Employee;
import org.example.emptest.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(String empId) {
        return employeeRepository.findById(empId).get();
    }

    @Transactional
    public void deleteEmployeeById(String empId) {
        employeeRepository.deleteById(empId);
    }

    @Transactional
    public Employee addEmployee(Employee employee) {
        Employee savedEmp = employeeRepository.save(employee);
        return savedEmp;
    }

    @Transactional
    public Employee updateEmployee(EmployeeUpdateDto employeeDto) {
        Employee employee = employeeRepository.findById(employeeDto.getEmpId()).get();
        employee.setSalary(employeeDto.getSalary());
        //employee.setDepartment(employeeDto.getDepartment());
        Employee updateEmployee = employeeRepository.save(employee);
        return updateEmployee;
    }
}
