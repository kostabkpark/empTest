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

    public Equipment addEquipment(Equipment equipment) {
        return equipmentRepository.save(equipment);
    }

    public List<Equipment> getAvailableEquipments() {
        return equipmentRepository.findAllByEmployeeIsNull();
    }
}
