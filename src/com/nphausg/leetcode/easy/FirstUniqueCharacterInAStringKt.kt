package com.nphausg.leetcode.easy

class FirstUniqueCharacterInAStringKt {

    fun firstNonRepeatedChar(input: String): Char? {
        val charCount = input.groupingBy { it }.eachCount()
        return input.find { charCount[it] == 1 }
    }

    fun firstUniqChar(s: String): Int {
        val charCounts = s.groupingBy { it }.eachCount()
        return s.indexOfFirst { charCounts[it] == 1 }
    }

    fun firstUniqChar2(s: String): Int {
        var count = IntArray(26)
        for (c in s){
            count[c - 'a']++
        }
        for (i in s.indices){
            if(count[s[i] - 'a'] == 1){
                return i
            }
        }
        return -1
    }

}