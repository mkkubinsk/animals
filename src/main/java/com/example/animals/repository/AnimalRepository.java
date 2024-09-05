package com.example.animals.repository;

import com.example.animals.model.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AnimalRepository extends JpaRepository<Animal, UUID> {
}
