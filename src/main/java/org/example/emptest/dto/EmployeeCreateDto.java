package org.example.emptest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.emptest.entity.EmpType;
import org.hibernate.validator.constraints.Range;

/**
 * 직원정보 생성은 HR 부서에서만 할 수 있다.
 */
@Data
public class EmployeeCreateDto {
    @NotBlank
            //(message = "직원의 이름은 반드시 입력해야 합니다.")
    private String empName;
    @NotNull
    private Integer deptId;
    @NotNull
    private EmpType empType;
    @Range(min=300, max=10000)
    //, message = "직원의 급여는 300에서 10000 사이여야 합니다.")
    private Long salary;
    @NotEmpty
    private String joinDate;
    private String seqno;
}
