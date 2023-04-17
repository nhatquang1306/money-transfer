package com.techelevator.model;

public class Pet {
    private int petId;
    private String petName;
    private String species;
    private int weight;
    private boolean isHouseBroken;

    public Pet(int petId, String petName, String species, int weight, boolean isHouseBroken) {
        this.petId = petId;
        this.petName = petName;
        this.species = species;
        this.weight = weight;
        this.isHouseBroken = isHouseBroken;
    }
    public Pet() {

    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isHouseBroken() {
        return isHouseBroken;
    }

    public void setHouseBroken(boolean houseBroken) {
        isHouseBroken = houseBroken;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                ", isHouseBroken=" + isHouseBroken +
                '}';
    }
}
