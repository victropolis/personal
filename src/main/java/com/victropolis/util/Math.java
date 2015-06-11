package com.victropolis.util;

/**
 * Created by victropolis on 6/4/15.
 */
public class Math {
    public static long factorial(int n) {
        if (n == 1) {
            return n;
        }
        return n * factorial(n - 1);
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

    public static int divideWithoutDividing1(int dividend, int divisor) {
        if (divisor == 0) {
            throw new IllegalArgumentException("divisor == 0");
        }

        int sign = 1;

        if (dividend < 0) {
            dividend = dividend * -1;
            sign = sign * -1;
        }

        if (divisor < 0) {
            divisor = divisor * -1;
            sign = sign * -1;
        }

        int quotient = 0;

        while (dividend >= divisor) {
            dividend -= divisor;
            quotient++;
        }

        return quotient * sign;
    }

    public static double divideWithoutDividing2(double dividend, double divisor) {
        return dividend * (1 / divisor);
    }

    public static double divideWithoutDividing3(double dividend, double divisor) {
        return java.lang.Math.pow(10, java.lang.Math.log10(dividend) - java.lang.Math.log10(divisor));
    }

    public static int multiplyWithoutMultiplyiing1(int left, int right) {
        int answer = 0;

        if (left == 0 || right == 0) {
            return answer;
        }

        int sign = 1;

        if (left < 0) {
            left *= -1;
            sign *= -1;
        }

        if (right < 0) {
            right *= -1;
            sign *= -1;
        }

        for (int x = 0; x < right; x++) {
            answer += left;
        }

        return answer * sign;
    }

    public static double multiplyWithoutMultiplying2(double left, double right) {
        return left / (1 / right);
    }

    public static double multiplyWithoutMultiplying3(double left, double right) {
        return java.lang.Math.pow(10, java.lang.Math.log10(left) + java.lang.Math.log10(right));
    }

    public static void printPrimeNumbers(int max) {
        for (int x = 1; x < max; x++) {
            boolean stillPrime = true;

            for (int y = 2; stillPrime && y < x; stillPrime = (x % y != 0), y++);

            if (stillPrime)
            {
                System.out.println(x++);
            }
        }
    }
}
