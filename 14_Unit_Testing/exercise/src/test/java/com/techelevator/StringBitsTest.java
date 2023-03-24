package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class StringBitsTest {
    @Test
    public void StringBits() {
        StringBits stringBits = new StringBits();

        Assert.assertEquals("", stringBits.getBits(""));
        Assert.assertEquals("Hlo", stringBits.getBits("Hello"));
        Assert.assertEquals("H", stringBits.getBits("H"));


    }
}
