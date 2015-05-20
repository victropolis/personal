package com.victropolis.util;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class ComparableUtils
{
    public static boolean lt(Comparable a, Comparable b)
    {
        return a.compareTo(b) < 0;
    }

    public static boolean gt(Comparable a, Comparable b)
    {
        return a.compareTo(b) > 0;
    }

    public static boolean lte(Comparable a, Comparable b)
    {
        return a.compareTo(b) <= 0;
    }

    public static boolean gte(Comparable a, Comparable b)
    {
        return a.compareTo(b) >= 0;
    }

    public static boolean lt(Comparable a, Comparable b, Comparator comparator)
    {
        return comparator.compare(a, b) < 0;
    }

    public static boolean gt(Comparable a, Comparable b, Comparator comparator)
    {
        return comparator.compare(a, b) > 0;
    }

    public static boolean lte(Comparable a, Comparable b, Comparator comparator)
    {
        return comparator.compare(a, b) <= 0;
    }

    public static boolean gte(Comparable a, Comparable b, Comparator comparator)
    {
        return comparator.compare(a, b) >= 0;
    }
}
