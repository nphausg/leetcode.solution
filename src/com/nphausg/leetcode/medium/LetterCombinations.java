/**
 * Created by nphau on 09/12/2021, 00:30
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 09/12/2021, 15:54
 */
package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * <a href="https://leetcode.com/problems/letter-combinations-of-a-phone-number">...</a>
 */
@RunWith(Enclosed.class)
public class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return Collections.emptyList();
        }
        String ans = "";
        String[] n = {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};
        return letter(digits, ans, n);
    }

    public List<String> letter(String a, String ans, String[] n) {
        List<String> list = new ArrayList<>();
        if (a.isEmpty()) {
            list.add(ans);
            return list;
        }
        int s = a.charAt(0) - '0';
        for (int i = 0; i < n[s].length(); i++) {
            list.addAll(letter(a.substring(1), ans + n[s].charAt(i), n));
        }
        return list;
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {

        }
    }
}
