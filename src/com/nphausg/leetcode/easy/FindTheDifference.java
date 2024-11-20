package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/find-the-difference">389. Find the Difference</a>
 */
public class FindTheDifference {

    public static char findTheDifference2(String s, String t) {
        char result = 0;
        for (char c : s.toCharArray()) {
            result ^= c;
        }
        for (char c : t.toCharArray()) {
            result ^= c;
        }
        return result;
    }

    public static char findTheDifference(String s, String t) {
        int n1 = s.length(), n2 = t.length();
        HashMap<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c)) {
                return c;
            }
        }
        return 0;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals('e', findTheDifference2("a", "aa"));
            assertEquals('y', findTheDifference2("", "y"));
            assertEquals('y', findTheDifference2("", "y"));
        }
    }
}
