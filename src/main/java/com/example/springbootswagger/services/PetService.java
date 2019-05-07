package com.example.springbootswagger.services;

import com.example.springbootswagger.models.Pet;
import com.example.springbootswagger.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public List<Pet> getAllPets() {
        return petRepository.findAll();
    }

    public Pet getPetByID(long id) {
        return petRepository.findById(id).orElse(null);
    }

    public Pet addPet(Pet data) {
        Pet pet = new Pet();
        pet.setName(data.getName());
        pet.setCreate_at(new Date(System.currentTimeMillis() + 7 * 60 * 60 * 1000));
        pet.setUpdate_at(new Date(System.currentTimeMillis() + 7 * 60 * 60 * 1000));
        return petRepository.save(pet);
    }

    public Pet updatePet(long id, Pet data) {
        Pet pet = petRepository.findById(id).orElse(null);
        if (data.getName() != null && !"".equals(data.getName())) {
            pet.setName(data.getName());
            pet.setUpdate_at(new Date(System.currentTimeMillis() + 7 * 60 * 60 * 1000));
        }
        return petRepository.save(pet);
    }

    public ResponseEntity<?> deletePet(String id) {
        Pet pet = petRepository.findById(Long.valueOf(id)).orElse(null);
        petRepository.delete(pet);
        return ResponseEntity.ok().build();
    }
}
