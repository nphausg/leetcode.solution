/**
 * <a href="https://leetcode.com/problems/squares-of-a-sorted-array">977. Squares of a Sorted Array</a>
 */

class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        for (i in nums.indices) {
            nums[i] = nums[i] * nums[i]
        }
        nums.sort()
        return nums
    }

    fun sortedSquares2(nums: IntArray): IntArray {
        for (i in nums.indices) {
            nums[i] = nums[i] * nums[i]
        }
        val n = nums.size
        for (i in 0 until n - 1){
            var swapped = false
            for (j in 0 until n - 1 - i){
                if(nums[j] > nums[j + 1]){
                    val temp = nums[j]
                    nums[j] = nums[j + 1]
                    nums[j + 1] = temp
                    swapped = true
                }
            }
            if(!swapped) break
        }
        return nums
    }

    fun sortedSquares3(nums: IntArray): IntArray {
        val n = nums.size
        val res = IntArray (n)
        var left = 0
        var right = n - 1
        var p = n - 1
        while (left <= right) {
            val sl = nums[left] * nums[left] 
            val sr = nums[right] * nums[right] 

            if(sl > sr){
                res[p] = sl
                left++
            }
            else {
                res[p] = sr
                right--
            }
            p--
        }
        return res
    }
}