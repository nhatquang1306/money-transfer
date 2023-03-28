package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() {
		System.out.print("Enter destination file: "); //prompts user for destination file
		String destinationFile = userInput.nextLine();// user puts in destination for the file writer

		// Create file and PrintWriter
		File file = new File(destinationFile); // creating new file at destination file for the printwriter to print to
		PrintWriter writer = null; // printwriter set to empty
		try {
			writer = new PrintWriter(file); // setting the print writer to write to a specified file
		} catch (FileNotFoundException e) { // if file isnt found it throws an expection
			System.out.println("Invalid destination file");
			System.exit(1);// exits out if it's invalid
		}

		// Write FizzBuzz results to file
		for (int i = 1; i <= 300; i++) { // for loop to iterate through all 300 results checking for multiples
			if (i % 3 == 0 && i % 5 == 0) {
				writer.println("FizzBuzz"); // writes fizzbuzz to the file
			} else if (i % 3 == 0) {
				writer.println("Fizz");
			} else if (i % 5 == 0) {
				writer.println("Buzz");
			} else {
				writer.println(i); // if not multiple it'll just print the number
			}
		}

		// Close PrintWriter
		writer.close();
		System.out.println("FizzBuzz results written to " + destinationFile); // what it prints to the user
	}
}