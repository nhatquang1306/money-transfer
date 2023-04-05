package com.techelevator;

import java.time.LocalDate;

public class Car {
    private int year;
    private String make;
    private int age;
    private boolean isClassicCar;

    public Car(boolean isClassicCar, int year, String make) {
        this.year = year;
        this.make = make;
        this.isClassicCar = isClassicCar;
        this.age = LocalDate.now().getYear() - year; // calculation for age using localdate to get current year
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isClassicCar() {
        return isClassicCar;
    }

    public void setClassicCar(boolean classicCar) {
        isClassicCar = classicCar;
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
        return "CAR" + " - " + year + " - " + make;
    }
}
