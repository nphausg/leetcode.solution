/**
 * <a href="https://leetcode.com/problems/daily-temperatures">739. Daily Temperatures</a>
 */

class Solution {
    fun dailyTemperatures(t: IntArray): IntArray {
        val n = t.size
        val result = IntArray(n) {0}
        val stack = ArrayDeque<Int>()

        for (i in t.indices){
            while (stack.isNotEmpty() && t[i] > t [stack.last()]){
                val prevIndex = stack.removeLast()
                result[prevIndex] = i - prevIndex
            }
            stack.addLast(i)
        }

        return result
    }
}