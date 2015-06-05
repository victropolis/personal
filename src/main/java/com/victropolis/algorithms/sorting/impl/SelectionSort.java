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

    private void selectionSort(C[] array, Comparator<C> comparator)
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

            C nextSmaller = array[nextSmallerIndex];
            array[nextSmallerIndex] = array[index];
            array[index] = nextSmaller;
        }
    }
}
