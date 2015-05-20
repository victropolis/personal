package com.victropolis.util.sorting.impl;

import com.victropolis.util.ComparableUtils;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class MergeSort extends AbstractSort
{
    @Override
    protected void doSort(Comparable[] comparables, Comparator<Comparable> comparator)
    {
        mergeSort(comparables, comparator);
    }

    private void mergeSort(Comparable[] array, Comparator<Comparable> comparator)
    {
        mergeSort(array, 0, array.length / 2, array.length / 2, array.length - array.length / 2, comparator);
    }

    private void mergeSort(Comparable[] array, int leftIndex, int leftSize, int rightIndex, int rightSize, Comparator<Comparable> comparator)
    {
        if (leftSize > 1)
        {
            int center = leftSize / 2;

            mergeSort(array, leftIndex, center, leftIndex + center, leftSize - center, comparator);
        }

        if (rightSize > 1)
        {
            int center = rightSize / 2;

            mergeSort(array, rightIndex, center, rightIndex + center, rightSize - center, comparator);
        }

        merge(array, leftIndex, leftSize, rightIndex, rightSize, comparator);
    }

    private void merge(Comparable[] array, int leftIndex, int leftSize, int rightIndex, int rightSize, Comparator<Comparable> comparator)
    {
        int mergingIndex = leftIndex;

        Comparable[] merged = new Comparable[leftSize+rightSize];

        int leftLimit = leftIndex + leftSize;

        int rightLimit = rightIndex + rightSize;

        for (int mi = 0; leftIndex < leftLimit || rightIndex < rightLimit; mi++)
        {
            if (leftIndex < leftLimit && rightIndex < rightLimit)
            {
                if (ComparableUtils.lt(array[leftIndex], array[rightIndex], comparator))
                {
                    merged[mi] = array[leftIndex++];
                }
                else
                {
                    merged[mi] = array[rightIndex++];
                }
            }
            else if (leftIndex < leftLimit)
            {
                merged[mi] = array[leftIndex++];
            }
            else if (rightIndex < rightLimit)
            {
                merged[mi] = array[rightIndex++];
            }
        }

        for (int mi = 0, ai = mergingIndex; mi < merged.length; mi++, ai++)
        {
            array[ai] = merged[mi];
        }
    }
}