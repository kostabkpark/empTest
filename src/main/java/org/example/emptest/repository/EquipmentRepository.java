package org.example.emptest.repository;

import org.example.emptest.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
    Equipment findBySeqno(String seqno);
    // 사원에게 할당되지 않은 장비 조회해오는 메서드
    List<Equipment> findAllByEmployeeIsNull();
}
