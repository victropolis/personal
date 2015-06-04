package com.victropolis.util.sorting.impl;

import com.victropolis.util.ArrayUtils;
import com.victropolis.util.ComparableUtils;
import com.victropolis.util.sorting.Sorter;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class InsertionSort<T extends Comparable<? super T>> extends AbstractSort<T>
{
    @Override
    protected void doSort(T[] comparables, Comparator<T> comparator)
    {
        insertionSort(comparables, comparator);
    }

    private void insertionSort(T[] array, Comparator<T> comparator)
    {
        for (int x = 1; x < array.length; x++)
        {
            for (int y = x; y > 0; y--)
            {
                if (ComparableUtils.gt(array[y-1], array[y], comparator))
                {
                    ArrayUtils.swap(array, y-1, y);
                }
            }
        }
    }
}
