package com.victropolis.util;

/**
 * Created by victropolis on 6/4/15.
 */
public class Math {
    public static long factorial(int n) {
        if (n == 1) {
            return n;
        }
        return n * factorial(n-1);
    }

    public static long power(int base, int power) {
        if (power == 1) {
            return base;
        }

        return base * power(base, power - 1);
    }

    public static int greatestCommonDivisor(int p, int q) {
        if (q == 0) {
            return p;
        }
        else {
            return greatestCommonDivisor(q, p % q);
        }
    }
}
