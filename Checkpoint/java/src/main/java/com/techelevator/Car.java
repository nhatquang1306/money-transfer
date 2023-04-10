package com.techelevator;

import java.time.LocalDate;

public class Car {
    private int year;
    private String make;
    private int age;
    private boolean isClassicCar;

    public Car(int year, String make, boolean isClassicCar) {
        this.year = year;
        this.make = make;
        this.isClassicCar = isClassicCar;
        //age is a derived property
    }
    public int getYear() {
        return year;
    }

    public String getMake() {
        return make;
    }

    //derived property!
    public int getAge() {
        return LocalDate.now().getYear() - year;
    }

    public boolean isClassicCar() {
        return isClassicCar;
    }

    //method
    public boolean needsECheck(int yearToCheck) {
        if (age<4 || age>25 || isClassicCar==true) { //exemptions
            return false;
        }
        if(yearToCheck%2==0 && year%2==0) { // even model year vehicles must be tested if yearToCheck is even
            return true;
        }
        if (yearToCheck%2==1 && year%2==1) {
            return true;
        }
        return false;
    }
    public String toString() {
        return "CAR - " + year + " - " + make;
    }
}
