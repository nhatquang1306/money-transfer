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
		Car car = new Car(2018, "Ford Mustang", false);

		System.out.println("Car: " + car.getYear() + " " + car.getMake());
		System.out.println("Classic Car? " + car.isClassicCar());
		System.out.println("Age of car: " + car.getAge());

		//create a list of car objects
		List<Car> carList = new ArrayList<>();

		//read in from file
		File file = new File("carInput.csv");

		//try with resources == will handle closing for me
		try (Scanner fileScanner = new Scanner(file)) {
			//check for more content
			while(fileScanner.hasNext()) {
				String line = fileScanner.nextLine();
				//System.out.println(line);
				String[] lineArray = line.split(",");
				int year = Integer.parseInt(lineArray[0]);
				String make = lineArray[1];
				boolean isClassicCar = Boolean.parseBoolean(lineArray[2]);
				Car temp = new Car(year, make, isClassicCar);
				carList.add(temp);
			}

			int totalAge = 0;

			//foreach loop to loop through the car list
			for (Car c : carList) {
				System.out.println(c.toString());
				totalAge += c.getAge();
			}
			System.out.println("Total age of all cars:" + totalAge);

		} catch (FileNotFoundException e) {
			System.out.println("File not found - exiting program");
		}
	}
}