package com.nphausg.leetcode.medium

import com.nphausg.leetcode.config.BaseTest
import org.junit.Assert.assertEquals
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

/**
 * <a href="https://leetcode.com/problems/unique-paths">62. Unique Paths</a>
 */
@RunWith(Enclosed::class)
object UniquePathsKt {

    fun uniquePaths(m: Int, n: Int): Long {
        if (m == 0 || n == 0) return 0
        if (m == 1 && n == 1) return 1
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1)
    }

    fun uniquePaths2(m: Int, n: Int): Long {
        if (m == 0 || n == 0) return 0
        if (m == 1 && n == 1) return 1
        return memoHelper(m, n, hashMapOf())
    }

    private fun memoHelper(m: Int, n: Int, memo: HashMap<String, Long>): Long {
        val key = "$m,$n"
        if (key in memo) return memo[key]!!
        if (m == 0 || n == 0) return 0
        if (m == 1 && n == 1) return 1
        memo[key] = memoHelper(m - 1, n, memo) + memoHelper(m, n - 1, memo)
        return memo[key]!!
    }

    fun uniquePaths3(m: Int, n: Int): Int {
        val totalSteps = m + n - 2
        val downSteps = m - 1
        var result: Long = 1

        for (i in 1..downSteps) {
            result = result * (totalSteps - downSteps + i) / i
        }
        return result.toInt()
    }

    class TestCase : BaseTest() {

        @org.junit.Test
        fun test() {
            assertEquals(1, uniquePaths(1, 1))
            assertEquals(3, uniquePaths2(3, 2))
            assertEquals(3, uniquePaths2(2, 3))
            assertEquals(21, uniquePaths2(6, 3))
            assertEquals(28, uniquePaths2(3, 7))
        }
    }
}