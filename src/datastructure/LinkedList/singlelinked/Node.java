package datastructure.LinkedList.singlelinked;

public class Node {
    public Object data;
    public Node next;
    public Node(Object data,Node next){
        this.data=data;
        this.next=next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
