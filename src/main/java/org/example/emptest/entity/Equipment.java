package org.example.emptest.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int equipId;
    @Column(unique = true, length = 10)
    private String seqno;
    private int cost;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "equipment")
    private Employee employee;
}
