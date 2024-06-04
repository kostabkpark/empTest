package org.example.emptest.dto;

import com.querydsl.core.annotations.QueryProjection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EmployeeDepartmentDto {
    private String empName;
    private long salary;
    private String deptName;

    @QueryProjection
    public EmployeeDepartmentDto(String empName, long salary, String deptName) {
        this.empName = empName;
        this.salary = salary;
        this.deptName = deptName;
    }
}
