package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
/**
 * <a href="https://leetcode.com/problems/longest-palindrome">409. Longest Palindrome</a>
 */

@RunWith(Enclosed.class)
public class LC0409LongestPalindrome {
    public static int longestPalindrome(String s) {

        return 0;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(1, longestPalindrome("a"));
            assertEquals(7, longestPalindrome("abccccdd"));
        }
    }
}
