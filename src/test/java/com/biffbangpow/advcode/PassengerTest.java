package com.biffbangpow.advcode;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PassengerTest {

    Passenger pax = new Passenger();


    @Test
    public void should_add_advantage_code() {

        Assert.assertFalse(pax.contains(AdvantageCodeEnum.GH03C));
    }
}
