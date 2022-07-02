package collection.MyLinkList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;

public class Test {
    public static void testSingleList() {
        SingleLink singleLink = new SingleLink();


    }

    public static void test() {
        LinkedList list = new LinkedList();
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        list.addAll(list);
        list.set(0,6);
        System.out.println(list);



    }

    public static void testMyLinkList() {
        MyLinkList list = new MyLinkList();
        list.add(0,"0");
        list.add(1,"1");
        list.add(2,"1");
        list.addAll(list);



    }


    public static void main(String[] args) {

        /*System.out.println("linkList的执行秒数");
        test();*/
        /*testMyLinkListTwo();*/
        testMyLinkList();


    }
}
