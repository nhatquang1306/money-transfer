package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class WordSearch {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) throws FileNotFoundException {
		WordSearch wordSearch = new WordSearch();
		wordSearch.run();
	}

	public void run() throws FileNotFoundException {
		int numberOfLines=0;
		try(userInput) { // if there's any problem with user input it does a path to handle it.
			System.out.println("What is the fully qualified name of the file that should be searched?");
			//get input from user
			//save input to path variable
			//String defaultPath = "alices_adventures_in_wonderland.txt";
			String path = userInput.nextLine();
			File file = new File(path); // enters in file name

			System.out.println("What is the search word you are looking for?");
			//get input from user
			//save input to searchWord variable
			String searchWord = userInput.nextLine(); // this searches through the text to find the line number its on
			System.out.println("Should this search be case sensitive? (Y/N)");
			String userChoice = userInput.nextLine();
			try (Scanner inputScanner = new Scanner(file)) {
				while (inputScanner.hasNextLine()) {
					String line = inputScanner.nextLine();
					numberOfLines++;
					if (userChoice.toLowerCase().equals("n")) {
						if (line.toLowerCase().contains(searchWord)) {
							System.out.println(numberOfLines + ") " + line);
						}
					} else {
						if (line.contains(searchWord)) {
							System.out.println(numberOfLines + ") " + line);
						}
					}

				}
			} catch (FileNotFoundException e) {
				System.out.println("Error reading file");
			}
		}
	}
}
