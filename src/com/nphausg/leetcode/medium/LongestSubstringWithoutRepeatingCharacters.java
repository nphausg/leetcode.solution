package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import com.nphausg.leetcode.hard.ContainsDuplicate3;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        int maxLength = 0, left = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            left = Math.max(index[ch], left);
            maxLength = Math.max(maxLength, right - left + 1);
            index[ch] = right + 1;
        }

        return maxLength;
    }


    public static class LongestSubstringWithoutRepeatingCharactersTest extends BaseTest {

        @org.junit.Test
        public void testCases() {
//            Example 1:
//            Input: s = "abcabcbb"
//            Output: 3
//            Explanation: The answer is "abc", with the length of 3.

//            Example 2:
//            Input: s = "bbbbb"
//            Output: 1
//            Explanation: The answer is "b", with the length of 1.

//            Example 3:
//            Input: s = "pwwkew"
//            Output: 3
//            Explanation: The answer is "wke", with the length of 3.
//            Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
            assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcbb"));
            assertEquals(1, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("bbbbb"));
            assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwkew"));
        }
    }
}
