package com.victropolis.algorithms.sorting;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public interface Sorter<C extends Comparable<? super C>>
{
    void sort(C[] comparables);

    void sort(C[] comparables, Comparator<C> comparator);
}