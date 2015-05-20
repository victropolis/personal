package com.victropolis.util.sorting.impl;

import com.victropolis.util.ArrayUtils;
import com.victropolis.util.ComparableUtils;
import com.victropolis.util.sorting.Sorter;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class InsertionSort extends AbstractSort
{
    @Override
    protected void doSort(Comparable[] comparables, Comparator<Comparable> comparator)
    {
        insertionSort(comparables, comparator);
    }

    private void insertionSort(Comparable[] array, Comparator<Comparable> comparator)
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