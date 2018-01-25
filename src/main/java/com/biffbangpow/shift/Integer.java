package com.biffbangpow.shift;

/**
 * Name	    Width	Range
 * long	    64	    –9,223,372,036,854,775,808 to 9 ,223,372,036,854,775,807
 * int	    32	    –2,147,483,648 to 2,147,483,647
 * short	16	    – 32,768 to 32,767
 * char     16
 * byte	    8	    – 128 to 127
 */
public class Integer {

    /**
     * Shift technology coding exercice
     * @param input the input string
     * @return the string as an int
     */
    public static int parse(String input) {

        int sum = 0;
        char[] arr = input.toCharArray();
        char offset = '0';
        for (int i = 0; i < arr.length; i++) {
            int radix = arr[i] - offset;
            sum = sum + radix * pow(10, arr.length - 1 - i);
        }
        return sum;
    }

    public static int pow(int base, int exposant) {
        int res = 1;
        for (int i = 0; i < exposant; i++) {
            res = base * res;
        }
        return res;
    }
}
