package com.nphausg.leetcode.easy
/**
 * <a href="https://leetcode.com/problems/missing-number">268. Missing Number</a>
 */

class MissingNumberKt {
    fun findMissingNumber(arr: Array<Int>, n: Int): Int {
        val totalSum = (n * (n + 1)) / 2
        val arrSum = arr.sum()
        return totalSum - arrSum
    }
}