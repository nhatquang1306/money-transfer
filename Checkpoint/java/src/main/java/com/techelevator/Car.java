package com.techelevator;

public class Car {
    //instance variables
    private int year;
    private String make;
    private boolean isClassicCar;
    private int age;

    //constructor

    public Car(int year, String make, boolean isClassicCar) {
        this.year = year;
        this.make = make;
        this.isClassicCar = isClassicCar;
    }
    public int getAge() {
        int currentYear = 2023;
        return currentYear - year;
    }

    //method
    public boolean needsECheck(int yearToCheck) {
        if (age < 4 || age > 25 || isClassicCar == true) {
            return false;
        } else if (yearToCheck % 2 == 0) {
            return true;
        } else if (yearToCheck % 2 == 1) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
            return "CAR - " + year + " - " + make;
        }
}
