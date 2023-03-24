package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class SameFirstLastTest {
    @Test
    public void SameFirstLast() {
        SameFirstLast sameFirstLast = new SameFirstLast();

        Assert.assertEquals(true, sameFirstLast.isItTheSame(new int[]{1,2,3,1}));
        Assert.assertEquals(false, sameFirstLast.isItTheSame(new int[]{}));
        Assert.assertEquals(true, sameFirstLast.isItTheSame(new int[]{1}));
        Assert.assertEquals(true, sameFirstLast.isItTheSame(new int[]{-1,2,3,-1}));
        Assert.assertEquals(false, sameFirstLast.isItTheSame(new int[]{0,2,3,1}));




    }
}
