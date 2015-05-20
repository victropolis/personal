package com.victropolis.util;

/**
 * Created by victropolis on 5/19/15.
 */
public class ArrayUtils
{
    public static void swap(Object[] array, int a, int b)
    {
        Object temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void reverse(Object[] array)
    {
        int left = 0, right = array.length - 1;
        while (left <= right)
        {
            swap(array, left++, right--);
        }
    }
}
