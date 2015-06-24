package com.victropolis.algorithms.sorting.impl;

import com.victropolis.util.ArrayUtils;
import com.victropolis.util.ComparableUtils;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class QuickSort<C extends Comparable<? super C>> extends AbstractSort<C>
{
    @Override
    protected void concreteSort(C[] comparables, Comparator<C> comparator)
    {
        quickSort(comparables, comparator, 0, comparables.length - 1);
    }

    private void quickSort(C[] comparables, Comparator<C> comparator, int left, int right)
    {
        int index = pivot(comparables, comparator, left, right);

        if (left < index - 1)
        {
            quickSort(comparables, comparator, left, index - 1);
        }

        if (index < right)
        {
            quickSort(comparables, comparator, index, right);
        }
    }

    private int pivot(C[] comparables, Comparator<C> comparator, int left, int right)
    {
        C pivot = comparables[(left + right) / 2];

        while (left <= right)
        {
            while (ComparableUtils.lt(comparables[left], pivot, comparator))
            {
                left++;
            }

            while (ComparableUtils.gt(comparables[right], pivot, comparator))
            {
                right--;
            }

            if (left <= right)
            {
                ArrayUtils.swap(comparables, left++, right--);
            }
        }

        return left;
    }
}
