/**
 * <a href="https://leetcode.com/problems/subarray-sum-equals-k">560. Subarray Sum Equals K</a>
 */

class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        var count = 0
        var csum = 0
        val prefixSums = hashMapOf<Int,Int>()

        prefixSum[0] =1
        for(num in nums){
            csum += num
            if(prefixSums.containskey(csum-k)){
                count+=prefixSums[csum -k]!!
            }
            prefixSums[csum] = prefixSums.getOrDefault(csum, 0) + 1
        }
        return count
   }
}
