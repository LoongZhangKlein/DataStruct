package datastructure.LinkedList.circlelinked;

public class Node {
     Node next;
     int data;
     Node(int data){
        this.data=data;

    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}
