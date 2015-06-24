package com.victropolis.algorithms.sorting.impl;

import com.victropolis.util.ComparableUtils;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class SelectionSort<C extends Comparable<? super C>> extends AbstractSort<C>
{
    @Override
    protected void concreteSort(C[] comparables, Comparator<C> comparator)
    {
        selectionSort(comparables, comparator);
    }

    private void selectionSort(C[] comparables, Comparator<C> comparator)
    {
        for (int index = 0; index < comparables.length-1; index++)
        {
            int nextSmallerIndex = index;

            for (int y = index + 1; y < comparables.length; y++)
            {
                if (ComparableUtils.lt(comparables[y], comparables[nextSmallerIndex], comparator))
                {
                    nextSmallerIndex = y;
                }
            }

            C nextSmaller = comparables[nextSmallerIndex];
            comparables[nextSmallerIndex] = comparables[index];
            comparables[index] = nextSmaller;
        }
    }
}
