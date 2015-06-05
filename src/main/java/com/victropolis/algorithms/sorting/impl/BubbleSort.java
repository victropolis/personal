package com.victropolis.algorithms.sorting.impl;

import com.victropolis.util.ArrayUtils;
import com.victropolis.util.ComparableUtils;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class BubbleSort<C extends Comparable<? super C>> extends AbstractSort<C>
{
    @Override
    protected void concreteSort(C[] comparables, Comparator<C> comparator)
    {
        bubbleSort(comparables, comparator);
    }

    private void bubbleSort(C[] array, Comparator<C> comparator)
    {
        int swaps = 0;

        for (int x = array.length; x >= 0; x--, swaps=0)
        {
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