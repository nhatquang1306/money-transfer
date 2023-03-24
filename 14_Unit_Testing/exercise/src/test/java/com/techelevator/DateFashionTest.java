package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

public class DateFashionTest {
    @Test
    public void DateFashion() {
        //Arrange
        DateFashion dateFashion = new DateFashion();

        Assert.assertEquals(2, dateFashion.getATable(8, 3));
        Assert.assertEquals(2, dateFashion.getATable(3, 8));
        Assert.assertEquals(1, dateFashion.getATable(3, 7));
        Assert.assertEquals(1, dateFashion.getATable(7, 3));
        Assert.assertEquals(0, dateFashion.getATable(2, 7));
        Assert.assertEquals(0, dateFashion.getATable(9,2 ));
        Assert.assertEquals(0, dateFashion.getATable(-1, 8));
        Assert.assertEquals(2, dateFashion.getATable(20, 3));
    }
}
