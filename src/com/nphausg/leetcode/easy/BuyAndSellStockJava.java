package com.nphausg.leetcode.easy;

import com.nphausg.leetcode.config.BaseTest;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock">Buy and Sell stock </a>
 */
@RunWith(Enclosed.class)
public class BuyAndSellStockJava {

    // Brute-force
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int price = prices[j] - prices[i];
                if (price > max) {
                    max = price;
                }
            }
        }
        return max;
    }

    public static int maxProfit2(int[] prices) {
        int maxProfit = 0, minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                int profit = price - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }
        return maxProfit;
    }

    public static class TestCases extends BaseTest {

        @org.junit.Test
        public void testCases() {
            assertEquals(5, maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        }
    }
}
