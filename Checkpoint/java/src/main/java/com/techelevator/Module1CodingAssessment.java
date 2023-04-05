package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		List<Car> listOfCars = new ArrayList<>(); // made new list to store cars from file
		File file = new File("CarInput.csv"); // set new file object to the filepath
		try {
			Scanner scanner = new Scanner(file); // made a scanner for the file
			while (scanner.hasNextLine()) { // while loop to loop through all lines in the file
				String line = scanner.nextLine(); // use scanner to scan next line and store it into a string
				String [] cars = line.split(","); //split up car lines and stored them in a new array
				Car car = new Car(Boolean.valueOf(cars[2]), Integer.valueOf(cars[0]), cars[1]); // created new car object with the values stored in the array
				listOfCars.add(car); // add each of the car objects to the list
			}

		} catch (FileNotFoundException e) {
		}
		int sum = 0;
		for (Car car : listOfCars) {//for each car object in the list of cars
			sum += car.getAge(); // get the age of the car and add it to the sum
		}
		System.out.println(sum); // print out the sum of all ages of cars
	}
	}