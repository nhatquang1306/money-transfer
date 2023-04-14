package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) throws FileNotFoundException {
		HotelReservation newReservation = new HotelReservation("Kevin", 2);

		System.out.println("Name: " + newReservation.getName());
		System.out.println("Number of Nights: " + newReservation.getNumberOfNights());

		//create a list of reservations
		List<HotelReservation> reservationsList = new ArrayList<>();

	//read in from file
	File file = new File("data-files/HotelInput.csv"); // not reading the file for some reason. I tried my best.

		try (Scanner fileScanner = new Scanner(file)) {

		while(fileScanner.hasNext()) {
			String line = fileScanner.nextLine();

			String[] lineArray = line.split(", ");
			String name = lineArray[0];
			Integer numberOfNights = Integer.parseInt(lineArray[1]);
			HotelReservation temp = new HotelReservation(name, numberOfNights);
			reservationsList.add(temp);
		}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found - Exiting Program");
			System.exit(1);

		}
			double totalEstimatedTotal = 0;
			for (HotelReservation reservation : reservationsList) {
				totalEstimatedTotal += reservation.getEstimatedTotal();
			}

			System.out.println("Total estimated total for all reservations: $" + totalEstimatedTotal);
		}
	}

