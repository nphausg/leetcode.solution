package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/first-unique-character-in-a-string">387. First Unique Character in a String</a>
 */
public class FirstUniqueCharacterInAString {

    public static int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static class FirstUniqueCharacterInAStringTest extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(0, firstUniqChar("leetcode"));
            assertEquals(2, firstUniqChar("loveleetcode"));
            assertEquals(-1, firstUniqChar("aabb"));
        }
    }
}
