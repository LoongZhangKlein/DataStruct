package collection.MyLinkList;

import java.util.List;

public class Link<E> {
    public E e;
    public Link next;
    public Link previous;

    public Link(E e, Link previous, Link next) {
        this.e = e;
        this.previous = previous;
        this.next = next;
    }

    //打印结点的数据域
    public void displayLink() {
        System.out.print(e + ",");
    }

    @Override
    public String toString() {
        return e.toString();
    }
}
