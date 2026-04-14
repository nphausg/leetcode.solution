package com.nphausg.leetcode.easy
/**
 * <a href="https://leetcode.com/problems/sqrtx">69. Sqrt(x)</a>
 */

class Solution {
    fun mySqrt(x: Int): Int {
        // if x < 2 -> x
        // left = 2, right = x / 2
        // mid = left + (right - left) / 2
        // if mid^2 == x -> mid
        // if mid^2 < x, left = mid - 1
        // if mid^2 > x, right = mid + 1
        if( x < 2) return x
        var left = 2
        var right = x / 2
        var ans = 1
        while (left <= right){
            val mid = left + (right - left) / 2
            val num = mid.toLong() * mid
            
            if (num == x.toLong()) {
                return mid
            }
            if( num < x) {
                ans = mid
                left = mid + 1
            }
            else{
                right = mid - 1
            }
        }
        return ans
    }
}