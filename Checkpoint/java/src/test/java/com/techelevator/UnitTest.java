package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
public class UnitTest {
    @Test
    public void getAge_of_1995_returns_28() {
        //Arrange
        Car car = new Car(1995, "make", false);
        //Act
        int actualResult = car.getAge();
        int expectedResult = 28;

        //Assert
        Assert.assertEquals(expectedResult, actualResult);
}
@Test
    public void eCheck_isClassic_returns_false() {
        //if it is a classic car, it is exempt, returns false
    Car car = new Car(2021, "make", true);

    Assert.assertFalse(car.needsECheck(2019));
}
    @Test
    public void eCheck_age_under4_returns_false() {
        Car car = new Car(2021, "make", true);

        Assert.assertFalse(car.needsECheck(2019));
    }
    @Test
    public void eCheck_age_over25_returns_false() {
        Car car = new Car(1995, "make", true);

        Assert.assertFalse(car.needsECheck(2019));
    }
    @Test
    public void eCheck_even_year_and_yearToCheck_even_returns_true() {
        //if it is a classic car, it is exempt, returns false
        Car car = new Car(2018, "make", false);

        Assert.assertTrue(car.needsECheck(2022));
    }
    @Test
    public void eCheck_odd_year_and_yearToCheck_odd_returns_true() {
        //if it is a classic car, it is exempt, returns false
        Car car = new Car(2019, "make", false);

        Assert.assertTrue(car.needsECheck(2023));
    }
    @Test
    public void eCheck_even_year_and_yearToCheck_odd_returns_false() {
        //if it is a classic car, it is exempt, returns false
        Car car = new Car(2018, "make", false);

        Assert.assertFalse(car.needsECheck(2023));
}}