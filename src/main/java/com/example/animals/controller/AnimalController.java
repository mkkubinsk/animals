package com.example.animals.controller;

import com.example.animals.mapper.AnimalToDtoMapper;
import com.example.animals.model.Animal;
import com.example.animals.model.command.CreateAnimalCommand;
import com.example.animals.model.command.UpdateAnimalCommand;
import com.example.animals.model.dto.AnimalDto;
import com.example.animals.service.AnimalService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalService animalService;
    private final AnimalToDtoMapper animalToDtoMapper;

    @Autowired
    public AnimalController(AnimalService animalService, AnimalToDtoMapper animalToDtoMapper) {
        this.animalService = animalService;
        this.animalToDtoMapper = animalToDtoMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AnimalDto> getAll() {
        List<Animal> animalList = animalService.getAll();
        return animalList.stream()
                .map(a -> animalToDtoMapper.convertToDto(a))
                .toList();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AnimalDto getById(@PathVariable UUID id) {
        Animal animal = animalService.getById(id);
        return animalToDtoMapper.convertToDto(animal);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AnimalDto create(@Valid @RequestBody CreateAnimalCommand createAnimalCommand) {
        return animalToDtoMapper.convertToDto(animalService.create(createAnimalCommand));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public AnimalDto update(@PathVariable UUID id, @RequestBody UpdateAnimalCommand updateAnimalCommand) {
        return animalToDtoMapper.convertToDto(animalService.update(id, updateAnimalCommand));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable UUID id) {
        animalService.delete(id);
    }

}
