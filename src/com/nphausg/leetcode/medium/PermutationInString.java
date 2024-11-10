package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/permutation-in-string">567. Permutation in String</a>
 */
public class PermutationInString {
    public static boolean checkInclusion(String s1, String s2) {
        return false;
    }

    public static class PermutationInStringTest extends BaseTest {

        @org.junit.Test
        public void testCases() {
            /*
                Example 1:
                Input: s1 = "ab", s2 = "eidbaooo"
                Output: true
                Explanation: s2 contains one permutation of s1 ("ba").
            */
            /*
                Example 2:
                Input: s1 = "ab", s2 = "eidboaoo"
                Output: false
            */
            assertEquals(true, checkInclusion("ab", "eidbaooo"));
            assertEquals(false, checkInclusion("ab", "eidboaoo"));
        }
    }
}
