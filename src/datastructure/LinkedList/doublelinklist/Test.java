package datastructure.LinkedList.doublelinklist;

import java.util.Arrays;
import java.util.LinkedList;

public class Test {
    public static void linkList() {
        LinkedList link = new LinkedList();
        link.add(0, "我");
        link.add(1, "你");





        System.out.println(link);
    }
    public static void myList() {
        MyLinkedList list = new MyLinkedList();
        list.add(0, "我");
        list.add(1, "ni");
        list.add(2, "ta");
        list.set(1,"倪");
        list.display();
    }

    public static void main(String[] args) {
         myList();
        //System.out.println("============");
        //linkList();
    }
}
