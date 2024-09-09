package com.example.animals.validation.impl;

import com.example.animals.model.command.CreateAnimalCommand;
import com.example.animals.validation.annotation.NameValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NameValidator implements ConstraintValidator<NameValidation, CreateAnimalCommand> {

    @Override
    public boolean isValid(CreateAnimalCommand createAnimalCommand, ConstraintValidatorContext cxt) {
        List<String> list = Arrays.asList("PIMPEK", "DINGO");
        return list.contains(createAnimalCommand.getGivenName());
    }


}
