package com.example.animals.mapper;

import com.example.animals.model.Animal;
import com.example.animals.model.dto.AnimalDto;
import org.springframework.stereotype.Component;

@Component
public class AnimalToDtoMapper {

    public AnimalDto convertToDto(Animal animal) {
        return new AnimalDto(
                animal.getId(),
                animal.getAnimalSize(),
                animal.getGivenName()
        );
    }
}
