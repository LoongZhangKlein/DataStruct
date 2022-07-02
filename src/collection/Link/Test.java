package collection.Link;

import java.util.Collection;
import java.util.LinkedList;

public class Test {
    public static void singleLink(){
        SingleLink link = new SingleLink();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 9000000; i++) {
            link.add(i,"布莱恩特");
        }

        System.out.println(System.currentTimeMillis()-l);
    }
    public static void Link(){
        LinkedList linkedList = new LinkedList();
        long l = System.currentTimeMillis();
        for (int i = 0; i < 90000; i++) {
            linkedList.add(i,"布莱恩特");
        }
        System.out.println(System.currentTimeMillis()-l);

    }
    public static void main(String[] args) {
       /*singleLink();*/
        System.out.println("单链表9000000执行速度");
    singleLink();

    }
}
