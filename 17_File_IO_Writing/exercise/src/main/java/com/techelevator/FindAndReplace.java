package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        // Prompt the user for the search word
        System.out.print("What is the search word? ");
        String searchWord = userInput.nextLine();

        // Prompt the user for the replacement word
        System.out.print("What is the replacement word? ");
        String replacementWord = userInput.nextLine();

        // Prompt the user for the source file
        System.out.println("What is the source file? ");
        File sourceFile = new File(userInput.nextLine());

        // Prompt the user for the destination file
        System.out.println("What is the destination file? ");
        File destinationFile = new File(userInput.nextLine());

        // Replace the search word with the replacement word in the file
        try (Scanner fileScanner = new Scanner(sourceFile); // scans the source file
             PrintWriter fileWriter = new PrintWriter(destinationFile)) { // prints to the destination file

            while (fileScanner.hasNextLine()) {// while there is a next line to scan
                String fileString = fileScanner.nextLine();
                fileWriter.println(fileString.replaceAll(searchWord, replacementWord));

            }
            System.out.println("File saved successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("The source or destination file could not be found.");
        }
    }
}