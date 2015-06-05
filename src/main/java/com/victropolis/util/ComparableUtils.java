package com.victropolis.util;

import java.util.Comparator;

/**
 * Created by victropolis on 5/19/15.
 */
public class ComparableUtils
{
    public static <C extends Comparable<? super C>> boolean neq(C a, C b)
    {
        return a.compareTo(b) != 0;
    }

    public static <C extends Comparable<? super C>> boolean eq(C a, C b)
    {
        return a.compareTo(b) == 0;
    }

    public static <C extends Comparable<? super C>> boolean lt(C a, C b)
    {
        return a.compareTo(b) < 0;
    }

    public static <C extends Comparable<? super C>> boolean gt(C a, C b)
    {
        return a.compareTo(b) > 0;
    }

    public static <C extends Comparable<? super C>> boolean lte(C a, C b)
    {
        return a.compareTo(b) <= 0;
    }

    public static <C extends Comparable<? super C>> boolean gte(C a, C b)
    {
        return a.compareTo(b) >= 0;
    }

    public static <C extends Comparable<? super C>> boolean lt(C a, C b, Comparator<C> comparator)
    {
        return comparator.compare(a, b) < 0;
    }

    public static <C extends Comparable<? super C>> boolean gt(C a, C b, Comparator<C> comparator)
    {
        return comparator.compare(a, b) > 0;
    }

    public static <C extends Comparable<? super C>> boolean lte(C a, C b, Comparator<C> comparator)
    {
        return comparator.compare(a, b) <= 0;
    }

    public static <C extends Comparable<? super C>> boolean gte(C a, C b, Comparator<C> comparator)
    {
        return comparator.compare(a, b) >= 0;
    }
}
