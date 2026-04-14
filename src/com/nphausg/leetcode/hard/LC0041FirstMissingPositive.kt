/**
 * <a href="https://leetcode.com/problems/first-missing-positive">41. First Missing Positive</a>
 */

/*
 * Created by nphau on 09/12/2021, 00:30
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 09/12/2021, 15:54
 */
class Solution {
    fun firstMissingPositive(nums: IntArray): Int {
        val set = nums.toHashSet()
        var target = 1
        while (set.contains(target)){
            target++
        }
        return target
    }

    fun solution(numbers: IntArray): Int {
        val n = numbers.size
        val present = BooleanArray(n + 1)
        numbers.forEach { number ->
            if (number in 1..n) {
                present[number] = true
            }
        }
        for (index in 1..n) {
            if (!present[index]) return index
        }
        return n + 1
    }

    fun firstMissingPositive(nums: IntArray): Int {
        val n = nums.size
        var i = 0
        while (i < n){
            val correctIndex = nums[i] - 1
            if(nums[i] in 1..n && nums[i] != nums[correctIndex]){
                val temp = nums[i]
                nums[i] = nums[correctIndex]
                nums[correctIndex] = temp
            }
            else {
                i++
            }
        }
        for (j in nums.indices){
            if(nums[j] != j + 1){
                return j + 1
            }
        }
        return n + 1
    }
}