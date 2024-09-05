package com.example.animals.service.impl;

import com.example.animals.exception.EntityNotFoundException;
import com.example.animals.mapper.CommandToAnimalMapper;
import com.example.animals.model.Animal;
import com.example.animals.model.command.CreateAnimalCommand;
import com.example.animals.model.command.UpdateAnimalCommand;
import com.example.animals.repository.AnimalRepository;
import com.example.animals.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AnimalServiceImpl implements AnimalService {

    AnimalRepository animalRepository;
    CommandToAnimalMapper commandToAnimalMapper;

    @Autowired
    public AnimalServiceImpl(AnimalRepository animalRepository, CommandToAnimalMapper commandToAnimalMapper) {
        this.animalRepository = animalRepository;
        this.commandToAnimalMapper = commandToAnimalMapper;
    }

    @Override
    public List<Animal> getAll() {
        return animalRepository.findAll();
    }

    @Override
    public Animal getById(UUID id) {

        Optional<Animal> animal = animalRepository.findById(id);

        if (animal.isEmpty()) {
            throw new EntityNotFoundException("id: " + id);
        }

        return animal.orElseThrow();
    }

    @Override
    public Animal create(CreateAnimalCommand createAnimalCommand) {
        return animalRepository.save(commandToAnimalMapper.fromCommand(createAnimalCommand));
    }

    @Override
    public Animal update(UUID id, UpdateAnimalCommand updateAnimalCommand) {
        return animalRepository.findById(id)
                .map(a -> {
                    a.setAnimalSize(updateAnimalCommand.getAnimalSize());
                    a.setGivenName(updateAnimalCommand.getGivenName());
                    return animalRepository.save(a);
                })
                .orElseGet(() -> {
                    return animalRepository.save(commandToAnimalMapper.fromCommand(updateAnimalCommand));
                });
    }

    @Override
    public void delete(UUID id) {

        Optional<Animal> animal = animalRepository.findById(id);

        if (animal.isEmpty()) {
            throw new EntityNotFoundException("id: " + id);
        }

        animalRepository.deleteById(id);
    }
}
