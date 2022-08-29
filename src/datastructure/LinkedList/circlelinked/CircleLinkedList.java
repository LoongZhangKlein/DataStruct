package datastructure.LinkedList.circlelinked;

public class CircleLinkedList {
    private Node first =null;
    public void add(int data){
        if (data<1){
            System.out.println("null");
            return;
        }
        Node curBoy=null;
        for (int i = 1; i <=data; i++) {
            Node boy = new Node(i);
            if (i==1){
                first=boy;
                first.next=first;
                curBoy=first;
            }else{
                curBoy.setNext(first);
                curBoy=boy;
            }

        }

    }
    public void display(){
        if (first==null){
            System.out.println("为空");

        }
        Node curBoy=first;
        while(true){
            System.out.println("编号"+curBoy.getData());
            if (curBoy.getNext()==first){
                break;
            }
            curBoy=curBoy.next;
        }
    }
}
