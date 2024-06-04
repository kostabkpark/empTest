package org.example.emptest.controller;


import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.example.emptest.api.ErrorResult;
import org.example.emptest.dto.EmployeeCreateDto;
import org.example.emptest.entity.Employee;
import org.example.emptest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeAPIController {
    @Autowired
    EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee addEmployee(
            @Validated @RequestBody EmployeeCreateDto employeeDto,
            BindingResult bindingResult,
            HttpServletResponse resp
    ) throws Exception{

        if(bindingResult.hasFieldErrors()){
            log.info("field errors = {}", bindingResult.getFieldError());
            resp.sendError(500, "입력값 오류입니다.");
            throw new IllegalArgumentException();
                    //new ErrorResult("Field Error", "입력값 오류입니다.");=
        } // field 오류
        return null;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ErrorResult badRequestHandler(Exception e){
        //HttpMessageNotReadableException
        log.info("exception", e);
        return new ErrorResult("Bad Request", "숫자란에 문자를 입력했습니다.");
    }
}

//        switch (employeeDto.getEmpType()){
//            case A :
//                if(employeeDto.getSalary() > 500) {
//                    bindingResult.reject("SalaryRange", new Object[]{300,500,employeeDto.getSalary()},null);
//                }
//                break;
//            case C :
//                if(employeeDto.getSalary() > 1000) {
//                    bindingResult.reject("SalaryRange", new Object[]{500,1000,employeeDto.getSalary()},null);
//                }
//                break;
//            case B :
//                if(employeeDto.getSalary() > 10000) {
//                    bindingResult.reject("SalaryRange", new Object[]{1000,10000,employeeDto.getSalary()},"급여 입력 오류");
//                }
//                break;
//        }
//        if(bindingResult.hasErrors()) {
//            log.info("errors = {}", bindingResult);
//            return "redirect:/error";
//        } //
//
//        log.info("employeeDto: {}", employeeDto);
//        employeeService.addEmployee(employeeDto);
//        return "redirect:/";

//
//    @GetMapping("/employees")
//    public List<Employee> getEmployees() {
//        return employeeService.getAllEmployees();
//    }
//
//    @GetMapping("/employees/{empId}")
//    public Employee getEmployeeById(@PathVariable String empId) {
//        return employeeService.getEmployeeById(empId);
//    }
//
//    @PostMapping("/employees")
//    public Employee addEmployee(@RequestBody Employee employee) {
//        return employeeService.addEmployee(employee);
//    }
//
//    @DeleteMapping("/employees/{empId}")
//    public void deleteEmployee(@PathVariable String empId) {
//        employeeService.deleteEmployeeById(empId);
//    }
//
//    @PutMapping("/employees/{empId}")
//    public Employee updateEmployee(@PathVariable String empId, @RequestBody EmployeeDto employeeDto) {
//        Employee employee = employeeService.updateEmployee(employeeDto);
//        return employee;
//    }
//}
