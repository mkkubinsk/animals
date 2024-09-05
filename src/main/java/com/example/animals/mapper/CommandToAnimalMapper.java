package com.example.animals.mapper;

import com.example.animals.model.Animal;
import com.example.animals.model.command.CreateAnimalCommand;
import com.example.animals.model.command.UpdateAnimalCommand;
import org.springframework.stereotype.Component;

@Component
public class CommandToAnimalMapper {

    public Animal fromCommand(CreateAnimalCommand createAnimalCommand) {
        return new Animal(
                createAnimalCommand.getAnimalSize(),
                createAnimalCommand.getGivenName()
        );
    }

    public Animal fromCommand(UpdateAnimalCommand updateAnimalCommand) {
        return new Animal(
                updateAnimalCommand.getAnimalSize(),
                updateAnimalCommand.getGivenName()
        );
    }
}
