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
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        return emptyList()
    }

    class TestCase : BaseTest() {
        @Test
        fun test() {
            println(CombinationSum.combinationSum(5, intArrayOf(2, 3)))
            println(CombinationSum.combinationSum(7, intArrayOf(2, 3)))
            println(CombinationSum.combinationSum(8, intArrayOf(2, 3, 5)))
            println(CombinationSum.combinationSum(7, intArrayOf(5, 3, 4, 7)))
            println(CombinationSum.combinationSum(300, intArrayOf(7, 14)))
        }
    }
}