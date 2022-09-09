package datastructure.LinkedList.doublelinklist;

public class Node {
    public Object data;
    public Node prev;
    public Node next;
    public Node(Node prev,Node next,Object data){
        this.prev=prev;
        this.next=next;
        this.data=data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", prev=" + prev +
                ", next=" + next +
                '}';
    }
}
