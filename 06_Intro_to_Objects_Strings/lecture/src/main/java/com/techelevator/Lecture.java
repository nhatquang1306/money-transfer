package com.techelevator;

import java.util.Locale;

public class Lecture {

	public static void main(String[] args) {

		Cake partyCake = new Cake("Large", false);

		System.out.println(partyCake.getSize());

		partyCake.setSprinkles(true);
		System.out.println(partyCake.getSize());


//		int [] numberList = new int[5];
//		numberList[0] = 5;
//		numberList[1] = 10;
//		numberList[2] = 7;
//		numberList[3] = 8;
//		numberList[4] = 19;
//
//		// sum up all values of the numberList
//		int sumOfNumbers = 0;
//		for(int i = 0; i < numberList.length-1; i++) { // -1 stops from out of bounds
//			sumOfNumbers += numberList[i]; // same as sumOfNumbers = sumOfNumbers + numberList[i]
//		}
//		System.out.println(sumOfNumbers);

		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */
		/* create an new instance of String using a literal */
		String literalString = "literal string";
		//System.out.println("this is a literal string: " + literalString);

		String newString = new String(new char[] {'a','b','c'});

		System.out.println("newString is: " + newString);

		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();


//		System.out.println(" *** charAt() ***");
//		String name = "Ben Rohus";
//		char first = name.charAt(0);
//		char fourth = name.charAt(3);
//		char h = name.charAt(6);
//		System.out.println("is h, h: .... " + h);
//
//
//		for (char character:name.toCharArray()) {
//			System.out.println(character);
//		}
//
//		System.out.println(" *** contains ***");
//		String hello = "Hello World";
//
//		boolean containsHello = hello.contains("Hello");
//		System.out.println("contains hello? " + containsHello);
//
//		boolean containsHelloChained = hello.toLowerCase().contains("hello".toLowerCase());
//		boolean containsIgnoreCase = hello.equalsIgnoreCase("hello world!");
//		boolean containsOnly = hello.contains("hello world!");
//
//		System.out.println(containsHelloChained + " " + containsIgnoreCase + " " + containsOnly);


		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		String endsWithTest= "whatever";
		//System.out.println((endsWithTest.endsWith("ever") && endsWithTest.endsWith("tever")));

		String startsWith = "NewString";
		//System.out.println((startsWith.startsWith("new") || startsWith.startsWith("NewSt")));

		String indexTest = "123456";
		System.out.println(indexTest);

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
