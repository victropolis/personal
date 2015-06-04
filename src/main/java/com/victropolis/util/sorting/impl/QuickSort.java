package com.victropolis.util.sorting.impl;

import com.victropolis.util.ArrayUtils;
import com.victropolis.util.ComparableUtils;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class QuickSort<T extends Comparable<? super T>> extends AbstractSort<T>
{
    @Override
    protected void doSort(T[] comparables, Comparator<T> comparator)
    {
        quickSort(comparables, comparator, 0, comparables.length - 1);
    }

    private void quickSort(T[] comparables, Comparator<T> comparator, int left, int right)
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

    private int pivot(T[] comparables, Comparator<T> comparator, int left, int right)
    {
        int i = left, j = right;

        Comparable pivot = comparables[(left + right) / 2];

        while (i <= j)
        {
            while (ComparableUtils.lt(comparables[i], pivot, comparator))
            {
                i++;
            }

            while (ComparableUtils.gt(comparables[j], pivot, comparator))
            {
                j--;
            }

            if (i <= j)
            {
                ArrayUtils.swap(comparables, i++, j--);
            }
        }

        return i;
    }
}
