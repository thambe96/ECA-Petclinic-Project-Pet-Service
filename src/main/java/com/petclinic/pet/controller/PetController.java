package com.petclinic.pet.controller;

import com.petclinic.pet.dto.PetRequestDto;
import com.petclinic.pet.dto.PetResponseDto;
import com.petclinic.pet.service.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public ResponseEntity<List<PetResponseDto>> getAllPets() {
        return ResponseEntity.ok(petService.getAllPets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetResponseDto> getPetById(@PathVariable String id) {
        PetResponseDto responseDto = petService.getPetById(id);
        if (responseDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping
    public ResponseEntity<PetResponseDto> createPet(@RequestBody PetRequestDto requestDto) {
        PetResponseDto saved = petService.createPet(requestDto);
        return ResponseEntity.ok(saved);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable String id) {
        if (petService.getPetById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        petService.deletePet(id);
        return ResponseEntity.noContent().build();
    }
}
