package org.example.emptest.dto;

import lombok.Data;
import org.example.emptest.entity.EmpType;

/**
 * 직원정보 생성은 HR 부서에서만 할 수 있다.
 */
@Data
public class EmployeeCreateDto {
    private int empId;
    private String empName;
    private int deptId;
    private EmpType empType;
    private int salary;
    private String joinDate;
    private String seqno;
}
