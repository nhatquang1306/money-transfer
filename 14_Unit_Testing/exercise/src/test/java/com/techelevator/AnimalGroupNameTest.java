package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class AnimalGroupNameTest {
    @Test
    public void AnimalGroupName() {
        //Arrange
        AnimalGroupName groupName = new AnimalGroupName(); // Always must create a new instance of the class you want to test
        //Act Assert
        Assert.assertEquals("Crash", groupName.getHerd("Rhino")); // testing for animal in the list
        Assert.assertEquals("unknown", groupName.getHerd("null"));// testing for null input
        Assert.assertEquals("unknown", groupName.getHerd("")); // Testing for blank input
        Assert.assertEquals("unknown", groupName.getHerd("Narwhal")); // Testing for animal not in list
    }

}
