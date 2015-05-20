package com.victropolis.util.sorting;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public interface Sorter
{
    void sort(Comparable[] comparables);

    void sort(Comparable[] comparables, Comparator<Comparable> comparator);
}