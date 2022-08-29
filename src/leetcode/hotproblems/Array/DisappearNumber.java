package leetcode.hotproblems.Array;

import java.util.*;

public class DisappearNumber {
    /*public static List<Integer> findDisappearedNumbers(int[] nums) {

        ArrayList list = new ArrayList();
        for (int res:nums) {
            list.add(res);
        }

        System.out.println(Arrays.toString(nums));
        System.out.println(list.indexOf(4));
        int len=nums.length;
        ArrayList list1 = new ArrayList();
        for (int i = 1; i < len+1; i++) {
            if (!list.contains(i)){
                list1.add(i);
            }

        }
        return list1;
    }*/
    public  static List<Integer> findDisappearedNumbers(int[] nums) {
       /* ArrayList list = new ArrayList();
        HashMap map = new HashMap();

        for (int res:nums) {
            map.put(res,1);
        }
        for (int i = 1; i < nums.length+1; i++) {
            if (map.get(i)==null){
                list.add(i);
            }
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return list;*/
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int num=Math.abs(nums[i])-1;
            nums[num]=-Math.abs(nums[num]);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>0){
                result.add(i+1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a=new int[]{4,3,2,7,8,2,3,1};
        List<Integer> disappearedNumbers = findDisappearedNumbers(a);
        System.out.println(disappearedNumbers.toString());
      /*  List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        int i = list.indexOf(2);
        System.out.println(i);*/
    }
}
