package com.petclinic.pet.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PetResponseDto {
    private String id;
    private String name;
    private String species;
    private String breed;
    private Integer age;
    private String ownerName;
    private String ownerPhone;
    private String medicalHistory;
}
