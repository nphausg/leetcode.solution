package com.nphausg.leetcode.medium

import com.nphausg.leetcode.config.BaseTest
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

/**
 * <a href="https://leetcode.com/problems/combination-sum">39. Combination Sum</a>
 * Return an array containing any combination of elements that add up to
 * exactly the targetSum.
 * - If there is no combination that adds up to the targetSum, then return null.
 * - If there are multiple combinations possible, you may return any single one.
 */
@RunWith(Enclosed::class)
object CombinationSumKt {

    fun combinationSum(target: Int, candidates: IntArray): List<List<Int>> {

        val results = mutableListOf<List<Int>>()
        val currentCombination = mutableListOf<Int>()

        // The backtracking function does all the heavy lifting.
        fun backtrack(remaining: Int, start: Int) {
            // Base Case 1: We found a valid combination!
            if (remaining == 0) {
                // Add a copy of the current combination to results.
                results.add(currentCombination.toList())
                return
            }

            // Base Case 2: We overshot the target. This path is invalid.
            if (remaining < 0) {
                return
            }

            // Explore all valid candidates starting from the 'start' index.
            for (i in start until candidates.size) {
                val candidate = candidates[i]

                // 1. CHOOSE: Add the candidate to our current path.
                currentCombination.add(candidate)

                // 2. EXPLORE: Recursively call with the new remaining target.
                // We pass `i` instead of `i + 1` because we can reuse the same number.
                backtrack(remaining - candidate, i)

                // 3. UN-CHOOSE (Backtrack): Remove the candidate to explore other paths.
                currentCombination.removeAt(currentCombination.lastIndex)
            }
        }

        backtrack(target, 0)
        return results
    }

    class TestCase : BaseTest() {

        @Test
        fun test() {
            //println(combinationSum(5, intArrayOf(2, 3)))
            //println(combinationSum(7, intArrayOf(2, 3, 6, 7)))
           // println(combinationSum(7, intArrayOf(2, 3)))
           // println(combinationSum(8, intArrayOf(2, 3, 5)))
           // println(combinationSum(7, intArrayOf(5, 3, 4, 7)))
           // println(combinationSum(300, intArrayOf(7, 14)))
            println(combinationSum(8, intArrayOf(10, 1, 2, 7, 6, 1, 5)))
          //  println(combinationSum(5, intArrayOf(2, 5, 2, 1, 2)))
        }
    }
}