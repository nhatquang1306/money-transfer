package com.techelevator;

public class Elevator {
    //Instance Variables
    private int currentFloor;
    private int numberOfFloors;
    private boolean doorOpen;

    //Constructor
    public Elevator(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
        this.currentFloor = 1; // sets default value to floor 1
    }

    //GETTERS
    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    //Methods
    public void openDoor() {
        this.doorOpen = true;
    }

    public void closeDoor() {
        this.doorOpen = false;
    }

    public void goUp(int desiredFloor) {
        if (!this.doorOpen && desiredFloor <= this.numberOfFloors && desiredFloor>currentFloor) {
                this.currentFloor = desiredFloor; // uses the current floor and whatever the user inputs into the elevator it cannot go beyond the max number of floors.
        }
    }
    public void goDown(int desiredFloor) {
        if (!this.doorOpen && desiredFloor >= 1 && desiredFloor<currentFloor) {
                this.currentFloor = desiredFloor;
            }
        }
    }

