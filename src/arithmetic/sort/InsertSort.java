package arithmetic.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] num = new int[80000];
        for (int i = 0; i < 80000; i++) {
            num[i]=(int)(Math.random()*8000000);
        }
        // 第一遍
       /* int[] num=new int[]{24,1,8,26,233,10};*/
        long l = System.currentTimeMillis();
        for (int i = 1; i <num.length; i++) {
            int insertValue=num[i];
            int insertIndex=i-1;
            while(insertIndex>=0&&insertValue<num[insertIndex]){
                num[insertIndex+1]=num[insertIndex];
                insertIndex--;
            }
            num[insertIndex+1]=insertValue;
        }

        /*// 第二遍
         insertValue=num[2];
         insertIndex=2-1;
        while(insertIndex>=0&&insertValue<num[insertIndex]){
            num[insertIndex+1]=num[insertIndex];
            insertIndex--;
        }
        num[insertIndex+1]=insertValue;*/
        System.out.println(System.currentTimeMillis()-l);
    }
}
