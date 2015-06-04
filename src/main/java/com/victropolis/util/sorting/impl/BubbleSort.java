package com.victropolis.util.sorting.impl;

import com.victropolis.util.ArrayUtils;
import com.victropolis.util.ComparableUtils;
import com.victropolis.util.sorting.Sorter;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class BubbleSort<T extends Comparable<? super T>> extends AbstractSort<T>
{
    @Override
    protected void doSort(T[] comparables, Comparator<T> comparator)
    {
        bubbleSort(comparables, comparator);
    }

    private void bubbleSort(T[] array, Comparator<T> comparator)
    {
        int swaps;

        for (int x = array.length; x >= 0; x--)
        {
            swaps = 0;

            for (int y = 0; y < array.length - 1; y++)
            {
                if (ComparableUtils.gt(array[y], array[y + 1], comparator))
                {
                    ArrayUtils.swap(array, y, y + 1);
                    swaps++;
                }
            }

            if (swaps == 0)
            {
                break;
            }
        }
    }
}
