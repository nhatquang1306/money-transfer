package com.techelevator;

import org.junit.After; // The @After annotation is used to execute a method after every test
import org.junit.Assert; // The Assert class has static assertion methods for validating test results
import org.junit.Before; // The @Before annotation is used to execute a method before every test
import org.junit.Test; // The @Test annotation is used to label methods that should be run as tests
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

import java.util.HashMap;
import java.util.Map;

/* Like all other Java code, unit testing code is defined within a class.
 * Each test class will typically contain all the unit tests for a single
 * "unit" of production code.
 *
 * If the "unit" is a single class from the production code, then the
 * convention is that the test class will belong to the same package as the
 * class under test and the name of the test class is the name of the
 * production class with "Test" at the end.  For example, the test class
 * for the production class "Foo" would be "FooTest"
 */

// Class annotation - Run tests alphabetically
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

/*
 * TEST CLASS DECLARATION
 */
public class LectureTest {

	// Shared property of the object type being tested
	Lecture lecture;

/*
 * SETUP: If a method is annotated with @Before, it will be executed
 * immediately prior to every test. It is intended to be used when there is a
 * repetitive setup (i.e. "Arrange") task that is performed by several tests.
 */
@Before
public void setup() {
	lecture = new Lecture();
	System.out.println("Setup with the @Before method");
}

/*
 * CLEANUP: If a method is annotated with @After, it will be executed immediately
 * after every test. It is intended to be used when there is a repetitive cleanup
 * task that is performed by several tests (e.g. deleting temp files, rolling back
 * database transactions, etc.)
 */
@After
public void cleanup() {
	System.out.println("Cleanup with the @After method");
}

/*
 * TESTS: Each test is implemented as a method with the @Test annotation. When the JUnit
 * framework is invoked, it looks for these @Test annotations on the test class
 * and runs such methods as tests.
 *
 * You will notice that the naming convention used in the test methods below
 * deviates from standard Java method naming conventions by using underscores
 * between words instead of camelCase. This is my own personal convention and
 * should not be construed as a general standard or convention. You can also
 * use camelCase for test method names. You should follow the norm at whatever
 * development organization you join.
 *
 * Regardless of whether you use camelCase or underscores, your method names
 * should be very descriptive to the point of being overly verbose. This is fine
 * because you will never write code to invoke your test methods, they are only
 * invoked by the Junit framework, hence descriptive trumps concise.
 *
 * Test methods always:
 *     - are public
 *     - return void
 *     - take no arguments
 */
	@Test
	public void length_returns_the_number_of_characters_in_a_String() {
		System.out.println("length_returns_the_number_of_characters_in_a_String"); // FOR DEMONSTRATION PURPOSES ONLY, don't do this in your own tests

		/* The assertEquals method validates that two values are equal and
		 * fails the test if they are not equal */

		String theString = "Java"; // Arrange
		int length = theString.length(); // Act
		Assert.assertEquals(4, length); // Assert
	}

	@Test
	public void startsWith_returns_true_if_a_string_starts_with_the_specified_characters() {
		System.out.println("startsWith_returns_true_if_a_string_starts_with_the_specified_characters"); // FOR DEMONSTRATION PURPOSES ONLY, don't do this in your own tests

		/* The assertTrue method validates that the boolean value provided as an argument
		 * is true and fails the test if it is false. */

		String theString = "Hello World!"; // Arrange
		boolean startsWithHello = theString.startsWith("Hello"); // Act

		/* every assert method allows the first parameter to be a String that contains a message
		 * that should be displayed when the assertion fails
		 *
		 * This is particularly helpful with assertTrue as otherwise the failure output would simply
		 * state "Expected: true Actual: false", which sometimes isn't much help in figuring out
		 * what went wrong */
		Assert.assertTrue(startsWithHello); // Assert
	}

//	@Test
//	public void this_test_fails_every_time() {
//		System.out.println("this_test_fails_every_time"); // FOR DEMONSTRATION PURPOSES ONLY, don't do this in your own tests
//
//		/* The fail method will cause a test to fail */
//
//		Assert.fail("This is how I can force a test to fail");
//	}

	public void this_method_is_not_a_test_because_it_does_not_have_the_Test_annotation() {
		System.out.println("This test shouldn't run.");
	}

	@Test
	public void test_or35_send_in_15_returns_true() {
		// Arrange
		//Lecture lecture = new Lecture();
		boolean expected = true;

		// Act
		boolean actual = lecture.or35(15);

		// Assert
		Assert.assertEquals(expected, actual);
	}

	//

	@Test public void test_or35_send_in_6_returns_true() {
		// Arrange
		//Lecture lecture = new Lecture();
		boolean expected = true;

		// Act
		boolean actual = lecture.or35(6);

		// Assert
		Assert.assertEquals(expected, actual);
	}

	// Let's checkout some code coverage!

	@Test public void test_or35_send_in_1_returns_false() {
		// Arrange
		//Lecture lecture = new Lecture();
		boolean expected = false;

		// Act
		boolean actual = lecture.or35(1);

		// Assert
		Assert.assertEquals(expected, actual);
	}

	//

	@Test public void test_doubleNumber_send_in_3_return_3() {
		// Arrange
		//Lecture lecture = new Lecture();
		int expected = 3;

		// Act
		int actual = lecture.doubleNumber(3);

		// Assert
		Assert.assertEquals("ERROR: Expected 3 returned " + actual, expected, actual);
	}

	//

	@Test public void test_doubleNumber_send_in_4_return_8() {
		// Arrange
		//Lecture lecture = new Lecture();
		int expected = 8;

		// Act
		int actual = lecture.doubleNumber(4);

		// Assert
		Assert.assertEquals("TEST FAILED: Expected 3 returned " + actual, expected, actual);
	}

	//

	@Test public void test_doubleNumber_send_in_0_return_0() {
		// Arrange
		//Lecture lecture = new Lecture();

		Assert.assertEquals(0, lecture.doubleNumber(0));
	}

	// * * * PARTNER/GROUP ACTIVITY: Create tests for the firstTwo() method * * *

	@Test public void test_thirdDouble_send_6_return_2() {
		// Arrange - Taken care of with @Before method

		// Act
		double expected = 2;
		double actual = lecture.thirdDouble(6);

		// Assert
		Assert.assertEquals(expected, actual, 0.000001);
	}

	@Test public void test_doubleAllNumbers_send_in_2_3_4_return_4_6_8() {
		// Arrange
		int[] expected = {4, 6, 8};
		int[] test = {2, 3, 4};

		// Act
		//int[] actual = lecture.doubleAllNumbers(new int[] {2, 3, 4});
		int[] actual = lecture.doubleAllNumbers(test);

		// Assert
		Assert.assertArrayEquals(expected, actual);
	}

	@Test public void test_robPeterToPayPaul_send_in_map_Peter_has_2000_and_Paul_has_50_returns_Peter_1000_Paul_1050(){
		// Arrange
		Map<String, Integer> expected = new HashMap<>();
		expected.put("Peter", 1000);
		expected.put("Paul", 1050);

		Map<String, Integer> test = new HashMap<>();
		test.put("Peter", 2000);
		test.put("Paul", 50);

		// Act
		Map<String, Integer> actual = lecture.robPeterToPayPaul(test);
		Integer actualPeter = actual.get("Peter");
		Integer actualPaul = actual.get("Paul");
		Integer expectedPeter = expected.get("Peter");
		Integer expectedPaul = expected.get("Paul");

		// Assert
		Assert.assertEquals(expectedPeter, actualPeter);
		Assert.assertEquals(expectedPaul, actualPaul);
	}

	//
}
