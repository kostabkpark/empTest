package org.example.emptest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 직원정보 조회는 모든 부서에서 할 수 있으며, 이 때 HR 부서에서 볼 수 있는 정보와
 * 일반 사용자가 볼 수 있는 정보가 다르다.
 * EmpoyeeInquiryDto는 일반 사용자가 조회할 수 있는 정보이다.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeInquiryDto {
    private String empName;
    private String deptName;
    private String seqno;
}
