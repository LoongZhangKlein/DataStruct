package collection.Link;

import java.util.Collection;

public class SingleLink<E> {
    private final Node head = new Node(null);
    private int size;

    // 直接在尾部添加
    public void add(E e) {
        Node<E> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        Node node = new Node(e);
        temp.next = node;
        size++;
    }

    // 在元素中间添加
    public void add(int index, E e) {
        if (!position(index)) {
            System.out.println("下标越界");
        }
        if (index == size) {
            add(e);
        } else {
            // 在元素中间插入
            addBefore(index, e);
        }

    }

    public void addAll(Collection<? extends E> collection) {
        System.out.println(collection);

    }

    public void remove() {
        Node<E> temp = head;
        head.next = temp.next.next;
    }

    public boolean remove(Object object) {
        Node<E> temp = head;
        int count = 0;
        if (count>size){
            while (temp.e != object) {
                temp = temp.next;
                count++;
            }
        }else {
            return false;
        }
        Node<E> searchBefore = search(count, true);
        searchBefore.next = temp.next;
        size--;
        return true;
    }

    public void remove(int index) {
        position(index);
        Node<E> temp = head;
        Node<E> searchBefore = search(index, true);
        searchBefore.next = temp.next;
        size--;
    }


    public void addBefore(int index, E e) {
        Node<E> lastNode = search(index, false);
        Node<E> node = new Node(e);
        node.next = lastNode.next;
        lastNode.next = node;
        size++;
    }
    public Object get(int index) {
        Node<E> search = search(index, false);
        return search.next.e;
    }
    private Node<E> search(int index, boolean flag) {
        position(index);
        Node<E> temp = head;
        // true 代表搜索到index-1,否则搜索到index
        if (flag) {
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
        } else {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }

        return temp;
    }


    private boolean position(int index) {
        // 在范围返回true
        return index >= 0 && index <= size;
    }

    public int size() {
        return size;
    }

    public void getAll() {
        Node<E> temp = head.next;
        System.out.print("[");
        while (temp != null) {
            if (temp.next == null) {
                System.out.print(temp.e + "]");
            } else {
                System.out.print(temp.e + ",");
            }

            temp = temp.next;
        }
        System.out.println();
    }

}
