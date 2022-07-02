package leetcode;

import java.util.Arrays;

public class Day06 {
    public static int[] twoSum(int[] nums, int target) {
        
        int left = 0;
        int end = nums.length - 1;
        while (left < end) {
            if (nums[left]+nums[end]==target){
                return new int[]{left+1,end+1};
            }else if (nums[left]+nums[end]<target){
                left++;
            }else {
                end--;
            }
        }
        return new int[]{-1,-1};

    }

    public static void main(String[] args) {
        int[] a=new int[]{3,2,4};
        int[] ints = twoSum(a, 6);
        System.out.println(Arrays.toString(ints));

    }
}
