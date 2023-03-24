package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class Less20Test {
    @Test
    public void Less20() {
        Less20 less20 = new Less20();

        Assert.assertEquals(true, less20.isLessThanMultipleOf20(18));
        Assert.assertEquals(true, less20.isLessThanMultipleOf20(19));
        Assert.assertEquals(false, less20.isLessThanMultipleOf20(40));
        Assert.assertEquals(false, less20.isLessThanMultipleOf20(-1));
        Assert.assertEquals(false, less20.isLessThanMultipleOf20(0));


    }

}
