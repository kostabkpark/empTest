package org.example.emptest.entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.emptest.dto.EmployeeCreateDto;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    @Id
    @Column(name="emp_id", nullable=false, length = 6)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;
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
    // 양방향 일대일 관계 설정
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="equipId")
    private Equipment equipment;

    public static Employee createEmployee(
            EmployeeCreateDto employeeDto,
            Department department,
            Equipment equipment){
        // 두 연관관계의 주인이 모두 사원이 되어야 함.
        // 장비가 없으면 장비를 먼저 등록해야 함
        // 등록된 장비 중 사원에 할당되어 있지 않은 장비를 찾아서 사원에게 할당할 수 있음
        Employee employee = new Employee();
       // employee.setEmpId(employeeDto.getEmpId());
        employee.setDepartment(department);
        employee.setEmpName(employeeDto.getEmpName());
        employee.setEmpType(employeeDto.getEmpType());
        employee.setSalary(employeeDto.getSalary());
        employee.setJoinDate(employeeDto.getJoinDate());
        // 객체지향적으로 양방향 탐색이 가능하게 하려면 두 entity에 모두 등록해줘야 함 - 1
        employee.setEquipment(equipment);
        System.out.println("Employee created" + employee);
        // 객체지향적으로 양방향 탐색이 가능하게 하려면 두 entity에 모두 등록해줘야 함 - 2
        equipment.setEmployee(employee);
        equipment.setCost(9999);
        System.out.println("Equipment set " + equipment);

        return employee;
    }

    public void changeEquipment(Equipment equipment){
        // 기존 장비 - available
        Equipment beforeEq = this.equipment;
        beforeEq.setEmployee(null);
        beforeEq.setCost(100);
        // 사원정보에 새로 받은 장비의 정보를 입력
        this.equipment = equipment;
        // 신규 장비 - 사원 정보
        equipment.setEmployee(this);
        equipment.setCost(8888);
    }

    public void retireProcess(){
        this.getEquipment().setEmployee(null);
        this.setEquipment(null);
        this.setEmpType(EmpType.D);
    }
}
