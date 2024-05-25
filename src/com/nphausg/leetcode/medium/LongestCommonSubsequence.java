package com.nphausg.leetcode.medium;

/**
 * 1143. Longest Common Subsequence
 * The longest common subsequence problem is a classic dynamic programming problem.
 * The approach involves breaking down the problem into smaller subproblems and building up the solution using a DP table.
 * This method ensures that we efficiently compute the length of the longest common subsequence in
 * 𝑂(𝑚×𝑛) time.
 * <a href="https://leetcode.com/problems/longest-common-subsequence">...</a>
 */
public class LongestCommonSubsequence {

    public static int longestCommonSubsequence(String text1, String text2) {
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
}
