package com.victropolis.datastructures;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.ArrayList;
import java.util.Random;

/**
 * BinarySearchTree Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>May 20, 2015</pre>
 */
public class BinarySearchTreeTest
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
     * Method: getMax()
     */
    @Test
    public void testGetMax() throws Exception
    {
        Random random = new Random();

        Integer[] integers = new Integer[1000000];

        int x;
        for (x = 0; x < 1000000 - 9;)
        {
            integers[x++] = Float.valueOf(random.nextFloat() * Integer.MAX_VALUE).intValue();
        }

        integers[x++] = Integer.MAX_VALUE;
        integers[x++] = Integer.MIN_VALUE;

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>(integers);
        Assert.assertEquals(Integer.valueOf(Integer.MAX_VALUE), binarySearchTree.getMax());
    }

    /**
     * Method: getMin()
     */
    @Test
    public void testGetMin() throws Exception
    {
        Random random = new Random();

        Integer[] integers = new Integer[1000000];

        int x;
        for (x = 0; x < 1000000 - 9;)
        {
            integers[x++] = Float.valueOf(random.nextFloat() * Integer.MAX_VALUE).intValue();
        }

        integers[x++] = Integer.MAX_VALUE;
        integers[x++] = Integer.MIN_VALUE;

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>(integers);
        Assert.assertEquals(Integer.valueOf(Integer.MIN_VALUE), binarySearchTree.getMin());
    }

    /**
     * Method: find(T soughtItem)
     */
    @Test
    public void testFind() throws Exception
    {
//TODO: Test goes here... 
    }

    /**
     * Method: add(T soughtItem)
     */
    @Test
    public void testAdd() throws Exception
    {
        Random random = new Random();

        ArrayList<Integer> integers = new ArrayList<Integer>();

        for (int x = 0; x < 1000000; x++)
        {
            integers.add(Float.valueOf(random.nextFloat() * Integer.MAX_VALUE).intValue());
        }

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();

        for (Integer integer : integers)
        {
            binarySearchTree.add(integer);
        }

        for (Integer integer : integers)
        {
            Assert.assertNotNull(binarySearchTree.find(integer));
        }
    }

    /**
     * Method: remove(T soughtItem)
     */
    @Test
    public void testRemove() throws Exception
    {
//TODO: Test goes here... 
    }

}
