package com.victropolis.algorithms.sorting.impl;

import com.victropolis.algorithms.sorting.Sorter;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public abstract class AbstractSort<C extends Comparable<? super C>> implements Sorter<C>
{
    protected abstract void concreteSort(C[] comparables, Comparator<C> comparator);

    final public void sort(C[] comparables)
    {
        sort(comparables, new Comparator<C>()
        {
            public int compare(Comparable left, Comparable right)
            {
                return left.compareTo(right);
            }
        });
    }

    final public void sort(C[] comparables, Comparator<C> comparator)
    {
        concreteSort(comparables, comparator);
    }
}
