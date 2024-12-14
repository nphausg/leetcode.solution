package com.nphausg.leetcode.practice;

import java.util.HashMap;

public class SummingSquares {

    public static int summingSquares(int n) {
        return (int) summingSquaresHelper(n);
    }

    public static double summingSquaresHelper(int n) {
        if (n == 0) {
            return 0;
        }
        double minSquares = Double.POSITIVE_INFINITY;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int square = i * i;
            double numsSquares = 1 + summingSquaresHelper(n - square);
            if (numsSquares < minSquares) {
                minSquares = numsSquares;
            }
        }

        return minSquares;
    }

    public static double summingSquaresHelper2(int n, HashMap<Integer, Double> memo) {
        if (n == 0) {
            return 0;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        double minSquares = Double.POSITIVE_INFINITY;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int square = i * i;
            double numsSquares = 1 + summingSquaresHelper2(n - square, memo);
            if (numsSquares < minSquares) {
                minSquares = numsSquares;
            }
        }
        memo.put(n, minSquares);
        return minSquares;
    }
}
