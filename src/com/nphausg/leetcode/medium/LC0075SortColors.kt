/**
 * <a href="https://leetcode.com/problems/sort-colors">75. Sort Colors</a>
 */

class Solution {
    fun sortColors(nums: IntArray): Unit {
        val n = nums.size
        var low = 0
        var mid = 0
        var high = n - 1
        while (mid <= high){
            when (nums[mid]){
                0 -> {
                    val temp = nums[low]
                    nums[low] = nums[mid]
                    nums[mid] = temp
                    low ++
                    mid ++
                }
                1 -> {
                    mid++
                }
                2 -> {
                    val temp = nums[high]
                    nums[high] = nums[mid]
                    nums[mid] = temp
                    high --
                }
            }
        }
    }
}