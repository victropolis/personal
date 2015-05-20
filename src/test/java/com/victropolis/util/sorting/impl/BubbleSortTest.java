package com.victropolis.util.sorting.impl;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;
import java.util.Random;

/**
 * BubbleSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>May 19, 2015</pre>
 */
public class BubbleSortTest
{

    @Before
    public void before() throws Exception
    {
    }

    @After
    public void after() throws Exception
    {
    }

    /**
     * Method: sort(Comparable[] comparables)
     */
    @Test
    public void testSortComparables() throws Exception
    {
        Integer[] array = new Integer[10000];
        Random random = new Random();
        for (int x = 0; x < array.length; x++)
        {
            array[x] = (int) (random.nextFloat() * Integer.MAX_VALUE);
        }

        new BubbleSort().sort(array);

        for (int x = 1; x < array.length; x++)
        {
            Assert.assertTrue(array[x].compareTo(array[x - 1]) >= 0);
        }
    }

    /**
     * Method: sort(Comparable[] comparables, boolean ascending)
     */
    @Test
    public void testSortForComparablesAscending() throws Exception
    {
        Integer[] array = new Integer[10000];
        Random random = new Random();
        for (int x = 0; x < array.length; x++)
        {
            array[x] = (int) (random.nextFloat() * Integer.MAX_VALUE);
        }

        new BubbleSort().sort(array);

        for (int x = 1; x < array.length; x++)
        {
            Assert.assertTrue(array[x].compareTo(array[x - 1]) >= 0);
        }
    }

    /**
     * Method: sort(Comparable[] comparables, boolean ascending)
     */
    @Test
    public void testSortForComparablesDescending() throws Exception
    {
        Integer[] array = new Integer[10000];
        Random random = new Random();
        for (int x = 0; x < array.length; x++)
        {
            array[x] = (int) (random.nextFloat() * Integer.MAX_VALUE);
        }

        new BubbleSort().sort(array, new Comparator<Comparable>()
        {
            public int compare(Comparable left, Comparable right)
            {
                return right.compareTo(left);
            }
        });

        for (int x = 1; x < array.length; x++)
        {
            Assert.assertTrue(array[x].compareTo(array[x - 1]) <= 0);
        }
    }
}
