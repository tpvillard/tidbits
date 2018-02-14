package com.biffbangpow.shift;


import org.testng.Assert;
import org.testng.annotations.Test;

public class MaxGainTest {

    @Test
    public void test_maxgain() {

        int[] prices = {2, 3, 4, 5, 4, 3, 2, 1, 2, 3, 4, 5, 6, 7, 6, 5};
        Assert.assertEquals(MaxGain.maxGain(prices), new MaxGain.Result(7, 13, 6));
    }

    @Test
    public void test_isnull() {

        Assert.assertNull(null);
    }

    @Test
    public void test_is_not_null() {

        Assert.assertNull(new Object());
    }
}
