package com.example.animals.model;

import com.example.animals.model.types.AnimalSize;
import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    private AnimalSize animalSize;

    @Column
    private String givenName;

    public Animal() {
    }

    public Animal(AnimalSize animalSize, String givenName) {
        this.animalSize = animalSize;
        this.givenName = givenName;
    }
}
