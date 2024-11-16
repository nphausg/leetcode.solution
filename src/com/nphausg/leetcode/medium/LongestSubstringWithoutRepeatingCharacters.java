package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;

import java.util.HashMap;
import java.util.HashSet;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    // Approach 2
    public static int lengthOfLongestSubstring2(String s) {
        int left = 0, right = 0, maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left + 1);
                right++;
            } else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return maxLength;
    }

    // Approach 3
    public static int lengthOfLongestSubstring3(String s) {
        int left = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)) {
                left = Math.max(map.get(ch) + 1, left);
            }
            map.put(ch, right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }

    // Approach 4
    public static int lengthOfLongestSubstring4(String s) {
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
            /*
              Example 1:
              Input: s = "abcabcbb"
              Output: 3
              Explanation: The answer is "abc", with the length of 3.
             */
            assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring3("abcabcbb"));
            /*
                Example 2:
                Input: s = "bbbbb"
                Output: 1
                Explanation: The answer is "b", with the length of 1.
            */
            assertEquals(1, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring3("bbbbb"));

            /*
                Example 3:
                Input: s = "pwwkew"
                Output: 3
                Explanation: The answer is "wke", with the length of 3.
                Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
            */
            assertEquals(3, LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring3("pwwkew"));
        }
    }
}