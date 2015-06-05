package com.victropolis.util.string;

import java.util.*;

/**
 * Created by victropolis on 6/2/15.
 */
public class StringUtils {
    public static String reverseWords(String sentence) {
        char[] data = sentence.toCharArray();
        reverseWords(data);
        return String.valueOf(data);
    }

    public static String reverseSubstring(String string, int start, int end) {
        char[] data = string.toCharArray();
        reverseSubstring(data, start, end);
        return String.valueOf(data);
    }

    public static String reverse(String string) {
        char[] data = string.toCharArray();
        reverse(data);
        return String.valueOf(data);
    }

    public static void reverseWords(char[] sentence) {
        reverse(sentence);

        int wordStart = 0;
        for (int x = wordStart; x < sentence.length; ) {
            if (sentence[x] == ' ') {
                if (x > wordStart) {
                    reverseSubstring(sentence, wordStart, x - 1);
                }
                wordStart = ++x;
            }
            else {
                x++;
            }
        }

        reverseSubstring(sentence, wordStart, sentence.length - 1);
    }

    public static void reverse(char[] chars) {
        reverseSubstring(chars, 0, chars.length - 1);
    }

    public static void reverseSubstring(char[] chars, int start, int end) {
        for (int x = start, y = end; x < y; x++, y--) {
            swap(chars, x, y);
        }
    }

    public static void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    /*
    we have a simple String related coding question frequently asked in programming interviews. You need to write a
    program in C, C++, Java or Python to print duplicate characters from a given String, for example if String is
    "Java" then program should print "a". Bonus points if your program is robust and handle different kinds of input
    e.g. String without duplicate, null or empty String etc. Bonus points if you also write unit tests for normal and
     edge cases.
     */
    public static void printDuplicateCharaters(String string) {
        Map<Character, Integer> set = new HashMap<Character, Integer>();
        for (int x = 0; x < string.length(); x++) {
            Character key = string.charAt(x);
            if (!Character.isSpaceChar(key)) {
                if (set.containsKey(key)) {
                    Integer integer = set.get(key);
                    if (integer.equals(1)) {
                        System.out.print(key);
                    }
                    set.put(key, integer + 1);
                }
                else {
                    set.put(key, Integer.valueOf(1));
                }
            }
        }
    }

    /*
    You need to write a Java program to check if two given strings are anagrams of Each other. Two strings are
    anagrams if they are written using the same exact letters, ignoring space, punctuation and capitalization. Each
    letter should have the same count in both strings. For example, Army and Mary are anagram of each other.
     */
    public static boolean areAnagrams(String one, String two) {
        String oneLower = one.toLowerCase();
        String twoLower = two.toLowerCase();

        int sumOne = 0;
        for (int x = 0; x < oneLower.length(); x++) {
            Character c = oneLower.charAt(x);
            if (Character.isLetterOrDigit(c)) {
                sumOne += c.charValue();
            }
        }

        int sumTwo = 0;
        for (int x = 0; x < twoLower.length(); x++) {
            Character c = twoLower.charAt(x);
            if (Character.isLetterOrDigit(c)) {
                sumTwo += c.charValue();
            }
        }

        return sumOne == sumTwo;
    }

    // Transform s into t.
    // For example, if s = "abba", then t = "$#a#b#b#a#@"
    // the # are interleaved to avoid even/odd-length palindromes uniformly
    // $ and @ are prepended and appended to each end to avoid bounds checking
    private static char[] preprocess(String s) {
        char[] t = new char[s.length() * 2 + 3];
        t[0] = '$';
        t[s.length() * 2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        t[s.length() * 2 + 1] = '#';
        return t;
    }

    // longest palindromic substring
    public static String longestPalindromicSubstring(String string) {
        char[] t = preprocess(string);
        int[] p = getInts(t);

        int length = 0;   // length of longest palindromic substring
        int center = 0;   // center of longest palindromic substring
        for (int i = 1; i < p.length - 1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return string.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }

    private static int[] getInts(char[] t) {
        int[] p = new int[t.length];

        int center = 0, right = 0;
        for (int i = 1; i < t.length - 1; i++) {
            int mirror = 2 * center - i;

            if (right > i) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // attempt to expand palindrome centered at i
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])]) {
                p[i]++;
            }

            // if palindrome centered at i expands past right,
            // adjust center based on expanded palindrome.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

        return p;
    }

    // longest palindromic substring centered at index i/2
    public static String longestPalindromicSubstring(String string, int i) {
        char[] t = preprocess(string);
        int[] p = getInts(t);

        i = i + 2;
        int length = p[i];
        int center = i;

        return string.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }

    public static char firstUniqueChar(String string) {
        int[] counts = new int['~' - ' '];

        for (int x = 0; x < string.length(); x++) {
            ++counts[string.charAt(x) - ' '];
        }

        for (int x = 0; x < string.length(); x++) {
            char c = string.charAt(x);
            if (counts[c - ' '] == 1) {
                return c;
            }
        }

        return 0;
    }

    public static boolean isAscii(String s) {
        int length = s.length();
        for (int i = 0; i < length; i++) {
            final char c = s.charAt(i);
            if (c > 'z') {
                return false;
            }
        }
        return true;
    }

    public static String reverseRecursively(String str) {
        if (str.length() < 2) {
            return str;
        }

        return reverseRecursively(str.substring(1)) + str.charAt(0);
    }
}
