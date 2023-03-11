package com.techelevator;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TempConvert {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // create a variable of type Scanner; called it 'input'
		System.out.println("Input a Temperature: "); // print a prompt for the user to the console
		String userInput = scanner.nextLine(); //create a variable of type string to store the users input from your scanner
		int temperatureInput = Integer.parseInt(userInput);

		System.out.println("C or F?");
		String temperatureScale = scanner.nextLine();

		if (temperatureScale.equals("C")) { //read user input
			temperatureInput = (int)(temperatureInput*1.8+32); //set equation for converting input
			System.out.println(temperatureInput + "F"); //concat temperature with unit of degrees
		}
		else if (temperatureScale.equals("F")) {
			temperatureInput = (int)((temperatureInput-32)/1.8);
			System.out.println(temperatureInput + "C");
		}

	}

}
