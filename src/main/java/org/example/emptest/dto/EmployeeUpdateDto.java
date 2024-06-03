package org.example.emptest.dto;

import lombok.Data;
import org.example.emptest.entity.EmpType;

/**
 * 직원정보 수정은 HR 부서에서만 할 수 있으며, 급여와 지급된 장비만 수정할 수 있다.
 * empType에 퇴사자를 수정했고, 퇴사하면 D 로 수정해준다.
 */
@Data
public class EmployeeUpdateDto {
    private int empId;
    private int deptId;
    private EmpType empType;  //퇴사하면 D
    private int salary;
    private int equipId;
}
