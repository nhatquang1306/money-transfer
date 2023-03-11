package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//prompt user for input
		System.out.println("Enter a number: ");

		//get the next line of input from the user and convert it into an int with parseInt()
		String userInput = scanner.nextLine();
		int maximum = Integer.parseInt(userInput);

		// print out the first two digits of the fib-sequence before looping through remaining values
		System.out.print("0, 1");
		int previousNumber = 1;
		int temp = 0;
		for(int i = 1; i<=maximum;) {
			System.out.print(", " + i);
			temp = previousNumber +i ;
			previousNumber = i;
			i = temp;
		}
		System.out.println();

	}

}
