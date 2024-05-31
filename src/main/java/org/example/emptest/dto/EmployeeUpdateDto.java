package org.example.emptest.dto;

import lombok.Data;

/**
 * 직원정보 수정은 HR 부서에서만 할 수 있으며, 급여와 지급된 장비만 수정할 수 있다.
 */
@Data
public class EmployeeUpdateDto {
    private String empId;
    private int deptId;
    private int salary;
    private int equipId;
}
