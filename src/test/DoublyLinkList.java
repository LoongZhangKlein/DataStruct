package test;

public class DoublyLinkList {
    private Link first;
    private Link last;

    public DoublyLinkList() {
        first = null;
        last = first;
    }



    //尾部插入
    public void insertLast(int data) {
        Link newNode = new Link(data);
        if(isEmpty()) {
            first = newNode;		//若链表为空，则将first指向新的结点（newNode）
        }else {
            newNode.previous = last;//将last的previous指向last（last永远指向的是最后一个结点）【此时还没有插入新的结点newNode，所以last指向的是当前链表的最后一个结点】
            last.next = newNode;	//将last.next(当前链表最后一个结点的next域)指向新的结点newNode
        }
        last = newNode;				//由于插入了一个新的结点，又因为是尾部插入，所以将last指向newNode
    }
    //检查链表是否为空
    public boolean isEmpty() {
        return (first==null);

    }
    //从头部开始演绎
    public void displayForward() {
        System.out.print("List(first--->last): ");
        Link current = first;
        while(current!=null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }


}
