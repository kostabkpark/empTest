package org.example.emptest.controller;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.jdt.internal.compiler.lookup.Binding;
import org.example.emptest.dto.EmployeeCreateDto;
import org.example.emptest.dto.EmployeeInquiryDto;
import org.example.emptest.dto.EmployeeSearchCond;
import org.example.emptest.dto.EmployeeUpdateDto;
import org.example.emptest.entity.EmpType;
import org.example.emptest.entity.Employee;
import org.example.emptest.service.DepartmentService;
import org.example.emptest.service.EmployeeService;
import org.example.emptest.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employee/search")
    public String employeeSearch(Model model) {
        EmployeeSearchCond searchCond = new EmployeeSearchCond();
        model.addAttribute("employee", searchCond);
        model.addAttribute("deptList", departmentService.getAllDepartments());
        model.addAttribute("empTypes", EmpType.values());
        return "employee/employeeSearch";
    }

    @PostMapping("/employee/search")
    public String employeeSearch(@ModelAttribute EmployeeSearchCond searchCond) {
        List<Employee> empList = employeeService.getByDeptAndEmpTypeAndSalary(searchCond);
        log.info(empList.size() + "명입니다.");
        return "redirect:/" ;
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
    public String addEmployee(
            @Validated @ModelAttribute EmployeeCreateDto employeeDto,
            BindingResult bindingResult
            ) {

        if(bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "redirect:/error";
        } // field 오류
        switch (employeeDto.getEmpType()){
            case A :
                if(employeeDto.getSalary() > 500) {
                    bindingResult.reject("SalaryRange", new Object[]{300,500,employeeDto.getSalary()},null);
                }
                break;
            case C :
                if(employeeDto.getSalary() > 1000) {
                    bindingResult.reject("SalaryRange", new Object[]{500,1000,employeeDto.getSalary()},null);
                }
                break;
            case B :
                if(employeeDto.getSalary() > 10000) {
                    bindingResult.reject("SalaryRange", new Object[]{1000,10000,employeeDto.getSalary()},"급여 입력 오류");
                }
                break;
        }
        if(bindingResult.hasErrors()) {
            log.info("errors = {}", bindingResult);
            return "redirect:/error";
        } //

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
