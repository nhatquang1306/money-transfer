package com.techelevator.view;

import com.techelevator.dao.FilePetDAO;
import com.techelevator.dao.JDBCPetDAO;
import com.techelevator.dao.PetDAO;
import com.techelevator.model.Pet;
import org.apache.commons.dbcp2.BasicDataSource;

import java.io.FileNotFoundException;
import java.util.List;

public class PetDemo {

    private PetDAO dao;

    public static void main(String[] args) {
        PetDemo app = new PetDemo();
        app.run();
    }

    public PetDemo() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/Pet");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dao = new JDBCPetDAO(dataSource);

    }



    public void run() {
        Pet andy = new Pet(-1,"Andy", "dog", 15, true);
        dao.createPet(andy);
        List<Pet> pets = dao.getAllPets();
        for(Pet pet : pets){
            System.out.printf("%-15s|%-15s\n", pet.getPetName(), pet.getSpecies());
        }

        System.out.println("\n\n");
        Pet pet = dao.getPetById(7);
        System.out.println("This is the pet with an id of 7:");
        System.out.printf("%-15s|%-15s", pet.getPetName(), pet.getSpecies());

    }
}
