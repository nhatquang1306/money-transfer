package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class FrontTimesTest {
    @Test
    public void FrontTimes() {
        FrontTimes frontTimes = new FrontTimes();

        Assert.assertEquals("ChoCho", frontTimes.generateString("Chocolate", 2)); //Expected output to be is first 3 letters.
        Assert.assertEquals("Cho", frontTimes.generateString("Chocolate", 1));
        Assert.assertEquals("ChChChCh", frontTimes.generateString("Ch", 4));
        Assert.assertEquals("", frontTimes.generateString("", 3));
        Assert.assertEquals("", frontTimes.generateString("Chocolate", 0));
        Assert.assertEquals("", frontTimes.generateString("Chocolate", -1));

    }
}
