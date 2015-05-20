package com.victropolis.util.sorting.impl;

import com.victropolis.util.sorting.Sorter;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public abstract class AbstractSort implements Sorter
{
    protected abstract void doSort(Comparable[] comparables, Comparator<Comparable> comparator);

    final public void sort(Comparable[] comparables)
    {
        sort(comparables, new Comparator<Comparable>()
        {
            public int compare(Comparable left, Comparable right)
            {
                return left.compareTo(right);
            }
        });
    }

    final public void sort(Comparable[] comparables, Comparator<Comparable> comparator)
    {
        doSort(comparables, comparator);
    }
}
