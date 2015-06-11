package com.victropolis.util;

import org.junit.Assert;
import org.junit.Test;

import java.lang.*;
import java.util.Random;

/**
 * Created by victropolis on 6/4/15.
 */
public class MathTest {
    @Test
    public void testFactorial() throws Exception {
        Assert.assertEquals(5*4*3*2*1, Math.factorial(5));
        Assert.assertEquals(6*5*4*3*2*1, Math.factorial(6));
    }
    @Test
    public void testPower() throws Exception {
        Assert.assertEquals(5*5*5*5*5, Math.power(5, 5));
        Assert.assertEquals(6*6*6*6*6, Math.power(6, 5));
    }

    @Test
    public void testDivide() throws Exception {
        int dividend;
        int divisor;

        Random random = new Random();

        for (int x = 0; x < 100000; x++) {
            while ((dividend = random.nextInt()) == 0);
            while ((divisor = random.nextInt(java.lang.Math.abs(dividend))) == 0);
            Assert.assertEquals(dividend / divisor, Math.divideWithoutDividing1(dividend, divisor));
        }
    }

    @Test
    public void testDivide2() throws Exception {
        double dividend;
        double divisor;

        Random random = new Random();

        for (int x = 0; x < 100000; x++) {
            while ((dividend = random.nextDouble() * 1000) == 0);
            while ((divisor = random.nextDouble() * java.lang.Math.abs(dividend)) == 0);
            Assert.assertEquals(dividend / divisor, Math.divideWithoutDividing2(dividend, divisor), 0.02f);
        }
    }

    @Test
    public void testDivide3() throws Exception {
        double dividend;
        double divisor;

        Random random = new Random();

        for (int x = 0; x < 100000; x++) {
            while ((dividend = random.nextDouble() * 1000) == 0);
            while ((divisor = random.nextDouble() * java.lang.Math.abs(dividend)) == 0);
            Assert.assertEquals(dividend / divisor, Math.divideWithoutDividing3(dividend, divisor), 0.02f);
        }
    }

    @Test
    public void testMultiply() throws Exception {
        int left;
        int right;

        Random random = new Random();

        for (int x = 0; x < 100000; x++) {
            left = random.nextInt(1000);
            right = random.nextInt(1000);
            Assert.assertEquals(left * right, Math.multiplyWithoutMultiplyiing1(left, right), 0.1f);
        }
    }

    @Test
    public void testMultiply2() throws Exception {
        int left;
        int right;

        Random random = new Random();

        for (int x = 0; x < 100000; x++) {
            left = random.nextInt(1000);
            right = random.nextInt(1000);
            Assert.assertEquals(left * right, Math.multiplyWithoutMultiplying2(left, right), 0.1f);
        }
    }

    @Test
    public void testMultiply3() throws Exception {
        int left;
        int right;

        Random random = new Random();

        for (int x = 0; x < 100000; x++) {
            left = random.nextInt(1000);
            right = random.nextInt(1000);
            Assert.assertEquals(left * right, Math.multiplyWithoutMultiplying3(left, right), 0.1f);
        }
    }

    @Test
    public void testPrintPrime() throws Exception {
        Math.printPrimeNumbers(100000);
    }
}
