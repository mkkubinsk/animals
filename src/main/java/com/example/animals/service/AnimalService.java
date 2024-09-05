package com.example.animals.service;

import com.example.animals.model.Animal;
import com.example.animals.model.command.CreateAnimalCommand;
import com.example.animals.model.command.UpdateAnimalCommand;

import java.util.List;
import java.util.UUID;

public interface AnimalService {

    List<Animal> getAll();

    Animal getById(UUID id);

    Animal create(CreateAnimalCommand createAnimalCommand);

    Animal update(UUID id, UpdateAnimalCommand updateAnimalCommand);

    void delete(UUID id);
}
