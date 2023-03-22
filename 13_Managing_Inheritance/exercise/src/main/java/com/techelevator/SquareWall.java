package com.techelevator;

public class SquareWall extends RectangleWall {
    private int sideLength;

    public SquareWall(String name, String color, int sideLength) {
        super(name, color);
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    //method
    public String toString() {
        return getName() + " (" + sideLength + "x" + sideLength + ") square";
    }
    public int getArea()  {
        return sideLength * sideLength;
    }
}
