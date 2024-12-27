package com.nphausg.leetcode.easy

import com.nphausg.leetcode.config.BaseTest
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.experimental.runners.Enclosed
import org.junit.runner.RunWith

@RunWith(Enclosed::class)
class ValidPalindromeKt {
    fun isPalindrome(input: String): Boolean {
        val reversed = input.reversed()
        return input == reversed
    }

    inner class TestCase : BaseTest() {

        @Test
        fun testCases() {
            assertTrue(isPalindrome("A man, a plan, a canal: Panama"))
            assertFalse(isPalindrome("race a car"))
        }
    }
}
