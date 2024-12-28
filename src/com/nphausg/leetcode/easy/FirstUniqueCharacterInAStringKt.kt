package com.nphausg.leetcode.easy

class FirstUniqueCharacterInAStringKt {

    fun firstNonRepeatedChar(input: String): Char? {
        val charCount = input.groupingBy { it }.eachCount()
        return input.find { charCount[it] == 1 }
    }
//    val result = firstNonRepeatedChar("swiss")
//    println(result)  // Output: w
}