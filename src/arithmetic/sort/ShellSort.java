package arithmetic.sort;

import java.util.Arrays;

public class ShellSort {
    /**
     * 交换实现法
     * @param arr
     */
    public static void  shellSort(int[] arr){
        //该处循环执行每次分组数目  第一次就应该除以二
        int temp=0;
        for (int gap = arr.length/2; gap>0 ; gap/=2) {
            // 这里的for循环是执行分组
            for (int i = gap; i <arr.length; i++) {
                // 此处为j-=5 是为了保证该for循环只执行一次
                for (int j=i-gap;j>=0;j-=gap){
                    if (arr[j]>arr[j+gap]){
                       temp =arr[j+gap];
                        arr[j+gap]=arr[j];
                        arr[j]=temp;
                    }
                }
            }
        }

    }

    public static void  shellSortMove(int[] arr){
        for (int gap = arr.length/2; gap>0 ; gap/=2) {
            for (int i = gap; i <arr.length ; i++) {
            int j=i;
            int temp=arr[j];
            while (j-gap>0&&temp<arr[j-gap]){
                arr[j]=arr[j-gap];
                j-=gap;
            }
            arr[j]=temp;
            }



        }

    }

    public static void main(String[] args) {
        int[] a = new int[800000];
        for (int i = 0; i < 800000; i++) {
            a[i]=(int)(Math.random()*80000);
        }
        long l = System.currentTimeMillis();
        shellSortMove(a);
        System.out.println(System.currentTimeMillis()-l);
        /*System.out.println(Arrays.toString(a));*/
    }
}
