package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
public class UnitTest {
    @Test
    public void testECheck() {
        Car car = new Car(true, 2010, "Ford");
        Car car1 = new Car(false, 1969, "Toyota");
        Car car2 = new Car(false, 2020, "Honda");
        Car car3 = new Car(false, 2018, "Ford");
        Car car4 = new Car(false, 2017, "Toyota");
        Assert.assertEquals(false, car.needsECheck(5));
        Assert.assertEquals(false, car1.needsECheck(5));
        Assert.assertEquals(false, car2.needsECheck(5));
        Assert.assertEquals(true, car3.needsECheck(6));
        Assert.assertEquals(false, car3.needsECheck(5));
        Assert.assertEquals(true, car4.needsECheck(5));
        Assert.assertEquals(false, car4.needsECheck(6));
    }
    @Test
    public void testAgeCalculation() {
        Car car = new Car(false, 2000, "Ford");
        Car car1 = new Car(true, 1970, "Toyota");
        Assert.assertEquals(23, car.getAge());
        Assert.assertEquals(53, car1.getAge());
    }
}
