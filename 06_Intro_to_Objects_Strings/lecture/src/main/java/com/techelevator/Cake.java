package com.techelevator;

public class Cake {
//State
    private String size;
    private boolean hasSprinkles;

    // Constructor
    public Cake(String size, boolean hasSprinkles){
        this.size=size; // referring to this objects variable called size, not the method called size
        this.hasSprinkles=hasSprinkles;
    }
    //Behavior
    public String getSize() {
        return size;
    }
    public boolean getSprinkles (){
        return hasSprinkles;
    }
    public void setSize(String size) {
        this.size = size;
    }
    public void setSprinkles(boolean hasSprinkles) {
        this.hasSprinkles=hasSprinkles;
    }
}
