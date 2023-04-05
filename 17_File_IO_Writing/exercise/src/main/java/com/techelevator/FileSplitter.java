package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSplitter {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
 //   private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        //FileSplitter fileSplitter = new FileSplitter();
       // fileSplitter.run();

        System.out.println( foundIntTwice(new int[]{1,2,1,2,3}, 4));


    }

//    public void run() {
//        System.out.println("Where is the input file (please include the path to the file)?");
//        String path = userInput.nextLine();
//
//        System.out.println("How many lines of text (max) should there be in the split files?");
//        String linesString = userInput.nextLine();
//        int numberOfLines = Integer.parseInt(linesString);
//
//        File sourceFile = new File(path);
//        int counter = 0;
//        try (Scanner sourceScanner = new Scanner(sourceFile.getAbsoluteFile())) {
//            while (sourceScanner.hasNextLine()) {
//                String line = sourceScanner.nextLine();
//                counter++;
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("File not found");
//        }
//
//        System.out.println("The input file has " + counter + " lines of text.");
//
//        int numberOfOutputFiles = 0;
//        if (counter % numberOfLines == 0) {
//            numberOfOutputFiles = counter / numberOfLines;
//        } else {
//            numberOfOutputFiles = (counter / numberOfLines) + 1;
//        }
//        System.out.println("For a " + counter + " line input file 'input.txt', this produces " + numberOfOutputFiles + " output files.");
//
//        System.out.println(";**GENERATING OUTPUT**");
//
//
////		System.out.println("Generating ");



    //	Create a boolean method called foundIntTwice that takes in an integer array “nums” and an integer “value.”
//	Given the integer array and an integer value, return true if the int value appears two or more times in the array.
    public static boolean foundIntTwice(int[] nums, int value) {
        //since I'm given an integer array and a value I need to determine if the value appears two or more times in the array
        //loop through the array to count the amount of times value appears
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums [i]== value){
                count++;
            }
            // if int value is read in the array then add to the count
            if (count >= 2) {
                return true;
            }
        } return false;
    }


}





















