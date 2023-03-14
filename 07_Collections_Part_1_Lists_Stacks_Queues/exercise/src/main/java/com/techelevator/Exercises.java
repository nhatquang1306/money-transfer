package com.techelevator;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Exercises {

	/*
	 Note, for-each is preferred, and should be used when possible.
	 */

    /*
     Given an array of Strings, return an ArrayList containing the same Strings in the same order
     array2List( {"Apple", "Orange", "Banana"} )  ->  ["Apple", "Orange", "Banana"]
     array2List( {"Red", "Orange", "Yellow"} )  ->  ["Red", "Orange", "Yellow"]
     array2List( {"Left", "Right", "Forward", "Back"} )  ->  ["Left", "Right", "Forward", "Back"]
     */
    public List<String> array2List(String[] stringArray) {
        List<String> newList = new ArrayList<String>(Arrays.asList(stringArray));
        return newList;
    }

    /*
     Given a list of Strings, return an array containing the same Strings in the same order
     list2Array( ["Apple", "Orange", "Banana"] )  ->  {"Apple", "Orange", "Banana"}
     list2Array( ["Red", "Orange", "Yellow"] )  ->  {"Red", "Orange", "Yellow"}
     list2Array( ["Left", "Right", "Forward", "Back"] )  ->  {"Left", "Right", "Forward", "Back"}
     */
    public String[] list2Array(List<String> stringList) {
        String[] stringArray = new String[stringList.size()]; // declaring a new array to hold the stuff from the string
        for (int i = 0; i < stringList.size(); i++) { // loop through the list and store each thing in a variable
            stringArray[i] = stringList.get(i); // reassign the value of whatever is at index 'i' in our new strARR to the value of whatever is at index 'i' in the list
        }
        return stringArray;
    }

	/*
	 Given an array of Strings, return an ArrayList containing the same Strings in the same order
	 except for any words that contain exactly 4 characters.
	 no4LetterWords( {"Train", "Boat", "Car"} )  ->  ["Train", "Car"]
	 no4LetterWords( {"Red", "White", "Blue"} )  ->  ["Red", "White"]
	 no4LetterWords( {"Jack", "Jill", "Jane", "John", "Jim"} )  ->  ["Jim"]
	 */

    // 1. Loop through the stringArray, inspecting each element in the array
    // 2. The loop inspects each element in the array and if each element is equal to 4, do not add it

    public List<String> no4LetterWords(String[] stringArray) {
        List<String> newList = new ArrayList<String>(); // You don't have to declare the length of a list, like you have to do for an array because you can change the size of it.
        for (int i = 0; i < stringArray.length; i++) {
            if (!(stringArray[i].length() == 4)) { // if the length of the stringArray does not == 4 and only four
                newList.add(stringArray[i]); // Using newList and calling the .add method and adding whatever is at the index of [i] to the list

            }

        }
        return newList;
    }

    /*
     Given an array of ints, divide each int by 2, and return an ArrayList of Doubles. // We want a list of DOUBLES
     arrayInt2ListDouble( {5, 8, 11, 200, 97} ) -> [2.5, 4.0, 5.5, 100, 48.5]
     arrayInt2ListDouble( {745, 23, 44, 9017, 6} ) -> [372.5, 11.5, 22, 4508.5, 3]
     arrayInt2ListDouble( {84, 99, 3285, 13, 877} ) -> [42, 49.5, 1642.5, 6.5, 438.5]
     */
    public List<Double> arrayInt2ListDouble(int[] intArray) {
        List<Double> arrayDouble = new ArrayList<Double>(); //creating a new List for the doubles
        for (int i = 0; i < intArray.length; i++) { // create a loop to go through the intArray
            arrayDouble.add((intArray[i] / 2.0)); //Using a new List that is a double and adding our contents of intArray to the new list, Apply each of the ints/2 to the new list
        }
        return arrayDouble;        // return a list of the Doubles
    }

    /*
     Given a List of Integers, return the largest value.
     findLargest( [11, 200, 43, 84, 9917, 4321, 1, 33333, 8997] ) -> 33333
     findLargest( [987, 1234, 9381, 731, 43718, 8932] ) -> 43718
     findLargest( [34070, 1380, 81238, 7782, 234, 64362, 627] ) -> 81238
     */
    public Integer findLargest(List<Integer> integerList) {
        return Collections.max(integerList);
        //		int largestInteger = 0;
//		for(Integer number: integerList) {
//			if (number > largestInteger) {
//				largestInteger = number;
//			}
//		}
//		return largestInteger;
//	}
    }

    /*
     Given an array of Integers, return a List of Integers containing just the odd values. // modulu num%2 == 1 because we want odds
     oddOnly( {112, 201, 774, 92, 9, 83, 41872} ) -> [201, 9, 83] //Array -- 112, 201, 774, 92,9, 83, 41872 How do we examine every element to see if it's odd? List: 201, 9, 83 loop through original array if current number mod 2 == 1, then place it into list.
     oddOnly( {1143, 555, 7, 1772, 9953, 643} ) -> [1143, 555, 7, 9953, 643]
     oddOnly( {734, 233, 782, 811, 3, 9999} ) -> [233, 811, 3, 9999]
     */
    public List<Integer> oddOnly(Integer[] integerArray) {

        List<Integer> oddsList = new ArrayList<>();
        for (int i = 0; i < integerArray.length; i++) {

            int currentNumber = integerArray[i];
            if (currentNumber % 2 == 1) {
                oddsList.add(currentNumber);
            }
        }
        return oddsList;
    }

    /*
     Given a List of Integers, and an int value, return true if the int value appears two or more times in
     the list.
     foundIntTwice( [5, 7, 9, 5, 11], 5 ) -> true
     foundIntTwice( [6, 8, 10, 11, 13], 8 -> false
     foundIntTwice( [9, 9, 44, 2, 88, 9], 9) -> true
     */
    public boolean foundIntTwice(List<Integer> integerList, int intToFind) {
        int count = 0; //create an int counter to see how many times it would appear
        for (int i = 0; i < integerList.size(); i++) { //List needs a .size() to run the length of the list and keep looping through it
            if (integerList.get(i) == intToFind) { // if integer located at index (i) is equal to intToFind, increase the count
                count++;
            }
        }
        if (count >= 2) { //if count is greater than or equal to 2 then return true
            return true;
        }
        return false;
    }

    /*
     Given an array of Integers, return a List that contains the same Integers (as Strings). Except any multiple of 3
    must be replaced by the String "Fizz", any multiple of 5 must be replaced by the String "Buzz",
    and any multiple of both 3 and 5 must be replaced by the String "FizzBuzz."
    ** INTERVIEW QUESTION **

    fizzBuzzList( {1, 2, 3} )  ->  ["1", "2", "Fizz"]
    fizzBuzzList( {4, 5, 6} )  ->  ["4", "Buzz", "Fizz"]
    fizzBuzzList( {7, 8, 9, 10, 11, 12, 13, 14, 15} )  ->  ["7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14", "FizzBuzz"]

    HINT: To convert an Integer x to a String, you can use x.toString() in your code. For example, if x = 1, then x.toString() returns "1."
     */
    public List<String> fizzBuzzList(Integer[] integerArray) {
        List<String> integerList = new ArrayList<>(); //method header return type is a List of strings
        for (Integer num : integerArray) {//1. create a loop to inspect each element in the integerArray
            if (num % 3 == 0 && num % 5 == 0) {//2. if an element is a multiple of both 3 and 5 then insert "FizzBuzz" into the list
                integerList.add("FizzBuzz");
            } else if (num % 3 == 0) {
                integerList.add("Fizz");  //3. if an element is a multiple of 3 then insert "Fizz" into list
            } else if (num % 5 == 0) {
                integerList.add("Buzz");   //4. if an element is a multiple of 5 then insert "Buzz" into list
            } else {
                integerList.add(num.toString()); //5. if it isn't a multiple of any of those, then convert to a string and add it to the list
            }
        }

        return integerList; //6. Finally, return the list.
    }

    /*
     Given two lists of Integers, interleave them beginning with the first element in the first list followed
     by the first element of the second. Continue interleaving the elements until all elements have been interwoven.
     Return the new list. If the lists are of unequal lengths, simply attach the remaining elements of the longer
     list to the new list before returning it.
     interleaveLists( [1, 2, 3], [4, 5, 6] )  ->  [1, 4, 2, 5, 3, 6]
     interleaveLists( [7, 1, 3], [2, 5, 7, 9] )  ->  [7, 2, 1, 5, 3, 7, 9]
     interleaveLists( [1, 2, 5, 8, 10], [4, 5, 6] )  ->  [1, 4, 2, 5, 5, 6, 8, 10]
     */
    public List<Integer> interleaveLists(List<Integer> listOne, List<Integer> listTwo) {
        List<Integer> output = new ArrayList<>();
        int largestSize = listOne.size();
        if (listOne.size() < listTwo.size()) {
            largestSize = listTwo.size();
        }

        for (int i = 0; i < largestSize; i++) {
            if (!listOne.isEmpty()) {
                output.add(listOne.remove(0));
            }
            if (!listTwo.isEmpty()) {
                output.add(listTwo.remove(0));
            }
        }
        return output;
    }

}
