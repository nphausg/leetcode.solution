package com.nphausg.leetcode.medium

import com.nphausg.leetcode.config.BaseTest
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

/**
 * <a href="https://leetcode.com/problems/combination-sum-ii">40. Combination Sum II</a>
 */
@RunWith(Enclosed::class)
object CombinationSumIIKt {
    fun combinationSum2(target: Int, candidates: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        val currentCombination = mutableListOf<Int>()

        // Step 1: Sort the candidates array.
        // This is crucial for handling duplicates and skipping them efficiently.
        candidates.sort()

        // Helper function for backtracking
        fun backtrack(startIndex: Int, currentSum: Int) {
            // Base Case 1: Found a valid combination
            if (currentSum == target) {
                result.add(currentCombination.toList()) // Add a copy to the result list
                return
            }

            // Base Case 2: Sum exceeds target OR we've exhausted all candidates
            if (currentSum > target || startIndex == candidates.size) {
                return
            }

            // Recursive Step: Explore possibilities
            for (i in startIndex until candidates.size) {
                // Skip duplicates:
                // If the current number is the same as the previous one AND
                // we are not considering the first occurrence of this number in the current level of recursion (i > startIndex),
                // then skip it to avoid duplicate combinations.
                if (i > startIndex && candidates[i] == candidates[i - 1]) {
                    continue
                }

                // Optimization: If candidates[i] itself is greater than remaining target,
                // then all subsequent numbers (since array is sorted) will also be greater.
                // So, we can break from the loop.
                if (candidates[i] > target - currentSum) { // currentSum + candidates[i] > target
                    break
                }

                // Choose: Add the current number to the combination
                currentCombination.add(candidates[i])

                // Explore: Recurse with the next index (i + 1) because each number can be used only once
                backtrack(i + 1, currentSum + candidates[i])

                // Un-choose (Backtrack): Remove the current number to explore other paths
                currentCombination.removeAt(currentCombination.size - 1)
            }
        }

        // Start the backtracking process from index 0 with an initial sum of 0
        backtrack(0, 0)
        return result
    }

    class TestCase : BaseTest() {

        @Test
        fun test() {
            println(combinationSum2(8, intArrayOf(10, 1, 2, 7, 6, 1, 5)))
            println(combinationSum2(5, intArrayOf(2, 5, 2, 1, 2)))
        }
    }
}