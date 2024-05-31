package org.example.emptest.controller;

import lombok.RequiredArgsConstructor;
import org.example.emptest.entity.Department;
import org.example.emptest.service.DepartmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping("/department/add")
    public String addDepartment() {
        return "department/departmentAdd";
    }

    @PostMapping("/department/add")
    public String addEmployee(@ModelAttribute Department department) {
        departmentService.addDepartment(department);
        return "redirect:/";
    }

    @GetMapping("/department/{deptId}")
    public String getDepartmentInfo(@PathVariable("deptId") int deptId,
                                    Model model) {
        model.addAttribute(departmentService.getDepartment(deptId));
        return "department/departmentDetail";
    }

}