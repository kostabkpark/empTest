package org.example.emptest.service;

import lombok.RequiredArgsConstructor;
import org.example.emptest.entity.Department;
import org.example.emptest.repository.DepartmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }
    public Department getDepartment(int deptId) {
        return departmentRepository.findById(deptId).get();
    }

    public Department addDepartment(Department department) {
        return departmentRepository.save(department);
    }
}
