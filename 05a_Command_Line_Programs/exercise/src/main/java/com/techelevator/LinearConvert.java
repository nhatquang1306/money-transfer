package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a length: "); // asks for a length
		String userInput = input.nextLine();// looks at the user's input and assigns variable
		double lengthInput = Double.parseDouble(userInput);

		System.out.print("Is it in Meters or Feet? ");
		String measurement = input.nextLine();

		if (measurement.equals("f")) {
			int meters = (int)(lengthInput * 0.3048); // To Do: print out to user
			System.out.println(meters);
		}
		else if (measurement.equals("m")) {
			int feet = (int)(lengthInput * 3.2808399);
			System.out.println(feet);


//		public double metersToFeet(double meters){
//			final double f = meters * 3.2808399;
//			final double meters = feet * 0.3048;
//			return feet * 0.3048;

		}
	}


}
