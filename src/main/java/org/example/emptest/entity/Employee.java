package org.example.emptest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.emptest.dto.EmployeeCreateDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @Column(name="emp_id", nullable=false, length = 6)
    private String empId;
    @Column(name="emp_name", nullable=false, length = 20)
    private String empName;
    // 단방향 다대일 관계 설정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dept_id")
    private Department department;
    @Enumerated(EnumType.STRING)
    @Column(name="emp_type", length=1)
    private EmpType empType;
    @Column(name="join_date", length=10)
    private String joinDate;
    private long salary;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="equipId")
    private Equipment equipment;

    public static Employee createEmployee(
            EmployeeCreateDto employeeDto,
            Department department,
            Equipment equipment){

        // 입력받은 장비가 이미 존재하고 , 사원에 할당되어 있지 않은 경우 진행 가능
        // 사원에게 배정되지 않은 장비가 먼저 존재해야 할당할 수 있음
        // 장비가 없으면 장비를 먼저 등록해야 함
        // 두 연관관계의 주인이 모두 사원이 되어야 함.
//        Equipment bySeqno = equipmentRepository.findBySeqno(employeeDto.getSeqno());
//        if(bySeqno == null || bySeqno.getEmployee() != null) {
//
//
//        }

        Employee employee = new Employee();
        employee.setDepartment(department);
        employee.setEquipment(equipment);

        employee.setEmpName(employeeDto.getEmpName());
        employee.setEmpType(employeeDto.getEmpType());
        employee.setSalary(employeeDto.getSalary());
        employee.setJoinDate(employeeDto.getJoinDate());
        return employee;
    }
}
