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
}