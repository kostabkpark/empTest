package org.example.emptest.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class EquipmentRepositoryTest {

    @Autowired
    EquipmentRepository equipmentRepository;

    @Test
    void availableEquipmentInquiry() {
        equipmentRepository.findAllByEmployeeIsNull();
    }
}