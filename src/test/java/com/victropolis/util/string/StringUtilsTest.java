package com.victropolis.util.string;

import org.junit.*;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.contrib.java.lang.system.SystemOutRule;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * StringUtils Tester.
 *
 * @author <Authors name>
 * @version 1.0
 * @since <pre>Jun 2, 2015</pre>
 */
public class StringUtilsTest {
    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();

    /**
     * Method: reverseWords(char[] sentence)
     */
    @Test
    public void testReverseWords() throws Exception {
        char[] sentence = "This is a test of the emergency broadcast system.".toCharArray();
        StringUtils.reverseWords(sentence);
        Assert.assertEquals("system. broadcast emergency the of test a is This", String.valueOf(sentence));
    }

    @Test
    public void testReverseWords2() throws Exception {
        char[] sentence = "  This is a test of the emergency broadcast system.  ".toCharArray();
        StringUtils.reverseWords(sentence);
        Assert.assertEquals("  system. broadcast emergency the of test a is This  ", String.valueOf(sentence));
    }

    @Test
    public void testReverseWords3() throws Exception {
        char[] sentence = "  This is a test of  the . emergency broadcast system.  ".toCharArray();
        StringUtils.reverseWords(sentence);
        Assert.assertEquals("  system. broadcast emergency . the  of test a is This  ", String.valueOf(sentence));
    }

    /**
     * Method: reverse(char[] chars)
     */
    @Test
    public void testReverseRecursively() throws Exception {
        Assert.assertEquals("zyxwvutsrqponmlkjihgfedcba", StringUtils.reverseRecursively("abcdefghijklmnopqrstuvwxyz"));
    }

    @Test
    public void testReverse() throws Exception {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] reverse = "zyxwvutsrqponmlkjihgfedcba".toCharArray();
        StringUtils.reverse(chars);
        Assert.assertEquals(String.valueOf(reverse), String.valueOf(chars));
    }

    @Test
    public void testReverse2() throws Exception {
        char[] chars = "abc def ghi jkl mno pqr stu vwx yz".toCharArray();
        char[] reverse = "zy xwv uts rqp onm lkj ihg fed cba".toCharArray();
        StringUtils.reverse(chars);
        Assert.assertEquals(String.valueOf(reverse), String.valueOf(chars));
    }

    /**
     * Method: reverseSubstring(char[] chars, int start, int end)
     */
    @Test
    public void testReverseSubstring() throws Exception {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] reverse = "abcfedghijklmnopqrstuvwxyz".toCharArray();
        StringUtils.reverseSubstring(chars, 3, 5);
        Assert.assertEquals(String.valueOf(reverse), String.valueOf(chars));
    }

    @Test
    public void testReverseSubstring2() throws Exception {
        char[] chars = "abc def ghi jkl mno pqr stu vwx yz".toCharArray();
        char[] reverse = "abc fed ghi jkl mno pqr stu vwx yz".toCharArray();
        StringUtils.reverseSubstring(chars, 4, 6);
        Assert.assertEquals(String.valueOf(reverse), String.valueOf(chars));
    }

    @Test
    public void testPrintDuplicateCharaters() throws Exception {
        StringUtils.printDuplicateCharaters("aaa");
        Assert.assertEquals("a", systemOutRule.getLog());

        systemOutRule.clearLog();

        StringUtils.printDuplicateCharaters("a a a");
        Assert.assertEquals("a", systemOutRule.getLog());
    }

    @Test
    public void testPrintDuplicateCharaters2() throws Exception {
        StringUtils.printDuplicateCharaters("aaabbb");
        Assert.assertEquals("ab", systemOutRule.getLog());

        systemOutRule.clearLog();

        StringUtils.printDuplicateCharaters("aaa bbb");
        Assert.assertEquals("ab", systemOutRule.getLog());

        systemOutRule.clearLog();

        StringUtils.printDuplicateCharaters("a a a b b b");
        Assert.assertEquals("ab", systemOutRule.getLog());
    }

    @Test
    public void testPrintDuplicateCharaters3() throws Exception {
        StringUtils.printDuplicateCharaters("ababab");
        Assert.assertEquals("ab", systemOutRule.getLog());

        systemOutRule.clearLog();

        StringUtils.printDuplicateCharaters("ab ab ab");
        Assert.assertEquals("ab", systemOutRule.getLog());

        systemOutRule.clearLog();

        StringUtils.printDuplicateCharaters("a b a b a b");
        Assert.assertEquals("ab", systemOutRule.getLog());
    }

    @Test
    public void testAreAnagrams() throws Exception {
        Assert.assertTrue(StringUtils.areAnagrams("Army", "Mary"));
        Assert.assertTrue(StringUtils.areAnagrams("The earthquakes", "That queer shake"));
        Assert.assertTrue(StringUtils.areAnagrams("School master", "The classroom"));
        Assert.assertTrue(StringUtils.areAnagrams("Eleven plus two", "Twelve plus one"));
        Assert.assertFalse(StringUtils.areAnagrams("one", "two"));
    }

    @Test
    public void test() throws Exception {
        Assert.assertEquals("abcbabcba", StringUtils.longestPalindromicSubstring("babcbabcbaccba"));
        Assert.assertEquals("ccddcc", StringUtils.longestPalindromicSubstring("abaccddccefe"));
        Assert.assertEquals("1234567887654321", StringUtils.longestPalindromicSubstring("HYTBCABADEFGHABCDEDCBAGHTFYW1234567887654321ZWETYGDE"));
        Assert.assertEquals("tattarrattat", StringUtils.longestPalindromicSubstring("tattarrattat"));
        Assert.assertEquals("aibohphobia", StringUtils.longestPalindromicSubstring("aibohphobia"));
        Assert.assertEquals("aibohphobia", StringUtils.longestPalindromicSubstring("abcaibohphobiaxyz"));
        Assert.assertEquals("detartrated", StringUtils.longestPalindromicSubstring("detartrated"));
        Assert.assertEquals("detartrated", StringUtils.longestPalindromicSubstring("abcdetartratedxyz"));
        Assert.assertEquals("kinnikinnik", StringUtils.longestPalindromicSubstring("kinnikinnik"));
        Assert.assertEquals("kinnikinnik", StringUtils.longestPalindromicSubstring("abckinnikinnikxyz"));
    }

    @Test
    public void testFirstUniqueChar() throws Exception {
        Assert.assertEquals('M', StringUtils.firstUniqueChar("Morning"));
        Assert.assertEquals('Z', StringUtils.firstUniqueChar("aaaZaaa"));
        Assert.assertEquals(0, StringUtils.firstUniqueChar("aaaZZZaaa"));
        Assert.assertEquals('w', StringUtils.firstUniqueChar("swiss"));
    }
}
