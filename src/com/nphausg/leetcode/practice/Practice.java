package com.nphausg.leetcode.practice;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

/**
 * The following function prints the powers of 2 from 1 through n (inclusive).
 * For example, if n is 4, it would be print 1, 2, and 4.
 */
@RunWith(Enclosed.class)
public class Practice {

    public static int powerOf2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int prev = powerOf2(n / 2);
        return prev * 2;
    }

    // a ^ b
    public static int power(int a, int b) {
        if (b < 0) {
            return 0;
        }
        if (b == 0) {
            return 1;
        }
        return a * power(a, b - 1);
    }

    // a mod b
    public static int mod(int a, int b) {
        if (b < 0) {
            return -1;
        }
        int div = a / b;
        return a - div * b;
    }

    // a div b
    public static int div(int a, int b) {
        int count = 0;
        int sum = b;
        while (sum <= a) {
            sum += b;
            count++;
        }
        return count;
    }

    /*
     * Implement an algorithm to determine if a string has all unique characters. Wht if you cannot use additional data structure
     * 2 loops -> O(n^2)
     * */
    public static boolean isUnique(String s) {
        for (int i = 0; i < s.toCharArray().length - 1; i++) {
            for (int j = i + 1; j < s.toCharArray().length; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isUnique2(String s) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (set.contains(s.toCharArray()[i])) {
                return false;
            }
            set.add(s.charAt(i));
        }
        return true;
    }

    public static void permutation(String s) {
        for (int i = 0; i < s.toCharArray().length; i++) {

        }
    }

    public static void maxInArray(int[] array, int i) {
        if (array.length == 0) {
            // return array[0];
        }
    }

    public String mergeAlternately(String word1, String word2) {
        final int n = Math.min(word1.length(), word2.length());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; ++i) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));
        }

        return sb.append(word1.substring(n)).append(word2.substring(n)).toString();
    }

    public static class TestCase extends BaseTest {

        @org.junit.Test
        public void test() {

            System.out.println(powerOf2(3));
            System.out.println("2 ^ 3 = " + power(2, 3));
            System.out.println("9 mod 2 = " + mod(9, 2));
            System.out.println("9 div 2 = " + div(9, 2));
            //
            System.out.println("is 44 unique = " + isUnique("44"));
            System.out.println("is 117 unique = " + isUnique("117"));
            System.out.println("is 132 unique = " + isUnique("132"));
            //
            System.out.println("is 44 unique = " + isUnique2("44"));
            System.out.println("is 117 unique = " + isUnique2("117"));
            System.out.println("is 132 unique = " + isUnique2("132"));
            //
            System.out.println("is `abcd10jk` unique = " + isUnique2("abcd10jk"));
            System.out.println("is `hutg9mnd!nk9` unique = " + isUnique2("hutg9mnd!nk9"));
        }
    }
}
