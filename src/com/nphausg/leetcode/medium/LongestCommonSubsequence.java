package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * 1143. Longest Common Subsequence
 * The longest common subsequence problem is a classic dynamic programming problem.
 * The approach involves breaking down the problem into smaller sub  problems and building up the solution using a DP table.
 * This method ensures that we efficiently compute the length of the longest common subsequence in
 * 𝑂(𝑚×𝑛) time.
 * <a href="https://leetcode.com/problems/longest-common-subsequence">1143. Longest Common Subsequence</a>
 */
@RunWith(Enclosed.class)
public class LongestCommonSubsequence {

    // Solution 1: Recursive Approach O(2^(m+n))
    public static int longestCommonSubsequence(String text1, String text2) {
        return lcsHelper(text1, text2, text1.length(), text2.length());
    }

    private static int lcsHelper(String text1, String text2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            return 1 + lcsHelper(text1, text2, m - 1, n - 1);
        } else {
            return Math.max(lcsHelper(text1, text2, m - 1, n), lcsHelper(text1, text2, m, n - 1));
        }
    }

    // Solution 2: Memoization (Top - Down DP) O(m * n)
    public static int longestCommonSubsequence2(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return lcsHelper(text1, text2, text1.length(), text2.length(), dp);
    }

    private static int lcsHelper(String text1, String text2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
            dp[m][n] = 1 + lcsHelper(text1, text2, m - 1, n - 1);
        } else {
            dp[m][n] = Math.max(lcsHelper(text1, text2, m - 1, n), lcsHelper(text1, text2, m, n - 1));
        }
        return dp[m][n];
    }

    // Solution 3: Tabulation (Bottom-Up DP) O(m * n)
    public static int longestCommonSubsequence3(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    public static int longestCommonSubsequence4(String text1, String text2) {
        if (text1.isEmpty() || text2.isEmpty()) {
            return 0;
        }

        int m = text1.length();
        int n = text2.length();

        // Create a 2D array to store the lengths of LCS
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        // The length of the longest common subsequence
        return dp[m][n];
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(3, longestCommonSubsequence2("abcde", "ace"));
            assertEquals(3, longestCommonSubsequence2("apt", "apt"));
            assertEquals(0, longestCommonSubsequence2("abc", "def"));
        }
    }
}
