package com.victropolis.datastructures;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

import java.util.*;

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
        for (x = 0; x < 1000000 - 2;)
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
        for (x = 0; x < 1000000 - 2;)
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
        Random random = new Random();

        Set<Integer> set = new HashSet<Integer>();
        while (set.size() < 1000000)
        {
            set.add(Float.valueOf(random.nextFloat() * Integer.MAX_VALUE).intValue());
        }

        Integer[] integers = new Integer[set.size()];

        Iterator<Integer> iterator = set.iterator();

        for (int x = 0; x < integers.length && iterator.hasNext(); x++)
        {
            integers[x] = iterator.next();
        }

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>(integers);

        for (int index = integers.length / 2; index < integers.length; index++)
        {
            Assert.assertEquals(integers[index], binarySearchTree.remove(integers[index]));
            Assert.assertNull(binarySearchTree.remove(integers[index]));
        }

        for (int index = (integers.length / 2) - 1; index >= 0; index--)
        {
            Assert.assertEquals(integers[index], binarySearchTree.remove(integers[index]));
            Assert.assertNull(binarySearchTree.remove(integers[index]));
        }
    }

    @Test
    public void testMinAfterRemove()
    {
        Random random = new Random();

        Map<Integer, Integer> set = new TreeMap<Integer, Integer>();
        while (set.size() < 1000)
        {
            int i = Float.valueOf(random.nextFloat() * Integer.MAX_VALUE).intValue();
            set.put(i, i);
        }

        List<Integer> integerList = new ArrayList<Integer>(set.size());

        for (Map.Entry<Integer, Integer> integerIntegerEntry : set.entrySet())
        {
            integerList.add(integerIntegerEntry.getKey());
        }

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();

        while (integerList.size() > 0)
        {
            int index = Float.valueOf(random.nextFloat() * integerList.size()).intValue();
            Integer item = integerList.get(index);
            binarySearchTree.add(item);
            integerList.remove(index);
        }

        for (Map.Entry<Integer, Integer> integerIntegerEntry : set.entrySet())
        {
            integerList.add(integerIntegerEntry.getKey());
        }

        while (set.size() > 0)
        {
            int index = Math.max(Float.valueOf(random.nextFloat() * integerList.size()).intValue() - 1, 0);

            Integer item = integerList.get(index);
            binarySearchTree.remove(item);
            integerList.remove(index);
            set.remove(item);

            Object[] entries = set.entrySet().toArray();

            Integer min = ((Map.Entry<Integer, Integer>)entries[0]).getKey();
            Integer max = ((Map.Entry<Integer, Integer>)entries[entries.length-1]).getKey();

            Assert.assertEquals(min, binarySearchTree.getMin());
            Assert.assertEquals(max, binarySearchTree.getMax());

            set.remove(min);
            set.remove(max);
            binarySearchTree.remove(min);
            binarySearchTree.remove(max);

            if (set.size() > 0)
            {
                entries = set.entrySet().toArray();

                min = ((Map.Entry<Integer, Integer>)entries[0]).getKey();
                max = ((Map.Entry<Integer, Integer>)entries[entries.length-1]).getKey();

                Assert.assertEquals(min, binarySearchTree.getMin());
                Assert.assertEquals(max, binarySearchTree.getMax());
            }
        }
    }
}