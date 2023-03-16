package com.techelevator;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class Lecture {

	public static void main(String[] args) {

		System.out.println("####################");
		System.out.println("        MAPS");
		System.out.println("####################");
		System.out.println();

		//Declaring and initializing our Map
		Map <String, String> nameToZip = new HashMap <>();

		//Adding items to our map
		nameToZip.put("David", "44120"); // adding David to a zip code on a map with .put
		nameToZip.put("Dan","44124"); // First spot is what you're adding, second spot is where it's added to
		nameToZip.put("Elizabeth", "44012");
		System.out.println();

		// Retrieve items from the Map
		System.out.println(); // adds a blank line
		String variableName = "David"; // can also use a set string name to access information
		System.out.println("David lives in " + nameToZip.get(variableName)); // Using .get to grab information on David, make sure it matches exactly as it is case sensitive.
		System.out.println("Dan lives in " + nameToZip.get("Dan"));
		System.out.println("Elizabeth lives in " + nameToZip.get("Elizabeth"));
		System.out.println();

		//Retrieving all the keys in a map
		System.out.println("We can also retrive a list of keys and iterate over them using a for loop: ");

		for (String name : nameToZip.keySet()) {
			System.out.println(name + " lives in " + nameToZip.get(name)); // lists off who lives in which zip code
		}

		for (Map.Entry<String, String> pair : nameToZip.entrySet()) {
			System.out.println(pair.getKey() + " lives in: " + pair.getValue()); //iterates through every entry in the set

		}
		System.out.println();

		// Remove an element from the Map
		nameToZip.remove("David");
		System.out.println("removed David");

		for (Map.Entry<String, String> pair : nameToZip.entrySet()) {
			System.out.println(pair.getKey() + " lives in " + pair.getValue());
	}
		System.out.println();
		//testing contains
		System.out.println("Does map contain Dan? " + nameToZip.containsKey("Dan"));
		System.out.println("Does map have the city Las Vegas? " + nameToZip.containsValue("Las Vegas"));

		System.out.println("####################");
		System.out.println("        SETS");
		System.out.println("####################");
		System.out.println();

		Set<String> mammals = new TreeSet<>(); // TreeSet sorts the entire list whenever you enter a new value based on alphabet, HashSet doesn't
		mammals.add("panda");
		mammals.add("walrus");
		mammals.add("platypus");
		mammals.add("whale");

		for(String mammal: mammals) {
			System.out.println(mammal);
		}

	}


}
