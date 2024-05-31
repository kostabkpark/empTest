package org.example.emptest.dto;

import lombok.Data;

/**
 * 직원정보 생성은 HR 부서에서만 할 수 있다.
 */
@Data
public class EmployeeCreateDto {
    private String empId;
    private String empName;
    private int deptId;

    private int salary;
    private String joinDate;
    private int id;
}
