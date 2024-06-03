package org.example.emptest.service;

import lombok.RequiredArgsConstructor;
import org.example.emptest.entity.Equipment;
import org.example.emptest.repository.EquipmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class EquipmentService {
    private final EquipmentRepository equipmentRepository;

    public Equipment getEquipmentById(int id) {
        return equipmentRepository.findById(id).get();
    }

    public Equipment getEquipmentBySeqno(String seqno) {
        return equipmentRepository.findBySeqno(seqno);
    }

    @Transactional
    public Equipment addEquipment(Equipment equipment) throws Exception{
        if(validateEquipment(equipment.getSeqno())) {
            equipment = equipmentRepository.save(equipment);
        } else
            throw new Exception("동일한 장비번호가 존재함");
        return equipment;
    }

    public List<Equipment> getAvailableEquipments() {
        return equipmentRepository.findAllByEmployeeIsNull();
    }

    public boolean validateEquipment(String seqno) {
        if(equipmentRepository.findBySeqno(seqno) == null)
            return true; // 새로운 장비
        else
            return false; // 이미 동일한 장비번호가 존재하는 경우
    }
}
