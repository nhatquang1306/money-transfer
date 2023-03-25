package org.example;

public class StaticTest  {

    static int counter;

    static void incrementCounter(){
        counter++;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        StaticTest.counter = counter;
    }
}
