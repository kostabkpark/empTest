package org.example.emptest.controller;

//
//@RestController
//public class EmployeeAPIController {
//    @Autowired
//    EmployeeService employeeService;
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
