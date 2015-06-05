package com.victropolis.util;

import org.junit.Assert;
import org.junit.Test;

import java.lang.*;

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
}
