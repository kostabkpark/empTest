package org.example.emptest.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="dept_id")
    private int deptId;
    @Column(name="dept_name", nullable=false, length=10)
    private String deptName;
}
