package org.example.emptest.entity;

import jakarta.persistence.*;
import lombok.*;

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
    // 양방향 일대일 관계 설정
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "equipment")
    private Employee employee;
}
