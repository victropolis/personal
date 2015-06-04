package com.victropolis.util.sorting;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public interface Sorter<T extends Comparable<? super T>>
{
    void sort(T[] comparables);

    void sort(T[] comparables, Comparator<T> comparator);
}