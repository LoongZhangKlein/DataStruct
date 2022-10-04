package datastructure.LinkedList.singlelinked;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.Stack;

public class SingleLinked {
    private Node head;
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

    /**
     *单链表的翻转
     */
    public void reverse() {
        // 链表为空或者当前链表只有一个元素 不用翻转
        if (head.next == null || head.next.next == null) {
            return;
        }
        // 标记头指针
        Node cur=head.next;
        // 设置辅助指针
        Node next=null;
        //
        Node reverseHead=new Node(null,null);
        while (cur!=null){
            // 标记出下边要执行的节点
            next=cur.next;
            /**
             * 刚开始以为反转操作是在reverseHead这条新建链表中其实是在原先的链表上
             * reverseHead这条新建链表是辅助链表  进入误区了
             *
             * 以翻转1.2.3为例
             * 当第一次执行时,翻转链表的next为空,cur.next为2,执行完cur.next=reverseHead.next后 cur链表变为1,
             * 执行reverseHead.next=cur;后,reverseHead链表为1继续向下执行
             * cur=next; 这时cur链表为2->3
             * 在执行next=cur.next; 这是next为3
             *  reverseHead.next为1,cur.next为3,这是执行cur.next=reverseHead.next;
             *  cur链表为2->1;执行reverseHead.next=cur后,reverseHead链表为2->1
             *  cur=next; 此时cur链表只剩3
             *  cur.next=null, next=cur.next后 next为null
             *  reverseHead.next为2(->1),执行cur.next=reverseHead.next;后cur链表变为3->2->1
             *   reverseHead.next=cur;后 reversehead链表为3->2->1
             *   cur=next(此时next为null)循环终止
             */
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
