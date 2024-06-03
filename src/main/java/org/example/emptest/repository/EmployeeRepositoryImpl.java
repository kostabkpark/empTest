package org.example.emptest.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import org.example.emptest.dto.EmployeeSearchCond;
import org.example.emptest.entity.EmpType;
import org.example.emptest.entity.Employee;
import org.example.emptest.entity.QEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepositoryQuery {
   @Autowired
   private EntityManager em;
   private final JPAQueryFactory factory;
   QEmployee employee = QEmployee.employee;

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

    private BooleanExpression  salaryGoe(int salary) {
        return (salary > 0) ? employee.salary.goe(salary) : null;
    }

    private BooleanExpression deptIdEq(int deptId) {
        return (deptId > 0) ? employee.department.deptId.eq(deptId) : null ;
    }

    private BooleanExpression empTypeEq(EmpType empType) {
        return (empType != null) ? employee.empType.eq(empType) : null ;
    }
}
