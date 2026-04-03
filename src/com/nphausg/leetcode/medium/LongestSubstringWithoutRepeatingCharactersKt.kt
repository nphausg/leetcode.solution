package com.nphausg.leetcode.medium

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">3. Longest Substring Without Repeating Characters</a>
 */
class LongestSubstringWithoutRepeatingCharactersKt {
    fun longestSubstringWithoutRepeating(input: String): String {
        var start = 0
        var maxLength = 0
        var maxSubstring = ""
        val charSet = mutableSetOf<Char>()

        for (end in input.indices) {
            while (input[end] in charSet) {
                charSet.remove(input[start])
                start++
            }
            charSet.add(input[end])
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1
                maxSubstring = input.substring(start, end + 1)
            }
        }
        return maxSubstring
    }
   
   fun longestSubstringWithoutRepeating2(input: String): String {
        var left = 0
        var right = 0
        var maxLength = 0
        var bestStart = 0
        val chars = hashSetOf<Char>()
        while (right < input.length){
            if(!chars.contains(input[right])){
                chars.add(input[right])
                val window = right - left + 1 
                if(window > maxLength){
                    maxLength = window
                    bestStart = left
                }
                right++
            } else {
                chars.remove(input[left])
                left++
            }
        }
        return s.substring(bestStart, bestStart + maxLength)
    }
}