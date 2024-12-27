package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * <a href="https://leetcode.com/problems/valid-palindrome">125. Valid Palindrome</a>
 */
@RunWith(Enclosed.class)
public class ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertTrue(isPalindrome("A man, a plan, a canal: Panama"));
            assertFalse(isPalindrome("race a car"));
        }
    }
}
