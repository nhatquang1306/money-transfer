package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Lucky13Test {
    @Test
    public void Lucky13() {
        //Arrange
        Lucky13 lucky13 = new Lucky13();

        Assert.assertEquals(false, lucky13.getLucky(new int[] {0,1,2,3,4,5}));
        Assert.assertEquals(true, lucky13.getLucky(new int[] {0,2,4}));
        Assert.assertEquals(true, lucky13.getLucky(new int[] {-3, -1, 0}));
        Assert.assertEquals(true, lucky13.getLucky(new int[] {}));
        Assert.assertEquals(false, lucky13.getLucky(new int[] {0,1,2,4,5}));
        Assert.assertEquals(false, lucky13.getLucky(new int[] {0,2,3,4,5}));



    }
}
