package com.nphausg.leetcode.practice

import com.nphausg.leetcode.config.BaseTest
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

/**
 * Finds all possible ways to construct a target string by concatenating elements from a word bank.
 * This function uses a memoization table to store results of subproblems,
 * which significantly improves performance for larger inputs by avoiding redundant computations.
 *
 * @param target The string that needs to be constructed.
 * @param wordBank A list of strings that can be used to construct the target.
 * @param memo A mutable map used for memoization. It stores the results of subproblems
 * where the key is the target substring and the value is a list of all
 * possible construction ways for that substring. Defaults to an empty map.
 * @return A 2D list (List<List<String>>) containing all possible combinations of words
 * from the wordBank that form the target string. Each inner list represents one such way.
 */
@RunWith(Enclosed::class)
object AllConstruct {

    fun allConstruct(
        target: String,
        wordBank: List<String>,
        memo: MutableMap<String, List<List<String>>> = mutableMapOf()
    ): List<List<String>> {
        // Check if the result for the current target is already in the memo.
        // If it is, return the memoized result to avoid recomputing.
        if (memo.containsKey(target)) {
            return memo[target]!!
        }

        // Base case: If the target is an empty string, it can be constructed in one way:
        // by using an empty list of words. This is represented by `listOf(listOf())`.
        if (target.isEmpty()) {
            return listOf(listOf())
        }

        // Initialize a list to store all the ways to construct the current target.
        val resultWays = mutableListOf<List<String>>()

        // Iterate through each word in the wordBank.
        for (word in wordBank) {
            // Check if the current target string starts with the current word.
            if (target.startsWith(word)) {
                // Calculate the suffix string by removing the word from the beginning of the target.
                val suffix = target.substring(word.length)

                // Recursively call allConstruct for the suffix.
                // This call will return all ways to construct the suffix.
                val suffixWays = allConstruct(suffix, wordBank, memo)

                // For each way found to construct the suffix, prepend the current word to it.
                // This creates a complete way to construct the original target.
                val targetWays = suffixWays.map { way ->
                    // Create a new list with the current word at the beginning,
                    // followed by the words from the suffix's construction way.
                    listOf(word) + way
                }

                // Add all these newly found ways to the resultWays list.
                resultWays.addAll(targetWays)
            }
        }

        // Store the computed result for the current target in the memo before returning it.
        memo[target] = resultWays
        return resultWays
    }

    class TestCase : BaseTest() {

        @Test
        fun test() {
            println(allConstruct("purple", listOf("purp", "p", "ur", "le", "purpl")))
            println("--- Test Cases ---")

            // Test Case 1: Simple construction
            println("allConstruct(\"purple\", [\"purp\", \"p\", \"ur\", \"le\", \"purpl\"])")
            val result1 = allConstruct("purple", listOf("purp", "p", "ur", "le", "purpl"))
            println(result1) // Expected: [[purp, le], [p, ur, p, le], [p, ur, le]]
            println()

            // Test Case 2: Another simple case
            println("allConstruct(\"abcdef\", [\"ab\", \"abc\", \"cd\", \"def\", \"abcd\", \"ef\", \"c\"])")
            val result2 = allConstruct("abcdef", listOf("ab", "abc", "cd", "def", "abcd", "ef", "c"))
            println(result2) // Expected: [[ab, cd, ef], [ab, c, def], [abc, def], [abcd, ef]]
            println()

            // Test Case 3: Target cannot be constructed
            println("allConstruct(\"skateboard\", [\"bo\", \"rd\", \"ate\", \"t\", \"ska\", \"sk\", \"boar\"])")
            val result3 = allConstruct("skateboard", listOf("bo", "rd", "ate", "t", "ska", "sk", "boar"))
            println(result3) // Expected: []
            println()

            // Test Case 4: Target cannot be constructed (empty wordBank)
            println("allConstruct(\"abcdef\", [])")
            val result4 = allConstruct("abcdef", listOf())
            println(result4) // Expected: []
            println()

            // Test Case 5: Target is empty
            println("allConstruct(\"\", [\"a\", \"b\", \"c\"])")
            val result5 = allConstruct("", listOf("a", "b", "c"))
            println(result5) // Expected: [[]]
            println()

            // Test Case 6: Longer target, demonstrating memoization benefit
            println("allConstruct(\"eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef\", [\"e\", \"ee\", \"eee\", \"eeee\", \"eeeee\", \"eeeeee\"])")
            val result6 = allConstruct(
                "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",
                listOf("e", "ee", "eee", "eeee", "eeeee", "eeeeee")
            )
            println(result6) // Expected: [] (because of 'f' at the end)
            println()

            println("allConstruct(\"aaaaaaa\", [\"a\", \"aa\", \"aaa\", \"aaaa\", \"aaaaa\"])")
            val result7 = allConstruct("aaaaaaa", listOf("a", "aa", "aaa", "aaaa", "aaaaa"))
            println(result7)
            // Example: "aaaaaaa"
            // Expected output for aaaaaaa:
            // [[a, a, a, a, a, a, a], [a, a, a, a, a, aa], [a, a, a, a, aa, a], [a, a, a, a, aaa], [a, a, a, aa, a, a],
            // [a, a, a, aa, aa], [a, a, a, aaa, a], [a, a, aa, a, a, a], [a, a, aa, aa], [a, a, aaa, a], [a, a, aaaa],
            // [a, aa, a, a, a, a], [a, aa, a, a, aa], [a, aa, a, aaa], [a, aa, aa, a], [a, aa, aaa], [a, aaa, a, a],
            // [a, aaa, aa], [a, aaaa, a], [aa, a, a, a, a, a], [aa, a, a, a, aa], [aa, a, a, aaa], [aa, a, aa, a],
            // [aa, a, aaa], [aa, aa, a, a], [aa, aa, aa], [aa, aaa, a], [aaa, a, a, a], [aaa, a, aa], [aaa, aa, a],
            // [aaaa, a], [aaaaa, aa]] (order may vary, but all combinations should be present)
            println()
        }
    }
}