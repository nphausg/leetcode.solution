package com.nphausg.leetcode.hard;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/count-anagrams">2514. Count Anagrams</a>
 */
@RunWith(Enclosed.class)
public class CountAnagrams {

    static final int MOD = 1_000_000_007;

    public static int countAnagrams(String s) {
        // Split input string into words
        String[] words = s.split(" ");
        // Precompute factorials and modular inverses
        int maxLen = 0;
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }
        long[] fact = new long[maxLen + 1];
        long[] invFact = new long[maxLen + 1];
        precomputeFactorials(fact, invFact, maxLen);

        long result = 1;
        for (String word : words) {
            result = (result * countAnagramsForWord(word, fact, invFact)) % MOD;
        }

        return (int) result;
    }

    private static void precomputeFactorials(long[] fact, long[] invFact, int n) {
        fact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i % MOD;
        }
        invFact[n] = modInverse(fact[n], MOD);
        for (int i = n - 1; i >= 0; i--) {
            invFact[i] = invFact[i + 1] * (i + 1) % MOD;
        }
    }

    private static long modInverse(long x, int mod) {
        return modExp(x, mod - 2, mod);
    }

    private static long modExp(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }

    private static long countAnagramsForWord(String word, long[] fact, long[] invFact) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) {
            freq[c - 'a']++;
        }

        long numerator = fact[word.length()];
        long denominator = 1;
        for (int count : freq) {
            if (count > 0) {
                denominator = denominator * invFact[count] % MOD;
            }
        }
        return numerator * denominator % MOD;
    }

    public static class TestCases extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(1, countAnagrams("aa"));
            // Some of the anagrams of the given string are "too hot", "oot hot", "oto toh", "too toh", and "too oht".
            assertEquals(18, countAnagrams("too hot"));
        }
    }
}
