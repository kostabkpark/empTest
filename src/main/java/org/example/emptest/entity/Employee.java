package org.example.emptest.entity;

import jakarta.persistence.*;
import lombok.*;

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
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employee")
    private Equipment equipment;
}
