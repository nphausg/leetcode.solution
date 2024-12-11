package com.nphausg.leetcode.practice;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import java.util.ArrayList;
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

    // Find the median of two sorted again
    //public static double median(int[] arr1, int[] arr2) {
    // [1, 2, 5]
    // [2, 4, 6]

    // }

    public static int missingNumber(int n, int[] array) {

        int[] hash = new int[n + 1];

        for (int i = 0; i < n - 1; i++) {
            hash[array[i]]++;
        }

        for (int i = 1; i <= n; i++) {
            if (hash[i] == 0) {
                return i;
            }
        }

        return -1;
    }

    public static int missingNumber2(int n, int[] array) {
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            sum += array[i];
        }
        return n * (n + 1) / 2 - sum;
    }

    public static int minChange(int amount, List<Integer> coins) {

        if (amount == 0) return 0;

        if (amount < 0) return -1;

        int minCoins = -1;
        for (int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minChange(subAmount, coins);
            if (subCoins != -1) {
                int numCoins = subCoins + 1;
                if (numCoins < minCoins || minCoins == -1) {
                    minCoins = numCoins;
                }
            }
        }

        return minCoins;
    }

    public static int minChange2(int amount, List<Integer> coins) {
        return minChange2(amount, coins, new HashMap<>());
    }

    public static int minChange2(int amount, List<Integer> coins, HashMap<Integer, Integer> memo) {

        if (amount == 0) return 0;

        if (amount < 0) return -1;

        if (memo.containsKey(amount)) {
            return memo.get(amount);
        }
        int minCoins = -1;
        for (int coin : coins) {
            int subAmount = amount - coin;
            int subCoins = minChange(subAmount, coins);
            if (subCoins != -1) {
                int numCoins = subCoins + 1;
                if (numCoins < minCoins || minCoins == -1) {
                    minCoins = numCoins;
                }
            }
        }
        memo.put(amount, minCoins);
        return minCoins;
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
            //
            //median(new int[]{1, 2, 3, 4, 5, 6}, new int[]{0, 0, 0, 0, 10, 10});
            // Missing number
            assertEquals(2, missingNumber(5, new int[]{1, 3, 4, 5}));
            assertEquals(4, missingNumber(5, new int[]{1, 2, 3, 5}));
            assertEquals(5, missingNumber(8, new int[]{1, 2, 4, 6, 3, 7, 8}));
            assertEquals(2, missingNumber2(5, new int[]{1, 3, 4, 5}));
            assertEquals(4, missingNumber2(5, new int[]{1, 2, 3, 5}));
            assertEquals(5, missingNumber2(8, new int[]{1, 2, 4, 6, 3, 7, 8}));
        }
    }
}
