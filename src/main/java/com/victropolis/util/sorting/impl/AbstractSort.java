package com.victropolis.util.sorting.impl;

import com.victropolis.util.sorting.Sorter;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public abstract class AbstractSort<T extends Comparable<? super T>> implements Sorter<T>
{
    protected abstract void doSort(T[] comparables, Comparator<T> comparator);

    final public void sort(T[] comparables)
    {
        sort(comparables, new Comparator<T>()
        {
            public int compare(Comparable left, Comparable right)
            {
                return left.compareTo(right);
            }
        });
    }

    final public void sort(T[] comparables, Comparator<T> comparator)
    {
        doSort(comparables, comparator);
    }
}
