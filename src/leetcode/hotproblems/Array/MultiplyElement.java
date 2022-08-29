package leetcode.hotproblems.Array;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 */
public class MultiplyElement {
    /**
     * 最差解
     * @param nums
     * @return
     */
    public static int majorityElementOne(int[] nums) {
        int times=nums.length/2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num:nums) {
            if (map.get(num)==null){
                map.put(num,1);
            }else {
                map.put(num,map.get(num)+1);
            }
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            Integer   value= entry.getValue();
            if (value>times){
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     * 相对较好
     * @param nums
     * @return
     */
    public static int majorityElementTwo(int[] nums) {
        int times=nums.length/2;
        Arrays.sort(nums);
        int res=nums[0];
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==res){
                count+=1;
                if (count>times){
                    return res;
                }
            }else {
                res=nums[i];
                count=1;
            }
        }
        return -1;
    }

    /**
     * 新学一招
     * 前提 数组中一定有一个是多位数
     * 如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为 n/2​
     *  的元素（下标从 0 开始）一定是众数
     * @param nums
     * @return
     */
    public static int majorityElementThree(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];

    }
    public static void main(String[] args) {
       int[] nums = new int[]{2,2,1,1,1,2,2};
        int i = majorityElementThree(nums);
        System.out.println(i);
    }
}
