package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class MaxEnd3Test {
    @Test
    public void MaxEnd3() {
        MaxEnd3 maxEnd3 = new MaxEnd3();

        Assert.assertArrayEquals(new int[] {4, 4, 4}, maxEnd3.makeArray(new int[] {1, 3, 4}));
        Assert.assertArrayEquals(new int[] {5,5,5}, maxEnd3.makeArray(new int[] {5,3,2}));
        Assert.assertArrayEquals(new int[] {5,5,5}, maxEnd3.makeArray(new int[] {5,7,2}));
        Assert.assertArrayEquals(new int[] {0,0,0}, maxEnd3.makeArray(new int[] {-1, 0, 0}));
        Assert.assertArrayEquals(new int[] {5,5,5}, maxEnd3.makeArray(new int[] {5,3,2}));


    }
}
