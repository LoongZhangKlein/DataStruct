package test;

import java.util.Arrays;

public class Demo {
    public static int[] bubble(int[] arr) {
        // 由小到大排序
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a=new int[]{19,3,188,6,2,5,1214,-19};
        int[] bubble = bubble(a);
        System.out.println(Arrays.toString(bubble));
    }
}
