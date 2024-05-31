package org.example.emptest.controller;

import lombok.RequiredArgsConstructor;
import org.example.emptest.entity.Employee;
import org.example.emptest.entity.Equipment;
import org.example.emptest.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class EquipmentController {
    private final EquipmentService equipmentService;

    @GetMapping("/equipment/{id}")
    public String getEquipmentInfo(@PathVariable("id") int id,
                                   Model model) {
        model.addAttribute(equipmentService.getEquipmentById(id));
        return "equipment/equipmentDetail";
    }

    @GetMapping("/equipment/add")
    public String addEquipment(Model model) {
        model.addAttribute(new Equipment());
        return "equipment/equipmentAdd";
    }

    @PostMapping("/equipment/add")
    public String addEquipment(@ModelAttribute Equipment equipment) {
        equipmentService.addEquipment(equipment);
        return "redirect:/";
    }
}
