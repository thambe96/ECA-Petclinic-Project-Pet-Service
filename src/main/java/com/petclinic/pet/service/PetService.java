package com.petclinic.pet.service;

import com.petclinic.pet.dto.PetRequestDto;
import com.petclinic.pet.dto.PetResponseDto;

import java.util.List;

public interface PetService {
    List<PetResponseDto> getAllPets();
    PetResponseDto getPetById(String id);
    PetResponseDto createPet(PetRequestDto requestDto);
    void deletePet(String id);
}
