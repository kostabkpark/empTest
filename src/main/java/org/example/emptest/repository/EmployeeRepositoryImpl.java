package org.example.emptest.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.example.emptest.dto.EmployeeDepartmentDto;
import org.example.emptest.dto.EmployeeSearchCond;
import org.example.emptest.dto.QEmployeeDepartmentDto;
import org.example.emptest.entity.EmpType;
import org.example.emptest.entity.Employee;
import org.example.emptest.entity.QDepartment;
import org.example.emptest.entity.QEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryQuery {
    @Autowired
    private EntityManager em;
    private final JPAQueryFactory factory;
    QEmployee employee = QEmployee.employee;
    QDepartment department = QDepartment.department;

    public EmployeeRepositoryImpl(EntityManager em) {
        factory = new JPAQueryFactory(em);
    }

    @Override
    public List<Employee> dynamicSearch(EmployeeSearchCond seachCond) {

        List<Employee> empList = factory.selectFrom(employee)
                .where(
                        deptIdEq(seachCond.getDeptId()),
                        empTypeEq(seachCond.getEmpType()),
                        salaryGoe(seachCond.getSalary())
                )
                .fetch();
        return empList;
    }

    private BooleanExpression salaryGoe(int salary) {
        return (salary > 0) ? employee.salary.goe(salary) : null;
    }

    private BooleanExpression deptIdEq(int deptId) {
        return (deptId > 0) ? employee.department.deptId.eq(deptId) : null;
    }

    private BooleanExpression empTypeEq(EmpType empType) {
        return (empType != null) ? employee.empType.eq(empType) : null;
    }

    @Override
    public Page<EmployeeDepartmentDto> dynamicSearchPagination(EmployeeSearchCond seachCond,
                                                               Pageable pageable) {
        List<EmployeeDepartmentDto> content =
                 factory.select(new QEmployeeDepartmentDto(
                         employee.empName,
                         employee.salary,
                         department.deptName
                         ))
                         .from(employee)
                         .leftJoin(employee.department, department)
                        .where(
                                deptIdEq(seachCond.getDeptId()),
                                empTypeEq(seachCond.getEmpType()),
                                salaryGoe(seachCond.getSalary())
                        )
                        .offset(pageable.getOffset())
                        .limit(pageable.getPageSize())
                        .fetch();
        long count = factory.select(employee.count())
                .from(employee)
                .where(
                        deptIdEq(seachCond.getDeptId()),
                        empTypeEq(seachCond.getEmpType()),
                        salaryGoe(seachCond.getSalary())
                )
                .fetchOne();

        return new PageImpl<>(content, pageable, count);
    }
}
