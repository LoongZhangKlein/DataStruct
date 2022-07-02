package arithmetic.sort;

import java.util.Arrays;

/**
 * @author DragonZhang
 */

public class ChooseSort {
    public static void chooseSort(int[] num) {
        //时间复杂对为O(n^2)
        // 此处从0开始 执行的次数应该减去一

        for (int j = 0; j < num.length - 1; j++) {
            //此处记录下标志
            int minIndex = j;
            // 记录对应下表数值
            int min = num[j];
            for (int i = j + 1; i < num.length; i++) {
                // 从大到小 从小到大的开关
                if (min > num[i]) {
                    minIndex = i;
                    min = num[i];
                }
            }
            // 交换最小值
            num[minIndex] = num[j];
            num[j] = min;

        }

    }


    public static void main(String[] args) {
        int[] a = new int[80000];
        for (int i = 0; i < 80000; i++) {
            a[i]=(int)(Math.random()*8000000);
        }
        long l = System.currentTimeMillis();
        chooseSort(a);
        System.out.println(System.currentTimeMillis()-l);
    }
}
