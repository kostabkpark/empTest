//package org.example.emptest.repository;
//
//import jakarta.persistence.Entity;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.PersistenceContext;
//import org.example.emptest.entity.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class JPAEmployeeRepository implements EmployeeRepository{
//    @Autowired
//    EntityManager em;
//
//    @Autowired
//    public JPAEmployeeRepository(EntityManager em) {
//        this.em = em;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        List<Employee> empList = em.createQuery("select e from Employee e", Employee.class).getResultList();
//        return empList;
//    }
//
//    @Override
//    public Optional<Employee> findById(String empId) {
//        Employee employee = em.find(Employee.class, empId);
//        return Optional.ofNullable(employee);
//    }
//
//    @Override
//    public Employee save(Employee employee) {
//        em.persist(employee);
//        return em.find(Employee.class, employee.getEmpId());
//    }
//
//    @Override
//    public void deleteById(String empId) {
//        em.remove(em.find(Employee.class, empId));
//    }
//}
