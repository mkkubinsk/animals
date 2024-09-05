package com.example.animals.model.command;

import com.example.animals.model.types.AnimalSize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateAnimalCommand {

    private AnimalSize animalSize;
    private String givenName;

}
