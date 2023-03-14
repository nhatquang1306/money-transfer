package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a decimal series (separated by spaces): ");
		String userInput = scanner.nextLine();

		// String [] inputArr = input.split("\\,");
		String[] numArray = userInput.split(" ");
		for (int ix = 0; ix < numArray.length; ix++) {

			int newNum = Integer.parseInt(numArray[ix]);

			System.out.print("You entered: " + newNum);
			String answer = " ";

			for (int i = newNum; i>0;) {
				int remainder = i%2;
				i=i/2;
				answer = remainder + answer;
			}
			System.out.println(" In Binary Is " + answer);
		}
	}
}