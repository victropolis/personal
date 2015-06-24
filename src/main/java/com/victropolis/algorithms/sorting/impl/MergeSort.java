package com.victropolis.algorithms.sorting.impl;

import com.victropolis.util.ComparableUtils;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class MergeSort<C extends Comparable<? super C>> extends AbstractSort<C>
{
    @Override
    protected void concreteSort(C[] comparables, Comparator<C> comparator)
    {
        mergeSort(comparables, comparator);
    }

    private void mergeSort(C[] comparables, Comparator<C> comparator)
    {
        mergeSort(comparables, 0, comparables.length / 2, comparables.length / 2, comparables.length - comparables.length / 2, comparator);
    }

    private void mergeSort(C[] comparables, int leftIndex, int leftSize, int rightIndex, int rightSize, Comparator<C> comparator)
    {
        if (leftSize > 1)
        {
            int center = leftSize / 2;

            mergeSort(comparables, leftIndex, center, leftIndex + center, leftSize - center, comparator);
        }

        if (rightSize > 1)
        {
            int center = rightSize / 2;

            mergeSort(comparables, rightIndex, center, rightIndex + center, rightSize - center, comparator);
        }

        merge(comparables, leftIndex, leftSize, rightIndex, rightSize, comparator);
    }

    private void merge(C[] comparables, int leftIndex, int leftSize, int rightIndex, int rightSize, Comparator<C> comparator)
    {
        int mergingIndex = leftIndex;

        Comparable[] merged = new Comparable[leftSize+rightSize];

        int leftLimit = leftIndex + leftSize;

        int rightLimit = rightIndex + rightSize;

        for (int mi = 0; leftIndex < leftLimit || rightIndex < rightLimit; mi++)
        {
            if (leftIndex < leftLimit && rightIndex < rightLimit)
            {
                if (ComparableUtils.lt(comparables[leftIndex], comparables[rightIndex], comparator))
                {
                    merged[mi] = comparables[leftIndex++];
                }
                else
                {
                    merged[mi] = comparables[rightIndex++];
                }
            }
            else if (leftIndex < leftLimit)
            {
                merged[mi] = comparables[leftIndex++];
            }
            else if (rightIndex < rightLimit)
            {
                merged[mi] = comparables[rightIndex++];
            }
        }

        for (int mi = 0, ai = mergingIndex; mi < merged.length; mi++, ai++)
        {
            comparables[ai] = (C)merged[mi];
        }
    }
}