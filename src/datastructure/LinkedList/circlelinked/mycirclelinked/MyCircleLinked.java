package datastructure.LinkedList.circlelinked.mycirclelinked;

public class MyCircleLinked {
    private Node first;
    private int count;
    // 初始化时应该形成环
    public MyCircleLinked(){
        first=new Node(null);
        first.next=first;
    }
    public boolean isEmpty(){
        if (first.next==first){
            return true;
        }
        return false;
    }
    private Node findLast(){
        Node temp=first;
        while (true){
            if (temp.next==first){
                return temp;
            }else{
                temp=temp.next;
            }
        }
    }
    public void add(Object obj){
        Node node=new Node(obj);
        // 找到链表尾部元素
        Node last = findLast();
        last.next=node;
        node.next=first;
        count++;
    }
    public void pop(int position,int interval){
        if (interval<1){
            throw new RuntimeException("输入异常");
        }
        // 找到开始报数的位置
        Node temp=first.next;
        for (int i = 0; i < position; i++) {
            temp=temp.next;
        }
        for (int i = 1; i < 6; i++) {
            // 间隔n个
            Node current=temp;
            for (int j = 1; j < interval; j++) {
                temp=temp.next;
            }
            // 移除出链元素
            current.next=temp.next;
            System.out.println(temp.data);
            temp=temp.next;

        }


    }
    public int size(){
        return count;
    }
    public void display(){
        if (isEmpty()){
            throw new RuntimeException("连表为空");
        }
        Node temp=first.next;
        while (temp!=first){
            System.out.print(temp.data+"--");
            temp=temp.next;
        }
    }
}
