package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/permutation-in-string">567. Permutation in String</a>
 */
public class PermutationInString {

    private static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static boolean isPermutation(String s1, String s2) {
        int[] letters = new int[128];
        for (int i = 0; i < s1.length(); i++) {
            letters[s1.charAt(i)]++;
        }
        for (int i = 0; i < s2.length(); i++) {
            letters[s2.charAt(i)]--;
            if (letters[s2.charAt(i)] < 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        Map<Character, Integer> s1Map = new HashMap<>();
        Map<Character, Integer> s2Map = new HashMap<>();

        // Count the frequency of every char in s1
        for (char c : s1.toCharArray()) {
            s1Map.put(c, s1Map.getOrDefault(c, 0) + 1);
        }

        int windowSize = s1.length();

        // 1st window
        for (int i = 0; i < windowSize; i++) {
            char c = s2.charAt(i);
            s2Map.put(c, s2Map.getOrDefault(c,  0) + 1);
        }
        if(s1Map.equals(s2Map)) return true;
        for (int i = windowSize; i <s2.length(); i++) {
            char newChar = s2.charAt(i);
            char oldChar = s2.charAt(i - windowSize);
            // Add new char to window
            s2Map.put(newChar, s2Map.getOrDefault(newChar, 0) + 1);
            if(s2Map.get(oldChar) == 1){
                s2Map.remove(oldChar);
            }
            else{
                s2Map.put(oldChar, s2Map.get(oldChar) - 1);
            }
            if(s1Map.equals(s2Map)) return true;
        }
        return false;
    }

    public static boolean checkInclusion2(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int [] s1Freq = new int[26];
        int [] s2Freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }
        // 1st window
        int windowSize = s1.length();
        if(matches(s1Freq, s2Freq)) return true;
        // Slide
        for (int i = windowSize; i < s2.length(); i++){
            s2Freq[s2.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i - windowSize) - 'a']--;
            if(matches(s1Freq, s2Freq)) return true;
        }
        return false;
    }

    private static boolean matches(int[] s1Freq, int[] s2Freq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != s2Freq[i]) return false;
        }
        return true;
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
            assertEquals(true, checkInclusion2("ab", "eidbaooo"));
            assertEquals(false, checkInclusion2("ab", "eidboaoo"));
        }
    }
}
