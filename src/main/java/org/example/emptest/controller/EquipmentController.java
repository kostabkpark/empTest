package org.example.emptest.controller;

import lombok.RequiredArgsConstructor;
import org.example.emptest.entity.Employee;
import org.example.emptest.entity.Equipment;
import org.example.emptest.service.EquipmentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        model.addAttribute("equipment",new Equipment());
        return "equipment/equipmentAdd";
    }

    @PostMapping("/equipment/add")
    public String addEquipment(@ModelAttribute Equipment equipment,
                               RedirectAttributes redirectAttr) {
        String msg = "";
        try {
            equipmentService.addEquipment(equipment);
            //msg = "정상적으로 등록되었습니다.";
            redirectAttr.addFlashAttribute("status", true);
            return "redirect:/";
        } catch (Exception e) {
            //msg = e.getMessage();
            redirectAttr.addAttribute("status", true);
            return "redirect:/error";
        }
    }
}
