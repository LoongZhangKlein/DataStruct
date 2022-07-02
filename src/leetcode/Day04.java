package leetcode;

import java.util.Arrays;

public class Day04 {
    /**
     * 有序数组的平方
     * @param nums
     * @return
     */
    public static int[] sortedSquaresMine(int[] nums) {
        int[] newNums=new int[nums.length];
        for (int i=0;i<nums.length;i++){
            newNums[i]=nums[i]*nums[i];
        }
        Arrays.sort(newNums);
    return newNums;
    }

    /**
     * 双指针算法(归并排序)
     * @param nums
     * @return
     */
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int negative = -1;
        for (int i = 0; i < n; ++i) {
            if (nums[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        // 头   负数下标标记 尾 n就是数组的长度
        int index = 0, i = negative, j = negative + 1;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = nums[j] * nums[j];
                ++j;
            } else if (j == n) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else if (nums[i] * nums[i] < nums[j] * nums[j]) {
                ans[index] = nums[i] * nums[i];
                --i;
            } else {
                ans[index] = nums[j] * nums[j];
                ++j;
            }
            ++index;
        }

        return ans;
    }

    public static void moveZeroes(int[] nums) {
        int start=0;
        int end=start+1;
        while (end!=nums.length-1){
            if (nums[end]>nums[start]){
                int mid=0;
                mid=nums[start];
                start=nums[end];
                end=mid;
                ++start;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums={-4,-1,0,3,10};
        int[] ints = sortedSquares(nums);
        System.out.println(Arrays.toString(ints));
    }
}
