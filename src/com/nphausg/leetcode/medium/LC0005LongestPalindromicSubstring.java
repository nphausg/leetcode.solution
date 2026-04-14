package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring">5. Longest Palindromic Substring</a>
 */
@RunWith(Enclosed.class)
public class LC0005LongestPalindromicSubstring {

    // Solution 1: Brute Force O(n^3)
    public static String longestPalindrome(String s) {
        int n = s.length();
        String longest = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub) && sub.length() > longest.length()) {
                    longest = sub;
                }
            }
        }
        return longest;
    }

    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Solution 2: DP O(n^2)
     * Base cases:
     * Single-character substrings are palindromes.
     * Two-character substrings are palindromes if the characters are the same.
     */
    public static String longestPalindrome2(String s) {
        int n = s.length();
        if (n < 2) return s;
        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (len == 2 || dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (len > maxLength) {
                            start = i;
                            maxLength = len;
                        }
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals("bb", longestPalindrome2("cbbd"));
            assertEquals("bab", longestPalindrome2("babad"));
        }
    }
}
