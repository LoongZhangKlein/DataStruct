package collection.MyArraysList;

import java.util.*;

public class Test {

        public static void testArrays(){
            String[] str=new String[3];
            for (int i = 0; i < str.length; i++) {
                if (i%2==0){
                    str[i]="小王";
                }else {
                    str[i]="李四";
                }

            }


            String[] str1=new String[3];
            System.arraycopy(str,2,str,1,1);
            System.out.println(Arrays.toString(str));
        }




    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 90000; i++) {
            list.add("青春");
        }
        long l = System.currentTimeMillis();
        /*for (int i = list.size()-1; i >=0; i--) {
            list.remove(i);
        }*/
        System.out.println(list.size());
        for (int i = 0; i<90000-1; i++) {
            list.remove(i);
        }
        System.out.println(list.size());
        System.out.println(System.currentTimeMillis()-l);
        System.out.println(list.toString());

    }



}
