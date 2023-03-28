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
        File sourceFile = getFileFromUser("What is the source file? ");

        // Prompt the user for the destination file
        File destinationFile = getFileFromUser("What is the destination file? ");

        // Replace the search word with the replacement word in the file
        try (Scanner fileScanner = new Scanner(sourceFile); // scans the source file
             PrintWriter fileWriter = new PrintWriter(destinationFile)) { // prints to the destination file

            while (fileScanner.hasNextLine()) {// while there is a next line to scan
                String line = fileScanner.nextLine();//create a string to scan next line
                String replacedLine = line.replaceAll(searchWord, replacementWord); // replace searched word with replacement word
                fileWriter.println(replacedLine); // print the replaced line
            }
            System.out.println("File saved successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("The source or destination file could not be found.");
        }
    }

    // Helper method to prompt the user for a file path and return the corresponding File object
    public File getFileFromUser(String prompt) {
        File file = null;

        while (file == null || !file.exists()) {
            System.out.print(prompt);
            String filePath = userInput.nextLine();
            file = new File(filePath);

            if (!file.exists()) {
                System.out.println("File not found.");
            }
        }

        return file;
    }

}