package com.biffbangpow.k2;


import org.testng.Assert;
import org.testng.annotations.Test;

public class RandomGeneratorTest {

    @Test
    public void generate_random() throws InterruptedException {
        long res = RandomGenerator.generateRandom();
        System.out.println("Res: " + res);
        Assert.assertTrue(res != 0);
    }
}
