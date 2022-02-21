/**
 * Created by nphau on 09/12/2021, 00:30
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 09/12/2021, 15:54
 */
package sg.nphau.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number
 */
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
}
