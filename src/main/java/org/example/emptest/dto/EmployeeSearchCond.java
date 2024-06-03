package org.example.emptest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.emptest.entity.EmpType;

/**
 * 직원조회를 위한 검색 조건 (동적 쿼리)
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeSearchCond {
    private int deptId;
    private EmpType empType;
    private int salary;
}
