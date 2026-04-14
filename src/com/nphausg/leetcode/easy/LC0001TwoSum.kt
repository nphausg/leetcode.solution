package com.nphausg.leetcode.easy
/**
 * <a href="https://leetcode.com/problems/two-sum">1. Two Sum</a>
 */

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // for (i in 0 until nums.size){
        //     for (j in 0 until nums.size -1){
        //         if(i !=j && nums[i] + nums[j] == target){
        //             return intArrayOf(i, j)
        //         }
        //     }
        // }
        // return intArrayOf()


        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices){
            val diff = target - nums[i]
            if(map.containsKey(diff)){
                return intArrayOf(map[diff]!!, i)
            }
            map[nums[i]] = i
        }
        return intArrayOf()
    }
}