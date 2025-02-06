package com.nphausg.leetcode.medium

/**
 * @see <a href="https://leetcode.com/problems/guess-number-higher-or-lower-ii">375. Guess Number Higher or Lower II/a>
 */
class GuessNumberHigherOrLowerIIKt {

    fun topDownGetMoneyAmount(n: Int): Int {
        val memo = Array(n + 1) { IntArray(n + 1) }
        return calculateCost(memo, 1, n)
    }

    private fun calculateCost(memo: Array<IntArray>, start: Int, end: Int): Int {
        if (start >= end) return 0
        if (memo[start][end] != 0) return memo[start][end]
        var minCost = Int.MAX_VALUE
        for (k in start..end) {
            val cost = k + maxOf(calculateCost(memo, start, k - 1), calculateCost(memo, k + 1, end))
            minCost = minOf(minCost, cost)
        }
        memo[start][end] = minCost
        return minCost
    }

    fun bottomUpGetMoneyAmount(n: Int): Int {
        val dp = Array(n + 1) { IntArray(n + 1) }
        for (len in 2..n) {
            for (start in 1..n - len + 1) {
                val end = start + len - 1
                dp[start][end] = Int.MAX_VALUE
                for (k in start until end) {
                    val cost = k + maxOf(dp[start][k - 1], dp[k + 1][end])
                    dp[start][end] = minOf(dp[start][end], cost)
                }
            }
        }
        return dp[1][n]
    }
}