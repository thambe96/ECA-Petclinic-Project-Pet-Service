package com.petclinic.pet.service;

import com.petclinic.pet.dto.PetRequestDto;
import com.petclinic.pet.dto.PetResponseDto;
import com.petclinic.pet.model.Pet;
import com.petclinic.pet.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;

    public PetServiceImpl(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public List<PetResponseDto> getAllPets() {
        return petRepository.findAll().stream()
                .map(this::mapToResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public PetResponseDto getPetById(String id) {
        return petRepository.findById(id)
                .map(this::mapToResponseDto)
                .orElse(null);
    }

    @Override
    public PetResponseDto createPet(PetRequestDto requestDto) {
        Pet pet = Pet.builder()
                .name(requestDto.getName())
                .species(requestDto.getSpecies())
                .breed(requestDto.getBreed())
                .age(requestDto.getAge())
                .ownerName(requestDto.getOwnerName())
                .ownerPhone(requestDto.getOwnerPhone())
                .medicalHistory(requestDto.getMedicalHistory())
                .build();

        Pet saved = petRepository.save(pet);
        return mapToResponseDto(saved);
    }

    @Override
    public void deletePet(String id) {
        petRepository.deleteById(id);
    }

    private PetResponseDto mapToResponseDto(Pet pet) {
        return PetResponseDto.builder()
                .id(pet.getId())
                .name(pet.getName())
                .species(pet.getSpecies())
                .breed(pet.getBreed())
                .age(pet.getAge())
                .ownerName(pet.getOwnerName())
                .ownerPhone(pet.getOwnerPhone())
                .medicalHistory(pet.getMedicalHistory())
                .build();
    }
}
