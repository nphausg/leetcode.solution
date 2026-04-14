package com.nphausg.leetcode.easy
/**
 * <a href="https://leetcode.com/problems/valid-anagram">242. Valid Anagram</a>
 */

class ValidAnagramKt {
    fun areAnagrams(str1: String, str2: String): Boolean {
        return str1.toCharArray().sorted() == str2.toCharArray().sorted()
    }
}