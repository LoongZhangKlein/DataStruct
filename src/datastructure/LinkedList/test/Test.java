package datastructure.LinkedList.test;


import datastructure.LinkedList.singlelinked.NodeOrder;
import datastructure.LinkedList.singlelinked.SLinkedOrder;
import datastructure.LinkedList.singlelinked.SingleLinked;


public class Test {
    static void linkOrder(){
        SLinkedOrder sLinkedOrder = new SLinkedOrder();
        sLinkedOrder.add(4,"我");
        sLinkedOrder.add(1,"你");
        sLinkedOrder.add(3,"他");
        sLinkedOrder.add(6,"她");
        sLinkedOrder.add(7,"它");
        sLinkedOrder.add(9,"闼");
        sLinkedOrder.display();
        sLinkedOrder.reverse();
        System.out.println("=============");
        sLinkedOrder.display();
    }
    static void singleLinked(){
        SingleLinked singleLinked = new SingleLinked();
        singleLinked.add("斗");
        singleLinked.add("破");
        singleLinked.add("苍");
        singleLinked.add("穹");
        singleLinked.display();
        singleLinked.reversePrint();
    }
    public static void main(String[] args) {
        //linkOrder();
        singleLinked();
    }
}
