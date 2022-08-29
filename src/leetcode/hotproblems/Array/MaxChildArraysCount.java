package leetcode.hotproblems.Array;

import java.util.*;

/**
 * T53
 */
public class MaxChildArraysCount {
    // method one the problem is storage out
    public static int maxSubArray(int[] nums) {
        List<Integer> list = new ArrayList();
        // 一次循环 -2开头所有数组
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                sum +=nums[j];
                list.add(sum);
            }
            sum=0;

        }
        System.out.println(list.toString());
        int max=list.get(0);
        for (Integer res : list) {
            if (res>max){
                max=res;
            }
        }
        return max;
    }

    /**
     * 动态规划方法
     * @param nums
     * @return
     */
    public static int maxSubArrayOne(int[] nums) {
        int len = nums.length;
        // dp[i] 表示：以 nums[i] 结尾的连续子数组的最大和
        int[] dp = new int[len];
        dp[0] = nums[0];

        for (int i = 1; i < len; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }
        }

        // 也可以在上面遍历的同时求出 res 的最大值，这里我们为了语义清晰分开写，大家可以自行选择
        int res = dp[0];
        for (int i = 1; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] a=new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int i = maxSubArrayOne(a);
        System.out.println(i);
    }
}
