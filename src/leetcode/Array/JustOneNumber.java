package leetcode.Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class JustOneNumber {
    public static int singleNumber(int[] nums) {
        int reduce = 0;
        for (int num : nums) {
            reduce =  reduce ^ num;
        }
        return reduce;
    }
    public static void main(String[] args) {
        int[] ints = new int[]{4,1,2,1,2};
        int i = singleNumber(ints);
        System.out.println(i);
    }
}
