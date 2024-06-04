package org.example.emptest.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public class EquipmentDto {
    @NotBlank
    @Size(min=10, max=10)
    private String seqno;
    @Range(min=100,max=1000)
    private int cost;
}
