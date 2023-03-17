package com.techelevator;

import java.util.*;

public class Exercises {

	/*
	 * Given the name of an animal, return the name of a group of that animal
	 * (e.g. "Elephant" -> "Herd", "Rhino" - "Crash").
	 *
	 * The animal name should be case insensitive so "elephant", "Elephant", and
	 * "ELEPHANT" should all return "Herd".
	 *
	 * If the name of the animal is not found, null, or empty, return "unknown".
	 *
	 * Rhino -> Crash
	 * Giraffe -> Tower
	 * Elephant -> Herd
	 * Lion -> Pride
	 * Crow -> Murder
	 * Pigeon -> Kit
	 * Flamingo -> Pat
	 * Deer -> Herd
	 * Dog -> Pack
	 * Crocodile -> Float
	 *
	 * animalGroupName("giraffe") → "Tower"
	 * animalGroupName("") -> "unknown"
	 * animalGroupName("walrus") -> "unknown"
	 * animalGroupName("Rhino") -> "Crash"
	 * animalGroupName("rhino") -> "Crash"
	 * animalGroupName("elephants") -> "unknown"
	 *
	 */
	public String animalGroupName(String animalName) {
		Map<String, String> animalGroupName = new HashMap<>(); // Create new map to insert animal names into
		animalGroupName.put("rhino", "Crash"); // Insert first animal and group
		animalGroupName.put("giraffe", "Tower");
		animalGroupName.put("elephant", "Herd");
		animalGroupName.put("lion", "Pride");
		animalGroupName.put("crow", "Murder");
		animalGroupName.put("pigeon", "Hit");
		animalGroupName.put("flamingo", "Pat");
		animalGroupName.put("deer", "Herd");
		animalGroupName.put("dog", "Pack");
		animalGroupName.put("crocodile", "Float");

		if (animalName != null && animalGroupName.containsKey(animalName.toLowerCase())) { // Making sure name isn't null and checking if map made contains key and converting it to lowercase, so they all match
			return animalGroupName.get(animalName.toLowerCase()); //If they pass in animal name it should convert it to lower case
		}
		return "unknown";

	}

	/*
	 * Given a String item number (a.k.a. SKU), return the discount percentage if the item is on sale.
	 * If the item is not on sale, return 0.00.
	 *
	 * If the item number is empty or null, return 0.00.
	 *
	 * "KITCHEN4001" -> 0.20
	 * "GARAGE1070" -> 0.15
	 * "LIVINGROOM"	-> 0.10
	 * "KITCHEN6073" -> 0.40
	 * "BEDROOM3434" -> 0.60
	 * "BATH0073" -> 0.15
	 *
	 * The item number should be case insensitive so "kitchen4001", "Kitchen4001", and "KITCHEN4001"
	 * should all return 0.20.
	 *
	 * isItOnSale("kitchen4001") → 0.20
	 * isItOnSale("") → 0.00
	 * isItOnSale("GARAGE1070") → 0.15
	 * isItOnSale("dungeon9999") → 0.00
	 *
	 */
	public double isItOnSale(String itemNumber) { //Given a item number
		Map<String, Double> isOnSale = new HashMap<>();//Make a new Map for each of the discount codes to be entered into. String of the SKU and Value of the discount
		isOnSale.put("KITCHEN4001", 0.20); // Built new map using discount SKU
		isOnSale.put("GARAGE1070", 0.15);
		isOnSale.put("LIVINGROOM", 0.10);
		isOnSale.put("KITCHEN6073", 0.40);
		isOnSale.put("BEDROOM3434", 0.60);
		isOnSale.put("BATH0073", 0.15);
		if ((itemNumber != null) && isOnSale.containsKey(itemNumber.toUpperCase())) { // create if statement to ensure item is on sale, or if it is on sale
			return isOnSale.get(itemNumber.toUpperCase()); // returns value of discount amount
		}
		return 0.00;

	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
	 * but only if Paul has less than $10s.
	 *
	 * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
	 *
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 99}) → {"Peter": 1000, "Paul": 1099}
	 * robPeterToPayPaul({"Peter": 2000, "Paul": 30000}) → {"Peter": 2000, "Paul": 30000}
	 * robPeterToPayPaul({"Peter": 101, "Paul": 500}) → {"Peter": 51, "Paul": 550}
	 * robPeterToPayPaul({"Peter": 0, "Paul": 500}) → {"Peter": 0, "Paul": 500}
	 *
	 */
	public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
		// create new hashmap to deposit said money into and represent amount paul takes
		Map<String, Integer> peterToPayPaul = new HashMap<>();
		peterToPayPaul.put("Paul", peterPaul.get("Paul"));
		peterToPayPaul.put("Peter", peterPaul.get("Peter"));

		//if statement for if peter has more than 0 dollars and paul has less than 10
		if (peterPaul.get("Peter") > 0 && peterPaul.get("Paul") < 1000) {

			// calculations to subtract from peter and add to paul
			int peterStolenMoney = peterPaul.get("Peter") / 2;
			int paulStealMoney = peterPaul.get("Paul") + peterStolenMoney;

			peterToPayPaul.put("Paul", paulStealMoney);
			peterToPayPaul.put("Peter", peterPaul.get("Peter") - peterStolenMoney);
		}

		return peterToPayPaul;
	}

	/*
	 * Modify and return the given Map as follows: if "Peter" has $50 or more, AND "Paul" has $100 or more,
	 * then create a new "PeterPaulPartnership" worth a combined contribution of a quarter of each partner's
	 * current worth.
	 *
	 * peterPaulPartnership({"Peter": 50000, "Paul": 100000}) → {"Peter": 37500, "Paul": 75000, "PeterPaulPartnership": 37500}
	 * peterPaulPartnership({"Peter": 3333, "Paul": 1234567890}) → {"Peter": 3333, "Paul": 1234567890}
	 *
	 */
	public Map<String, Integer> peterPaulPartnership(Map<String, Integer> peterPaul) { // gives us peterPaul as a parameter in the method, is a Map
		Map<String, Integer> contribution = new HashMap<>(); // declared new map to return later on

		if (peterPaul.get("Peter") >= 5000 && peterPaul.get("Paul") >= 10000) {//if statement to check Peter and Paul's balances using conditions of each cent amount
			Integer peterContribution = peterPaul.get("Peter") / 4; //Made Integer to calculate how much their contributions are
			Integer paulContribution = peterPaul.get("Paul") / 4;

			contribution.put("PeterPaulPartnership", peterContribution + paulContribution); //Assigning the combined amount to the Method Key "PeterPaulPartnership". .put() populating contribution map

			contribution.put("Peter", peterPaul.get("Peter") - peterContribution);
			contribution.put("Paul", peterPaul.get("Paul") - paulContribution);
		} else {
			return peterPaul;
		}

		return contribution;
	}

	/*
	 * Given an array of non-empty Strings, return a Map<String, String> where for every different String in the array,
	 * there is a key of its first character with the value of its last character.
	 *
	 * beginningAndEnding(["code", "bug"]) → {"b": "g", "c": "e"}
	 * beginningAndEnding(["man", "moon", "main"]) → {"m": "n"}
	 * beginningAndEnding(["muddy", "good", "moat", "good", "night"]) → {"g": "d", "m": "t", "n": "t"}
	 */
	public Map<String, String> beginningAndEnding(String[] words) { // Given an array of non-empty string
		Map<String, String> firstLastList = new HashMap<>(); // new map
		for (int i = 0; i < words.length; i++) {

			String currentWord = words[i]; // i Represents the current word you are currently looking at in the iteration of the loop
			String firstCh = currentWord.substring(0, 1); // extract the first character, use substring
			String lastCh = currentWord.substring(currentWord.length() - 1); // extract the final character
			firstLastList.put(firstCh, lastCh);
		}
		return firstLastList; // return filled map
	}

	/*
	 * Given an array of Strings, return a Map<String, Integer> with a key for each different String, with the value the
	 * number of times that String appears in the array.
	 *
	 * ** A CLASSIC **
	 *
	 * wordCount(["ba", "ba", "black", "sheep"]) → {"ba" : 2, "black": 1, "sheep": 1 }
	 * wordCount(["a", "b", "a", "c", "b"]) → {"b": 2, "c": 1, "a": 2}
	 * wordCount([]) → {}
	 * wordCount(["c", "b", "a"]) → {"b": 1, "c": 1, "a": 1}
	 *
	 */
	public Map<String, Integer> wordCount(String[] words) {
		Map<String, Integer> counts = new HashMap<>(); // create an empty hashmap to store the word counts
		for (String word : words) { // Foreach to iterate through the input array and count for each word in the hashmap, checks each word for actual word in array
			if (counts.containsKey(word)) { //if array contains Key word, then adds one to the count map
				counts.put(word, counts.get(word) + 1); //sees if word and next word in array match the words value overwrites previous entry
			} else {
				counts.put(word, 1); //adds word to key, with a value of 1
			}
		}

		return counts; // return map as output
	}

	/*
	 * Given an array of int values, return a Map<Integer, Integer> with a key for each int, with the value the
	 * number of times that int appears in the array.
	 *
	 * ** The lesser known cousin of the the classic wordCount **
	 *
	 * intCount([1, 99, 63, 1, 55, 77, 63, 99, 63, 44]) → {1: 2, 44: 1, 55: 1, 63: 3, 77: 1, 99:2}
	 * intCount([107, 33, 107, 33, 33, 33, 106, 107]) → {33: 4, 106: 1, 107: 3}
	 * intCount([]) → {}
	 *
	 */
	public Map<Integer, Integer> integerCount(int[] ints) {
		Map<Integer, Integer> count = new HashMap<>();
		for (Integer counts : ints) {
			if (count.containsKey(counts)) {
				count.put(counts, count.get(counts) + 1);
			} else {
				count.put(counts, 1);
			}
		}

		return count;
	}

	/*
	 * Given an array of Strings, return a Map<String, Boolean> where each different String is a key and value
	 * is true only if that String appears 2 or more times in the array.
	 *
	 * wordMultiple(["a", "b", "a", "c", "b"]) → {"b": true, "c": false, "a": true}
	 * wordMultiple(["c", "b", "a"]) → {"b": false, "c": false, "a": false}
	 * wordMultiple(["c", "c", "c", "c"]) → {"c": true}
	 *
	 */
	public Map<String, Boolean> wordMultiple(String[] words) { // Take an array of strings as an input and return a map with the strings as keys and boolean values
		Map<String, Boolean> resultMap = new HashMap<>(); //Create array to store the final amount, whether the string appears 2 or more times.

		for (String letters : words) { //loops through string provided of words and letters
			if (resultMap.containsKey(letters)) { //checks if the new map contains the same keys as letters

				resultMap.put(letters, true); //adds letters to the Key of the map and returns true for value

			} else {
				resultMap.put(letters, false); //otherwise add letters and return false for value
			}
		}
			return resultMap; // Return the total entries in the result map
		}



		/*
	 * Given two Maps, Map<String, Integer>, merge the two into a new Map, Map<String, Integer> where keys in Map2,
	 * and their int values, are added to the int values of matching keys in Map1. Return the new Map.
	 *
	 * Unmatched keys and their int values in Map2 are simply added to Map1.
	 *
	 * consolidateInventory({"SKU1": 100, "SKU2": 53, "SKU3": 44} {"SKU2":11, "SKU4": 5})
	 * 	 → {"SKU1": 100, "SKU2": 64, "SKU3": 44, "SKU4": 5}
	 *
	 */
	public Map<String, Integer> consolidateInventory(Map<String, Integer> mainWarehouse, Map<String, Integer> remoteWarehouse) { // Two maps are given as input
		Map<String, Integer> mergeMap = new HashMap<>(mainWarehouse); // Add the contents of the main warehouse to the new map
		for (Map.Entry<String, Integer> entry : remoteWarehouse.entrySet()) {// For loop is creating a string entry and is looping through remote warehouse from beginning to end
			String key = entry.getKey(); //The string that was just created is getting the keys
			int value = entry.getValue(); //The int is getting the value from the remote warehouse

			if (mergeMap.containsKey(key)) { //calling first map and checking to see if it contains the content from the for loop
				int newValue = mergeMap.get(key) + value; //if new map contains the key, then newValue int will be equal to new map key and value.
				mergeMap.put(key, newValue); //Add new merged keys and values to new map
			} else {
				mergeMap.put(key, value); // if the key doesn't match the key and value are added to the new map
			}
		}

		return mergeMap;
	}

	/*
	 * Just when you thought it was safe to get back in the water --- last2Revisited!!!!
	 *
	 * Given an array of Strings, for each String, the count of the number of times that a subString length 2 appears
	 * in the String and also as the last 2 chars of the String, so "hixxxhi" yields 1.
	 *
	 * We don't count the end subString, but the subString may overlap a prior position by one.  For instance, "xxxx"
	 * has a count of 2, one pair at position 0, and the second at position 1. The third pair at position 2 is the
	 * end subString, which we don't count.
	 *
	 * Return Map<String, Integer>, where the key is String from the array, and its last2 count.
	 *
	 * last2Revisited(["hixxhi", "xaxxaxaxx", "axxxaaxx"]) → {"hixxhi": 1, "xaxxaxaxx": 1, "axxxaaxx": 2}
	 *
	 */
	public Map<String, Integer> last2Revisited(String[] words) {
		return null;
	}

}
