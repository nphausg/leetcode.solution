/**
 * <a href="https://leetcode.com/problems/container-with-most-water">11. Container With Most Water</a>
 */

class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var max = 0
        while( left <= right){
            val a = Math.min(height[left], height[right])
            val b = right - left
            val v = a * b
            if(v >= max){
                max = v
            }
            if(height[left] < height[right]){
                left ++
            }
            else{
                right --
            }
        }
        return max
    }
}