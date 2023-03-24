package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CigarPartyTest {
    @Test
    public void CigarParty () {
        //Arrange
        CigarParty partyName = new CigarParty();


        Assert.assertEquals(true, partyName.haveParty(40,false));
        Assert.assertEquals(true, partyName.haveParty(60,false));
        Assert.assertEquals(false, partyName.haveParty(61,false));
        Assert.assertEquals(false, partyName.haveParty(39,false));
        Assert.assertEquals(true, partyName.haveParty(40,true));
        Assert.assertEquals(true, partyName.haveParty(61,true));
        Assert.assertEquals(false, partyName.haveParty(-1,true));
        Assert.assertEquals(false, partyName.haveParty(-1,false));
        Assert.assertEquals(false, partyName.haveParty(0,false));




    }

}
