package com.example.animals.model.dto;

import com.example.animals.model.types.AnimalSize;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class AnimalDto {

    private UUID id;
    private AnimalSize animalSize;
    private String givenName;

    public AnimalDto(UUID id, AnimalSize animalSize, String givenName) {
        this.id = id;
        this.animalSize = animalSize;
        this.givenName = givenName;
    }
}
