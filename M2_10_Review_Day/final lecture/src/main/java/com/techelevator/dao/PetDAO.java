package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.util.List;

public interface PetDAO {
    List<Pet> getAllPets();

    Pet getPetById(int petId);

    Pet createPet(Pet pet);

}
