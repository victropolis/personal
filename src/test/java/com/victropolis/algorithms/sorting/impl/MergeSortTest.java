package com.victropolis.algorithms.sorting.impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.Comparator;
import java.util.Random;

/**
 * MergeSort Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>May 19, 2015</pre>
 */
public class MergeSortTest
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
        Integer[] array = new Integer[500000];
        Random random = new Random();
        for (int x = 0; x < array.length; x++)
        {
            array[x] = (int) (random.nextFloat() * Integer.MAX_VALUE);
        }

        new MergeSort().sort(array);

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
        Integer[] array = new Integer[500000];
        Random random = new Random();
        for (int x = 0; x < array.length; x++)
        {
            array[x] = (int) (random.nextFloat() * Integer.MAX_VALUE);
        }

        new MergeSort().sort(array);

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
        Integer[] array = new Integer[500000];
        Random random = new Random();
        for (int x = 0; x < array.length; x++)
        {
            array[x] = (int) (random.nextFloat() * Integer.MAX_VALUE);
        }

        new MergeSort().sort(array, new Comparator<Comparable>()
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
