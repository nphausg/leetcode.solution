package com.nphausg.leetcode.medium

import com.nphausg.leetcode.config.BaseTest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

/**
 * <a href="https://leetcode.com/problems/word-break">139. Word Break</a>
 */
@RunWith(Enclosed::class)
object WordBreakKt {
    fun wordBreak(target: String, wordDict: List<String>): Boolean {

        fun helper(target: String, wordDict: List<String>, memo: HashMap<String, Boolean>): Boolean {
            if (target in memo) return memo[target]!!
            if (target.isEmpty()) return true
            for (word in wordDict) {
                if (target.startsWith(word)) {
                    val suffix = target.substring(word.length)
                    if (helper(suffix, wordDict, memo)) {
                        memo[suffix] = true
                        return true
                    }
                }
            }
            memo[target] = false
            return false
        }

        return helper(target, wordDict, hashMapOf())
    }

    class TestCase : BaseTest() {

        @Test
        fun test() {
            assertTrue(wordBreak("leetcode", listOf("leet", "code")))
            assertTrue(wordBreak("applepenapple", listOf("apple", "pen")))
            assertFalse(wordBreak("catsandog", listOf("cats", "dog", "sand", "and", "cat")))
            assertFalse(
                wordBreak(
                    "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                    listOf(
                        "a",
                        "aa",
                        "aaa",
                        "aaaa",
                        "aaaaa",
                        "aaaaaa",
                        "aaaaaaa",
                        "aaaaaaaa",
                        "aaaaaaaaa",
                        "aaaaaaaaaa"
                    )
                )
            )
        }
    }
}