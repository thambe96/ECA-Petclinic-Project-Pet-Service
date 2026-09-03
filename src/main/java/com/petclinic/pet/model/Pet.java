package com.petclinic.pet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "pets")
public class Pet {

    @Id
    private String id;

    private String name;
    private String species;
    private String breed;
    private Integer age;
    private String ownerName;
    private String ownerPhone;
    private String medicalHistory;
}
