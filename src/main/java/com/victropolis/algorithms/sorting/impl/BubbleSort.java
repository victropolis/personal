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

    private void bubbleSort(C[] comparables, Comparator<C> comparator)
    {
        int swaps = 0;

        for (int x = comparables.length; x >= 0; x--, swaps=0)
        {
            for (int y = 0; y < comparables.length - 1; y++)
            {
                if (ComparableUtils.gt(comparables[y], comparables[y + 1], comparator))
                {
                    ArrayUtils.swap(comparables, y, y + 1);
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
