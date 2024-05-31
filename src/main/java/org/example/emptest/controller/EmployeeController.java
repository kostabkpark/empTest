package org.example.emptest.controller;

import org.example.emptest.dto.EmployeeInquiryDto;
import org.example.emptest.dto.EmployeeUpdateDto;
import org.example.emptest.entity.Employee;
import org.example.emptest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployeeById(@PathVariable String empId) {
        return employeeService.getEmployeeById(empId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.addEmployee(employee);
    }

    @DeleteMapping("/employees/{empId}")
    public void deleteEmployee(@PathVariable String empId) {
        employeeService.deleteEmployeeById(empId);
    }

    @PutMapping("/employees/{empId}")
    public Employee updateEmployee(@PathVariable String empId, @RequestBody EmployeeUpdateDto employeeDto) {
        Employee employee = employeeService.updateEmployee(employeeDto);
        return employee;
    }
}
