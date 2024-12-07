/**
 * Created by nphau on 09/12/2021, 00:30
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 09/12/2021, 15:54
 */

package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

/**
 * 91. Decode Ways
 * <a href="https://leetcode.com/problems/decode-ways/">...</a>
 */
@RunWith(Enclosed.class)
public class DecodeWays {

    public static int numDecodings(String s) {
        if (s.isEmpty())
            return 0;
        int n = s.length();

        int[] dp = new int[n + 1];
        dp[n] = 1;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i + 1];

                if (i < n - 1) {
                    int temp = Integer.parseInt(s.substring(i, i + 2));
                    if (temp <= 26) dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {

        }
    }
}
