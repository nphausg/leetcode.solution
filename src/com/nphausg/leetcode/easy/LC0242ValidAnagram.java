package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.HashMap;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * <a href="https://leetcode.com/problems/valid-anagram">242. Valid Anagram</a>
 */

@RunWith(Enclosed.class)
public class LC0242ValidAnagram {

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (mapS.containsKey(s.charAt(i))) {
                mapS.put(s.charAt(i), mapS.get(s.charAt(i)) + 1);
            } else {
                mapS.put(s.charAt(i), 1);
            }
            if (mapT.containsKey(t.charAt(i))) {
                mapT.put(t.charAt(i), mapT.get(t.charAt(i)) + 1);
            } else {
                mapT.put(t.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if (!mapT.containsKey(s.charAt(i))) {
                return false;
            } else {
                char c = t.charAt(i);
                if (!mapT.get(c).equals(mapS.get(c))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != t1[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagram(String s, String t) {
        // Check if both strings are of equal length
        if (s.length() != t.length()) {
            return false; // If not equal, they can't be anagrams
        }

        // Create an array to store the frequency of each letter
        int[] letterCount = new int[26];

        // Iterate over each character of both strings
        for (int i = 0; i < s.length(); i++) {
            // Increment the count for each letter in string s
            letterCount[s.charAt(i) - 'a']++;
            // Decrement the count for each letter in string t
            letterCount[t.charAt(i) - 'a']--;
        }

        // Check if all counts are zero, indicating anagrams
        for (int count : letterCount) {
            if (count != 0) {
                return false; // If any count is not zero, s and t are not anagrams
            }
        }

        // If all counts are zero,
        return true;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertFalse(isAnagram("a", "ab"));
            assertFalse(isAnagram("aacc", "ccac"));
            assertFalse(isAnagram("rat", "car"));
            assertTrue(isAnagram("anagram", "nagaram"));
        }
    }
}
