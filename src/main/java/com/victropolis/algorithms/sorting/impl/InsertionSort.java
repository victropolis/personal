package com.victropolis.algorithms.sorting.impl;

import com.victropolis.util.ArrayUtils;
import com.victropolis.util.ComparableUtils;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class InsertionSort<C extends Comparable<? super C>> extends AbstractSort<C>
{
    @Override
    protected void concreteSort(C[] comparables, Comparator<C> comparator)
    {
        insertionSort(comparables, comparator);
    }

    private void insertionSort(C[] comparables, Comparator<C> comparator)
    {
        for (int x = 1; x < comparables.length; x++)
        {
            for (int y = x; y > 0; y--)
            {
                if (ComparableUtils.gt(comparables[y-1], comparables[y], comparator))
                {
                    ArrayUtils.swap(comparables, y-1, y);
                }
            }
        }
    }
}
