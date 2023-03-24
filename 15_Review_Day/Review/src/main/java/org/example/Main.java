package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        StaticTest static1 = new StaticTest();
        StaticTest static2 = new StaticTest();

        // all objects built from the same class will share the value of a static variable
        static1.setCounter(62);
        System.out.println(static2.getCounter());

        // don't have to initialize an object to use static methods
        StaticTest.incrementCounter();
        System.out.println(static1.getCounter());

        
        /** Useful utility classes **/

        /** Math **/
//        // .abs() absolute value of a number. The number's distance from zero
//        System.out.println("absolute value: "+ Math.abs(-15));
//
//        // .min()/.max() compares two numbers and returns the smaller/larger number
//        int x = 10;
//        int y = 3;
//        System.out.println("min: " + Math.min(x,y));
//        System.out.println("max: " + Math.max(x,y));
//
//        // .sqrt() returns the square root of a number
//        System.out.println("square root: " + Math.sqrt(49));
//
//        // random() generates a random double between 0.0 and 1.0
//        System.out.println("ten random numbers:");
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Math.random());
//        }
//
//        // .pow() returns the power of x,y
//        System.out.println("Power of x and y is: " + Math.pow(x, y));

        /** Collections **/
//        List<Integer> testList = new ArrayList<>();
//        for (int i = 0; i < 100; i++) {
//            testList.add((int)(Math.random()*10));
//        }
//        for(Integer number : testList){
//            System.out.println(number);
//        }
//
//        Collections.sort(testList);
//        System.out.println(" --------- after sort --------- ");
//        for(Integer number : testList){
//            System.out.println(number);
//        }
//
//        Collections.reverse(testList);
//        System.out.println(" --------- after reverse --------- ");
//        for(Integer number : testList){
//            System.out.println(number);
//        }
//
//        Collections.shuffle(testList);
//        System.out.println(" --------- after shuffle --------- ");
//        for(Integer number : testList){
//            System.out.println(number);
//        }
//
//        System.out.println(" --------- min/max --------- ");
//        System.out.println("min: " + Collections.min(testList));
//        System.out.println("max: " + Collections.max(testList));
//
//        System.out.println(" --------- frequency --------- ");
//        System.out.println("frequency of 3: " + Collections.frequency(testList, 3));
//
//
//        System.out.println(" --------- fill --------- ");
//        Collections.fill(testList,1);
//        for(Integer number : testList){
//            System.out.println(number);
//        }


        /** LocalDate/LocalDateTime **/

//        LocalDateTime now = LocalDateTime.now();
//        System.out.println(now);
//        LocalDateTime setTime = LocalDateTime.of(2023, Month.MARCH, 24, 9, 33);
//        System.out.println(setTime);
//
//        setTime = setTime.plusWeeks(34);
//        System.out.println(setTime);  // Oh hey it'll be my birthday


        /** StringBuilder **/
//        long start = System.currentTimeMillis();
//        String concat = "";
//        for (int i = 0; i < 200000; i++) {
//            concat += i;
//
//        }
//        long finish = System.currentTimeMillis();
//        long timeElapsed = finish - start;
//        System.out.println("concatenation: " + timeElapsed);
//
//
//        start = System.currentTimeMillis();
//        StringBuilder builder = new StringBuilder("");
//        for (int i = 0; i < 200000; i++) {
//            builder.append(i);
//
//        }
//        finish = System.currentTimeMillis();
//        timeElapsed = finish - start;
//        System.out.println("string builder: " + timeElapsed);

        /** BigDecimal **/
//        BigDecimal testDecimal = new BigDecimal("3.145234");
//        System.out.println(testDecimal.(new BigDecimal("5.5154546554456656444645646")));
//
//        // using BigDecimal for money?  set scale to 2 and use the RoundingMode HALF_EVEN
//        System.out.println(testDecimal.setScale(2, RoundingMode.HALF_EVEN));

    }
}