package com.nphausg.leetcode.medium;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/guess-number-higher-or-lower-ii">375. Guess Number Higher or Lower II/a>
 */
public class GuessNumberHigherOrLowerII {

    public int topDownGetMoneyAmount(int n) {
        int[][] mem = new int[n + 1][n + 1];
        Arrays.stream(mem).forEach(A -> Arrays.fill(A, Integer.MAX_VALUE));
        return getMoneyAmount(1, n, mem);
    }

    private int getMoneyAmount(int i, int j, int[][] mem) {
        if (i >= j)
            return 0;
        if (mem[i][j] != Integer.MAX_VALUE)
            return mem[i][j];

        for (int k = i; k <= j; ++k)
            mem[i][j] = Math.min(
                    mem[i][j],
                    Math.max(
                            getMoneyAmount(i, k - 1, mem),
                            getMoneyAmount(k + 1, j, mem)
                    ) + k
            );

        return mem[i][j];
    }

    public int bottomUpGetMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int len = 2; len <= n; len++) {
            for (int start = 1; start <= n - len + 1; start++) {
                int end = start + len - 1;
                dp[start][end] = Integer.MAX_VALUE;
                for (int k = start; k < end; k++) {
                    int cost = k + Math.max(dp[start][k - 1], dp[k + 1][end]);
                    dp[start][end] = Math.min(dp[start][end], cost);
                }
            }
        }
        return dp[1][n];
    }
}
