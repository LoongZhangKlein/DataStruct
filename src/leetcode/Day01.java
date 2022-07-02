package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Day01 {

    public static int[] twoSum(int[] nums, int target) {
       /* Map<Integer,Integer> map=new HashMap<>(16);
        for (int i=0;i<nums.length;i++){
            map.put(i,nums[i]);
        }
        int head=0,tail=0;
        for (int i=0;i<nums.length;i++){
           head=map.get(i)-target;
           tail=i+1;
        }
        for (int i=0;i<nums.length;i++){
            if (map.get(i)==head){
                int[] result=new int[2];
                result[0]=i;
                result[1]=tail;

                return result;
            }
        }
        int[] a={};
        return a;
    }
*/

        // 官方正解
        int[] indexs = new int[2];
        // 建立k-v ，一一对应的哈希表
        HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>(16);
        for (int i = 0; i < nums.length; i++) {
            if (hash.containsKey(nums[i])) {
                indexs[0] = i;
                indexs[1] = hash.get(nums[i]);
                return indexs;
            }
            // 将数据存入 key为补数 ，value为下标
            hash.put(target - nums[i], i);
            /**
             * 两数之和
             * @param args
             */
        }
        return indexs;
    }



    public static void main(String[] args) {
        int[] array={2,7,11,15};
        int[] ints = twoSum(array, 9);
        for (int res:ints) {
            System.out.println(res);
        }

    }

}
