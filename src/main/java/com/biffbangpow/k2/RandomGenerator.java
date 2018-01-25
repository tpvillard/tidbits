package com.biffbangpow.k2;

/**
 * A random long generator
 */
public class RandomGenerator {

    /**
     * Generates a random integer.
     * @return the random integer
     * @throws InterruptedException when the method is interrupted.
     */
    public static long generateRandom() throws InterruptedException {
        long randomInteger = 0;
        int i = 0;
        while (randomInteger == 0 || i++ < 5) {
            randomInteger = (System.currentTimeMillis() & 0xFF) * 31;
            Thread.sleep(30);
        }
        return randomInteger;
    }
}
