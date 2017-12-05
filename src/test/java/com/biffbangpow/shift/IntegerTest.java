package com.biffbangpow.shift;


import org.testng.Assert;
import org.testng.annotations.Test;

public class IntegerTest {

    @Test
    public void test_parse() {
        Assert.assertEquals(Integer.parse("12345"), 12345);
    }
}
