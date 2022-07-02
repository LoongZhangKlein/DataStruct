package collection.MyLinkList;

import java.util.*;

public class MyLinkList<E> extends AbstractSequentialList<E> implements java.io.Serializable {

    private Link<E> first;
    private Link<E> last;
    private int size;


    @Override
    public int size() {
        return size;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    // 检查链表是否为空
    @Override
    public boolean isEmpty() {
        return (first == null);
    }

    // 尾插入法
    @Override
    public boolean add(Object obj) {
        Link<E> lastLink = last;
        Link<E> newNode = new Link(obj, lastLink, null);
        last = newNode;
        if (isEmpty()) {
            first = newNode;
        } else {
            lastLink.next = newNode;
        }
        size++;
        return true;
    }

    // 中间插入
    @Override
    public void add(int index, Object obj) {
        if (!position(index)) {
            System.out.println("下标越界");
        }
        if (index == size) {
            add(obj);
        } else {
            // 寻找元素
            Link last = search(index);
            Link before = last.previous;
            Link newLink = new Link(obj, before, last);
            before.next = newLink;
            last.previous = newLink;
            size++;
        }

    }


    /**
     * todo
     */
    @Override
    public boolean addAll(Collection<? extends E> c) {
        System.out.println("调用了addAll");
        Object[] objects = c.toArray();
        for(E res:c){
            System.out.println(res);
        }

        return false;
    }

    @Override
    public boolean remove(Object obj) {
        Link<E> temp = first;
        int count = 0;
        if (count < size) {
            while (count < size && temp.e != obj) {
                temp = temp.next;
                count++;
            }
        } else {
            return false;
        }
        unLink(count);
        return true;
    }

    @Override
    public E remove(int index) {
        E e = unLink(index);
        return e;
    }

    public E remove() {
        Link<E> temp = first;
        E removeElementData = temp.e;
        if (temp == null) {
            System.out.println("链表为空");
        } else {
            Link<E> next = first.next;
            first.e = null;
            first = next;
        }
        return removeElementData;
    }

    @Override
    public E set(int index, Object object) {
        Link<E> search = search(index);
        E oldValue = search.e;
        search.e = (E) object;
        return oldValue;
    }

    private E unLink(int index) {
        Link<E> search = search(index);
        Link<E> pre = search.previous;
        Link<E> next = search.next;
        /**
         * 以下参照源码
         */
        if (pre == null) {
            first = next;
        } else {
            pre.next = next;
            search.previous = null;
        }
        if (next == null) {
            last = pre;
        } else {
            // 嘿嘿  源码那样写是有原因的  虽然在效果看似相同
            // pre.next=next;
            next.previous = pre;
            search.previous = null;
        }
        E removeElement = search.e;
        search.e = null;
        size--;
        return removeElement;
    }

    private boolean position(int index) {
        return index >= 0 && index <= size;
    }

    private Link search(int index) {
        if (index < size >> 1) {
            Link link = first;
            for (int i = 0; i < index; i++) {
                link = link.next;
            }
            return link;
        } else {
            Link link = last;
            for (int i = size - 1; i > index; i--) {
                link = link.previous;
            }
            return link;
        }
    }

    // 打印集合
    private void displayForward() {
        if (first == null) {
            System.out.println("[]");
            return;
        }

        Link current = first;
        System.out.print("[");
        while (current != null) {
            if (current.next == null) {
                System.out.print(current.e);
            } else {
                System.out.print(current.e + ",");
            }
            current = current.next;
        }
        System.out.print("]");
    }

    public MyLinkList() {
        /*first = null;
        last = first;*/
    }

    public MyLinkList(Collection<? extends E> c) {
        this();
        addAll(c);
    }

    @Override
    public String toString() {
        displayForward();
        return "";
    }
}
