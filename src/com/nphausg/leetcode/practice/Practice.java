package com.nphausg.leetcode.practice;

/**
 * The following function prints the powers of 2 from 1 through n (inclusive).
 * For example, if n is 4, it would be print 1, 2, and 4.
 */
public class Practice {

    public static int powerOf2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n == 1) {
            System.out.println(1);
            return 1;
        }
        int prev = powerOf2(n / 2);
        int curr = prev * 2;
        System.out.println(curr);
        return curr;
    }
}
