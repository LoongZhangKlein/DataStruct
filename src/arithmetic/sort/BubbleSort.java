package arithmetic.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums=new int[]{1,5,0,78,95,6,49};

        for (int i=0;i<nums.length-1;i++){
            for (int j=i+1;j<nums.length;j++){
                if (nums[i]>nums[j]){
                    int temp=nums[j];
                    nums[j]=nums[i];
                    nums[i]=temp;
                }

            }

        }
        System.out.println(Arrays.toString(nums));
    }

}
