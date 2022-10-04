package datastructure.LinkedList.singlelinked;

public class Test {
    static void singleLinked(){
        SingleLinked singleLinked = new SingleLinked();
        singleLinked.add(1);
        singleLinked.add(2);
        singleLinked.add(3);
        singleLinked.display();
        singleLinked.reverse();
        singleLinked.display();
    }
    static void sLinkedOrder(){
        SLinkedOrder sLinkedOrder = new SLinkedOrder();
        sLinkedOrder.add(1,"广东");
        sLinkedOrder.add(2,"深圳");
        sLinkedOrder.add(3,"上海");
        sLinkedOrder.display();
        sLinkedOrder.reverse();
        sLinkedOrder.display();
    }
    public static void main(String[] args) {
        sLinkedOrder();
        //singleLinked();
    }
}
