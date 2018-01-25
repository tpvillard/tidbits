package com.biffbangpow.k2;

public class Test {

    public static void main(String[] args) {
        long randomInteger = 0; // variable should be final when used in lambda
            int i = 0;
            while (randomInteger == 0 || i++ < 5) {
                randomInteger = (System.currentTimeMillis() & 0xFF) * 31;
                try {
                    Thread.sleep(30);
                } catch (InterruptedException e) {
                    System.exit(-1);
                }
            }
            final String name = "anotherRandom " + randomInteger;
            final Runnable runnable = () -> System.out.println("randomInteger = " + name);
            new Thread(runnable).start();
    }
}
