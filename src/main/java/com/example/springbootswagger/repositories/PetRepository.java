package com.example.springbootswagger.repositories;

import com.example.springbootswagger.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
