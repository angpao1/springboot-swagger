package com.example.springbootswagger.controllers;

import com.example.springbootswagger.models.Pet;
import com.example.springbootswagger.services.PetService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1", produces = "application/json")
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @ApiOperation(value="Fetches all pets in the database", response=Pet.class)
    @GetMapping("/pets")
    public List<Pet> getAllPets() {
        return petService.getAllPets();
    }

    @ApiOperation(value="Fetches id pets in the database", response=Pet.class)
    @GetMapping("/pets/{id}")
    public Pet getPetByID(@PathVariable long id) {
        return petService.getPetByID(id);
    }

    @ApiOperation(value="Add Pet to the database")
    @PostMapping("/pets")
    public Pet addPet(@RequestBody Pet pet) {
        return petService.addPet(pet);
    }

    @ApiOperation(value="Update Pet By ID")
    @PutMapping("/pets/{id}")
    public Pet updatePet(@PathVariable long id, @RequestBody Pet pet) {
        return petService.updatePet(id, pet);
    }

    @ApiOperation(value="Delete Pet By ID")
    @DeleteMapping("/pets/{id}")
    public ResponseEntity<?> deletePet(@PathVariable String id) {
        return petService.deletePet(id);
    }
}
