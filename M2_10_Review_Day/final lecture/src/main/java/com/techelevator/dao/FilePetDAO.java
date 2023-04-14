package com.techelevator.dao;

import com.techelevator.model.Pet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilePetDAO implements PetDAO{

    File file;
    Scanner fileInput;

    public FilePetDAO(String fileName) throws FileNotFoundException {
        file = new File(fileName);
        fileInput = new Scanner(file);
    }

    @Override
    public List<Pet> getAllPets() {
        List<Pet> petList = new ArrayList<>();

        while(fileInput.hasNext()){
            String line = fileInput.nextLine();
            String[] lineArr = line.split(",");

            Pet pet = new Pet(Integer.parseInt(lineArr[0]),lineArr[1], lineArr[2], Integer.parseInt(lineArr[3]), Boolean.parseBoolean(lineArr[4]));
            petList.add(pet);
        }
        return petList;
    }

    @Override
    public Pet getPetById(int petId) {
        return null;
    }

    @Override
    public Pet createPet(Pet pet) {
        return null;
    }
}
