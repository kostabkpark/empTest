package org.example.emptest.repository;

import org.example.emptest.entity.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {
    Equipment findBySeqno(String seqno);
    List<Equipment> findAllByEmployeeIsNull();
}
