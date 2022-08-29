package datastructure.LinkedList.singlelinked;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.Stack;

public class SingleLinked {
    private Node head;
    private Node pop;

    public SingleLinked() {
        this.head = new Node(null, null);
    }

    public SingleLinked(Node node) {
        this.head = node;
    }

    public void add(Object obj) {
        if (obj == null) {
            throw new RuntimeException("添加为空");
        }
        Node node = new Node(obj, null);
        Node temp = head;
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }
    public void reversePrint(){
        // 没有加上判空条件  哈哈真二
        if(head.next==null){
            return;
        }
        Node cur=head.next;
        Stack stack = new Stack();
        while (cur!=null){
            stack.add(cur);
            cur=cur.next;
        }
        while (!stack.empty()){
            Node pop = (Node) stack.pop();
            System.out.println(pop.data);
        }
    }
    public void remove(Object obj) {
        //if (obj==null){}
        Node temp = head;
        // 修改逻辑漏洞
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                throw new RuntimeException("链表为空");
            }
            if (temp.next.data == obj) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            Node remove = temp.next;
            temp.next = temp.next.next;
            remove = null;
            System.out.println(temp.data);
        } else {
            System.out.println("未找到钙元素");
        }

    }

    public void reverse() {
        if (head.next == null || head.next.next == null) {
            return;
        }
        Node cur=head.next;
        Node next=null;
        Node reverseHead=new Node(null,null);
        while (cur!=null){
            next=cur.next;
            cur.next=reverseHead.next;
            reverseHead.next=cur;
            cur=next;
        }
        head.next=reverseHead.next;

    }

    public void display() {
        Node temp = head;
        System.out.print("[");
        while (temp.next != null) {
            if (temp.next.next == null) {
                System.out.print(temp.next.data);
            } else {
                System.out.print(temp.next.data + ",");
            }
            temp = temp.next;
        }
        System.out.println("]");
    }
}
