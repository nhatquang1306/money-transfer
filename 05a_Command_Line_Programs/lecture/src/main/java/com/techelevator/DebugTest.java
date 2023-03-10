package com.techelevator;

import java.util.Random;

public class DebugTest {

    public static void main(String[] args) {
        String whatDoesThisDo = debugTest();
        System.out.println(whatDoesThisDo);
    }


    public static String debugTest() {
        String wildWord = "";
        Random randomNumberGenerator = new Random();
        while(wildWord.length()<10){
            int randomNumber = randomNumberGenerator.nextInt(26) +65;
            char letter = (char)randomNumber;
            wildWord += letter;
        }
        for (int i = 0; i < wildWord.length(); i++) {
            System.out.println(wildWord.charAt(i)+ " " + (int)wildWord.charAt(i));
        }
        return wildWord;
    }
}
