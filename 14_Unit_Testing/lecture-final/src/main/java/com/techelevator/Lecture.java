package com.techelevator;

import java.util.Map;

public class Lecture {

    /*
    Return true if the given non-negative number is a multiple of 3 or a multiple of 5.
    */
    public boolean or35(int n) {
        return (n % 3 == 0) || (n % 5 == 0);
    }

    /*
     If the number is odd, return it. If the number is even, double and return it.
     Return odd numbers. Double and return even numbers.
     */
    public int doubleNumber(int number){
            return number % 2 == 1 ? number : number * 2;
    }

    // * * * PARTNER/GROUP ACTIVITY: Create tests for the firstTwo() method * * *
    /*
     Given a string, return the string made of its first two chars, so the String "Hello" yields "He". If the
     string is shorter than length 2, return whatever there is, so "X" yields "X", and the empty string ""
     yields the empty string "". Note that str.length() returns the length of a string.
     */
    public String firstTwo(String str) {
        if (str.length() < 2) { return str; }
        return str.substring(0, 2);
    }

    /*
    Given a number return the number divided by 3
    */
    public double thirdDouble(double num) {
        return num / 3;
    }

    /*
    Given an array of integers, double each number in the array and return it
     */
    public int[] doubleAllNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * 2;
        }
        return nums;
    }

    /*
     * Modify and return the given Map as follows: if "Peter" has more than 0 money, transfer half of it to "Paul",
     * but only if Paul has less than $10s.
     * Note, monetary amounts are specified in cents: penny=1, nickel=5, ... $1=100, ... $10=1000, ...
     */
    public Map<String, Integer> robPeterToPayPaul(Map<String, Integer> peterPaul) {
        int petersMoney = peterPaul.get("Peter");
        int paulsMoney = peterPaul.get("Paul");

        if (petersMoney > 0 && paulsMoney < 1000) {
            int moneyToPayPaul = petersMoney / 2;
            peterPaul.put("Paul", moneyToPayPaul + paulsMoney);
            peterPaul.put("Peter", petersMoney - moneyToPayPaul);
        }

        return peterPaul;
    }

}
