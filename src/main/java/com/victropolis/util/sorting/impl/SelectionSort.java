package com.victropolis.util.sorting.impl;

import com.victropolis.util.ComparableUtils;
import com.victropolis.util.sorting.Sorter;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class SelectionSort extends AbstractSort
{
    @Override
    protected void doSort(Comparable[] comparables, Comparator<Comparable> comparator)
    {
        selectionSort(comparables, comparator);
    }

    private void selectionSort(Comparable[] array, Comparator<Comparable> comparator)
    {
        for (int index = 0; index < array.length-1; index++)
        {
            int nextSmallerIndex = index;

            for (int y = index + 1; y < array.length; y++)
            {
                if (ComparableUtils.lt(array[y], array[nextSmallerIndex], comparator))
                {
                    nextSmallerIndex = y;
                }
            }

            Comparable nextSmaller = array[nextSmallerIndex];
            array[nextSmallerIndex] = array[index];
            array[index] = nextSmaller;
        }
    }
}
