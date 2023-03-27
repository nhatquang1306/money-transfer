package com.techelevator.scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {
    public static void main(String[] args) {

        System.out.println("what is the file path?");
        Scanner input = new Scanner(System.in); // input from the keyboard. Basically user interface.
        String path = input.nextLine(); //create scanner to get next line as a string

        File file = new File(path); // creating file

        try(Scanner fileScanner = new Scanner(file)) { // scan file we created
            String lineFromFile = fileScanner.nextLine(); //getting first line
            System.out.println(lineFromFile);//print out first line
        }
         catch (FileNotFoundException e) { //catches if there is a file not found
            throw new RuntimeException(e); // throws a runtime exception when we search for the file, and it isn't a real file
        }

    }
}
