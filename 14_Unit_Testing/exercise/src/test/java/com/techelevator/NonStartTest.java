package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class NonStartTest {
    @Test
    public void NonStart() {
        NonStart nonStart = new NonStart();

        Assert.assertEquals("ellohere", nonStart.getPartialString("Hello", "There"));
        Assert.assertEquals("", nonStart.getPartialString("H", "T"));
        Assert.assertEquals( "iou", nonStart.getPartialString("Hi", "You" ));


    }

}
