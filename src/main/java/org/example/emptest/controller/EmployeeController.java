package org.example.emptest.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.emptest.dto.EmployeeCreateDto;
import org.example.emptest.dto.EmployeeInquiryDto;
import org.example.emptest.dto.EmployeeUpdateDto;
import org.example.emptest.entity.Department;
import org.example.emptest.entity.EmpType;
import org.example.emptest.entity.Employee;
import org.example.emptest.service.DepartmentService;
import org.example.emptest.service.EmployeeService;
import org.example.emptest.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

@Controller
@Slf4j
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EquipmentService equipmentService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{empId}")
    public Employee getEmployeeById(@PathVariable int empId) {
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping("/employee/add")
    public String addEmployee(Model model) {
        model.addAttribute("employee", new EmployeeCreateDto());
        model.addAttribute("deptList", departmentService.getAllDepartments());
        model.addAttribute("empTypes", EmpType.values());
        model.addAttribute("eqmtList", equipmentService.getAvailableEquipments());
        return "employee/employeeAdd";
    }
    @PostMapping("/employee/add")
    public String addEmployee(@ModelAttribute EmployeeCreateDto employeeDto) {
        log.info("employeeDto: {}", employeeDto);
        employeeService.addEmployee(employeeDto);
        return "redirect:/";
    }

//    @DeleteMapping("/employees/{empId}")
//    public void deleteEmployee(@PathVariable String empId) {
//        employeeService.deleteEmployeeById(empId);
//    }

    @GetMapping("/employee/update/{empId}")
    public String empEquipmentChange(@PathVariable("empId") int empId, Model model) {
        Employee employee = employeeService.getEmployeeById(empId);

        EmployeeInquiryDto employeeDto =
                new EmployeeInquiryDto(employee.getEmpName(),
                                       employee.getDepartment().getDeptName(),
                                       employee.getEquipment().getSeqno());

        model.addAttribute("employee", employeeDto);
        model.addAttribute("eqmtList", equipmentService.getAvailableEquipments());
        return "employee/employeeUpdate";
    }

    @PostMapping("/employee/update/{empId}")
    public String empEquipmentChange(@PathVariable("empId") int empId,
                                     @ModelAttribute EmployeeInquiryDto employeeDto) {
        Employee employee = employeeService.getEmployeeById(empId);
        employeeService.changeEquipment(empId,equipmentService.getEquipmentBySeqno(employeeDto.getSeqno()));
        return "redirect:/";
    }

    @PutMapping("/employees/{empId}")
    public Employee updateEmployee(@PathVariable("empId") int empId, @RequestBody EmployeeUpdateDto employeeDto) {
        Employee employee = employeeService.updateEmployee(employeeDto);
        return employee;
    }

}
