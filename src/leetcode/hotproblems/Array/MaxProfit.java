package leetcode.hotproblems.Array;

import java.util.*;

public class MaxProfit {
    /**
     * 普通查找(最low)
     * int minprice = Integer.MAX_VALUE;
     *         int maxprofit = 0;
     *         for (int i = 0; i < prices.length; i++) {
     *             if (prices[i] < minprice) {
     *                 minprice = prices[i];
     *             } else if (prices[i] - minprice > maxprofit) {
     *                 maxprofit = prices[i] - minprice;
     *             }
     *         }
     *         return maxprofit;
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {


    return 0;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,4,1};
        int i = maxProfit(a);
        System.out.println(i);
    }
}
