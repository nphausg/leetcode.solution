package com.nphausg.leetcode.medium;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
/**
 * <a href="https://leetcode.com/problems/convert-to-base-2">1017. Convert to Base -2</a>
 */
@RunWith(Enclosed.class)
public class LC1017ConvertToBaseMinus2 {
    public static String baseNeg2(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            int remainder = n % -2;
            n /= -2;
            if (remainder < 0) {
                remainder += 2;
                n += 1;
            }
            result.append(remainder);
        }
        return result.reverse().toString();
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals("110", baseNeg2(2));
            assertEquals("111", baseNeg2(3));
            assertEquals("100", baseNeg2(4));
        }
    }
}
