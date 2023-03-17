package com.techelevator;

public class FruitTree {
    //Instance Variable
    private String typeOfFruit;
    private int piecesOfFruitLeft;

    //Constructor
    public FruitTree(String typeOfFruit, int piecesOfFruitLeft) {
        this.typeOfFruit = typeOfFruit;
        this.piecesOfFruitLeft = piecesOfFruitLeft;
    }

    //GETTERS AND SETTERS
    public String getTypeOfFruit() {
        return typeOfFruit;
    }

    public int getPiecesOfFruitLeft() {
        return piecesOfFruitLeft;
    }

    //METHOD
    public boolean pickFruit(int numberOfPiecesToRemove){
        if (piecesOfFruitLeft>=numberOfPiecesToRemove) {
            piecesOfFruitLeft = piecesOfFruitLeft-numberOfPiecesToRemove;
            return true;
        }
        return false;
    }
}
