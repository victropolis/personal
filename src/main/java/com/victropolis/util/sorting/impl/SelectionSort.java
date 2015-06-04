package com.victropolis.util.sorting.impl;

import com.victropolis.util.ComparableUtils;
import com.victropolis.util.sorting.Sorter;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class SelectionSort<T extends Comparable<? super T>> extends AbstractSort<T>
{
    @Override
    protected void doSort(T[] comparables, Comparator<T> comparator)
    {
        selectionSort(comparables, comparator);
    }

    private void selectionSort(T[] array, Comparator<T> comparator)
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

            T nextSmaller = array[nextSmallerIndex];
            array[nextSmallerIndex] = array[index];
            array[index] = nextSmaller;
        }
    }
}
