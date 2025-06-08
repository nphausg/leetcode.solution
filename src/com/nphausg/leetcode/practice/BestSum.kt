package com.nphausg.leetcode.practice

import com.nphausg.leetcode.config.BaseTest
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

@RunWith(Enclosed::class)
object BestSum {
    // m = targetSum , n = numbers.length
    // BruteForce | Space: O (n) | Time: O (n^m)
    private fun bestSum(targetSum: Int, nums: IntArray): IntArray? {
        if (targetSum == 0) return intArrayOf()
        if (targetSum < 0) return null

        var shortestCombination: IntArray? = null
        for (num in nums) {
            val r = targetSum - num
            val result = bestSum(r, nums)
            if (result != null) {
                val combination = result + num
                if (shortestCombination == null || combination.size < shortestCombination.size) {
                    shortestCombination = combination
                }
            }
        }
        return shortestCombination
    }

    /**
     * Finds the shortest combination of numbers from a given array that sums up to the targetSum.
     *
     * This function uses a dynamic programming approach with memoization to efficiently
     * find the result.
     *
     * @param targetSum The target integer sum.
     * @param numbers An array of integers that can be used to form the sum.
     * @param memo A memoization table to store results of previously computed subproblems.
     * This is used for the recursive calls and should not be provided by the initial caller.
     * @return A list of integers representing the shortest combination, or null if no combination is possible.
     */
    fun bestSumMemoized(
        targetSum: Int,
        numbers: Array<Int>,
        memo: MutableMap<Int, List<Int>?> = mutableMapOf()
    ): List<Int>? {
        // Base Case 1: If targetSum is already in the memo, return the stored result.
        if (memo.containsKey(targetSum)) {
            return memo[targetSum]
        }

        // Base Case 2: If targetSum is 0, we've found a combination. The combination is an empty list.
        if (targetSum == 0) {
            return emptyList()
        }

        // Base Case 3: If targetSum is negative, it's impossible to reach it from positive numbers.
        if (targetSum < 0) {
            return null
        }

        // This will hold the shortest combination found so far for the current targetSum.
        var shortestCombination: List<Int>? = null

        // Iterate through each number in the input array.
        for (num in numbers) {
            val remainder = targetSum - num

            // Recursively call bestSum for the remainder.
            val remainderCombination = bestSumMemoized(remainder, numbers, memo)

            // If the recursive call found a valid combination for the remainder...
            if (remainderCombination != null) {
                // ...create the new combination by adding the current number.
                val combination = remainderCombination + num

                // If this is the first valid combination we've found, or if it's shorter
                // than the previously found shortest combination, update our best result.
                if (shortestCombination == null || combination.size < shortestCombination.size) {
                    shortestCombination = combination
                }
            }
        }

        // Store the result for the current targetSum in the memo before returning.
        memo[targetSum] = shortestCombination
        return shortestCombination
    }

    class TestCase : BaseTest() {

        @Test
        fun test() {
            println(bestSumMemoized(7, arrayOf(2, 3))) // [3, 2, 2]
            println(bestSumMemoized(7, arrayOf(5, 3, 4, 7))) // [7]
            println(bestSumMemoized(8, arrayOf(1, 4, 5))) // [4, 4]
            println(bestSumMemoized(100, arrayOf(1, 2, 5, 25))) // [25, 25, 25, 25]
            println(bestSumMemoized(300, arrayOf(7, 14))) // null
        }
    }
}