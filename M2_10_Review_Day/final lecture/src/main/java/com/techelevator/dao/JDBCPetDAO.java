package com.techelevator.dao;

import com.techelevator.model.Pet;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JDBCPetDAO implements PetDAO{


    private JdbcTemplate jdbcTemplate;


    public JDBCPetDAO(DataSource ds){
        jdbcTemplate = new JdbcTemplate(ds);
    }


    @Override
    public List<Pet> getAllPets() {
        List<Pet> petList = new ArrayList<>();

        // create a string to hold the sql statement we want to run, this one gets all pets from the database
        String sql = "SELECT pet_id, pet_name, species, weight, house_broken FROM pet";
        // use jdbcTemplate to get results from the database by passing the sql string
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        // loop through the results of our SqlRowSet and add it to our list of pets
        while (results.next()) {
            // use our mapping method to add contents of row to a pet object. We then add it to our petList
            petList.add(mapRowToPet(results));
        }
        return petList;
    }

    @Override
    public Pet getPetById(int petId) {
        Pet pet = new Pet();

        String sql = "SELECT pet_id, pet_name, species, weight, house_broken FROM pet WHERE pet_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, petId);

        if(results.next()){
            pet = mapRowToPet(results);
        }

        return pet;
    }

    @Override
    public Pet createPet(Pet pet) {
        String sql = "INSERT INTO pet (pet_name, species, weight, house_broken) VALUES (?, ?, ?, ?) RETURNING pet_id;";
        Integer petId = jdbcTemplate.queryForObject(sql, int.class, pet.getPetName(), pet.getSpecies(), pet.getWeight(), pet.isHouseBroken());

        return getPetById(petId);
    }

    private Pet mapRowToPet(SqlRowSet result){
        Pet pet = new Pet();

        pet.setPetId(result.getInt("pet_id"));
        pet.setPetName(result.getString("pet_name"));
        pet.setSpecies(result.getString("species"));
        pet.setWeight(result.getInt("weight"));
        pet.setHouseBroken(result.getBoolean("house_broken"));

        return pet;

    }

}
