package com.nphausg.leetcode.practice

import com.nphausg.leetcode.config.BaseTest
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

@RunWith(Enclosed::class)
object HowSumKt {

    // m = targetSum , n = numbers.length
    // BruteForce | Space: O (n) | Time: O (n^m)
    private fun howSum(targetSum: Int, nums: IntArray): IntArray? {
        if (targetSum == 0) return intArrayOf()
        if (targetSum < 0) return null

        for (num in nums) {
            val r = targetSum - num
            val result = howSum(r, nums)
            if (result != null) {
                return result + num
            }
        }
        return null
    }

    private fun howSumMemoized(targetSum: Int, nums: IntArray): IntArray? {
        return howSumHelper(targetSum, nums, hashMapOf())
    }

    private fun howSumHelper(targetSum: Int, nums: IntArray, memo: HashMap<Int, IntArray?>): IntArray? {
        if (targetSum in memo) return memo[targetSum]
        if (targetSum == 0) return intArrayOf()
        if (targetSum < 0) return null

        for (num in nums) {
            val r = targetSum - num
            val result = howSumHelper(r, nums, memo)
            if (result != null) {
                memo[targetSum] = result + num
                return memo[targetSum]
            }
        }
        memo[targetSum] = null
        return null
    }

    class TestCase : BaseTest() {

        @Test
        fun test() {
            println(howSumMemoized(7, intArrayOf(2, 3)).contentToString()) // [3, 2, 2]
            println(howSumMemoized(7, intArrayOf(2, 4)).contentToString()) // null
            println(howSumMemoized(7, intArrayOf(5, 3, 4, 7)).contentToString()) // [4, 3]
            println(howSumMemoized(8, intArrayOf(2, 3, 5)).contentToString()) // [2, 2, 2, 2]
            println(howSumMemoized(300, intArrayOf(7, 14))) // null
        }
    }
}