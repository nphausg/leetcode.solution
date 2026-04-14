package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
/**
 * <a href="https://leetcode.com/problems/maximum-value-of-a-string-in-an-array">2496. Maximum Value of a String in an Array</a>
 */

@RunWith(Enclosed.class)
public class LC2496MaximumValueOfAStringInAnArray {

    public static int maximumValueStream(String[] strs) {
        return Arrays.stream(strs)
                .mapToInt(str -> str.chars().allMatch(Character::isDigit)
                        ? Integer.parseInt(str)
                        : str.length())
                .max()
                .orElse(0);
    }

    public static int maximumValue(String[] strs) {
        int maxValue = 0;
        for (String str : strs) {
            int value = 0;
            boolean isNumeric = true;

            // Check if all characters are digits
            for (char c : str.toCharArray()) {
                if (!Character.isDigit(c)) {
                    isNumeric = false;
                    break;
                }
            }

            // Compute value based on the type
            if (isNumeric) {
                value = Integer.parseInt(str);
            } else {
                value = str.length();
            }

            maxValue = Math.max(maxValue, value);
        }
        return maxValue;
    }

    public static int maximumValueWithRegex(String[] strs) {
        int maxValue = 0;
        for (String str : strs) {
            int value;
            if (str.matches("\\d+")) { // Check if the string contains only digits
                value = Integer.parseInt(str);
            } else {
                value = str.length(); // Otherwise, take the length of the string
            }
            maxValue = Math.max(maxValue, value);
        }
        return maxValue;
    }

    public static int maximumValue1(String[] strs) {
        int max = 0;
        for (String s : strs) {
            max = Math.max(max, helper(s));
        }
        return max;
    }

    public static int helper(String s) {
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c >= 'a' && c <= 'z') {
                return s.length();
            }
        }
        return Integer.parseInt(s);
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(5, maximumValue(new String[]{"alic3", "bob", "3", "4", "00000"}));
            assertEquals(1, maximumValue(new String[]{"1", "01", "001", "0001"}));
        }
    }
}
