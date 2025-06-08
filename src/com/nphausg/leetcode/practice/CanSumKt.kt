package com.nphausg.leetcode.practice

import com.nphausg.leetcode.config.BaseTest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

@RunWith(Enclosed::class)
object CanSumKt {
    // O (n^m) time , O(m) space
    private fun canSum(targetSum: Int, array: IntArray): Boolean {
        if (targetSum == 0) return true
        if (targetSum < 0) return false
        for (j in array) {
            val r = targetSum - j
            if (canSum(r, array)) {
                return true
            }
        }
        return false
    }

    private fun canSumMemoized(targetSum: Int, array: IntArray): Boolean {
        return helper(targetSum, array, hashMapOf())
    }

    private fun helper(targetSum: Int, array: IntArray, memo: HashMap<Int, Boolean>): Boolean {
        if (targetSum in memo) return memo[targetSum]!!;
        if (targetSum == 0) return true
        if (targetSum < 0) return false
        for (i in array) {
            val r = targetSum - i
            if (helper(r, array, memo)) {
                memo[targetSum] = true
                return true
            }
        }
        memo[targetSum] = false
        return false
    }

    class TestCase : BaseTest() {
        @Test
        fun test() {
            assertTrue(canSumMemoized(5, intArrayOf(2, 3)))
            assertTrue(canSumMemoized(7, intArrayOf(5, 3, 4, 7)))
            assertTrue(canSumMemoized(8, intArrayOf(2, 3, 5)))
            assertFalse(canSumMemoized(7, intArrayOf(2, 4)))
            assertFalse(canSumMemoized(300, intArrayOf(7, 14)))
        }
    }
}