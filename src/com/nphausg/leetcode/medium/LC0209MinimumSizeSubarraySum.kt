/**
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum">209. Minimum Size Subarray Sum</a>
 */

class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var sum = 0
        var min = Int.MAX_VALUE
        for (right in nums.indices){
            sum += nums[right]
            while(sum >= target){
                min = minOf(min, right - left + 1)
                sum -= sum[left]
                left ++
            }
        }
        return if (min == Int.MAX_VALUE) 0 else min
    }
}