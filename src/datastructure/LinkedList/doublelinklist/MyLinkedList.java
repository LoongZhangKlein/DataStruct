package datastructure.LinkedList.doublelinklist;

/**
 * @author DragonZhang
 */
public class MyLinkedList {
    private Node head;
    private int countSize;

    public MyLinkedList() {
        this.head = new Node(null, null, null);
    }

    private void isEmpty() {
        if (head.next == null) {
            throw new RuntimeException("链表为空");
        }
    }

    private Node findIndex(int index) {
        if (index < 0 || index > countSize) {
            throw new RuntimeException("下标越界");
        }
        isEmpty();
        Node temp = head.next;
        int count = 0;
        while (true) {
            if (count == index) {
                return temp;
            } else {
                temp = temp.next;
                count++;
            }

        }
    }

    private Node findCurElement(Object obj) {
        isEmpty();
        Node temp = head.next;
        while (temp.data != obj) {
            temp = temp.next;
            if (temp == null) {
                throw new RuntimeException("未找到钙元素");
            }
        }
        return temp;
    }

    private Node findLastElement() {
        Node temp = head.next;
        isEmpty();
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 尾插法
     */
    private void lastAdd(Object obj) {
        Node cur = new Node(head, null, obj);
        if (head.next == null) {
            head.next = cur;
        } else {
            Node last = findLastElement();
            last.next = cur;
            cur.prev = last;
        }
    }

    public void add(Object obj) {
        lastAdd(obj);
        countSize++;
    }

    public void add(int index, Object obj) {
        if (index > countSize + 1) {
            throw new RuntimeException("下标越界");
        }
        // 如果链表为空 或者 在最后一个插入 直接尾部插入即可
        if (index == countSize) {
            lastAdd(obj);
        } else {
            // 找到插入位置上的元素
            Node cur = findIndex(index);
            Node node = new Node(cur.prev, cur, obj);
            cur.prev.next = node;
            cur.prev = node;
        }
        countSize++;
    }

    private void unLink(Node remove) {
        if (remove.next != null) {
            remove.prev.next = remove.next;
            remove.next.prev = remove.prev;
        } else {
            remove.prev.next = null;
        }
    }

    public void remove(int index) {
        isEmpty();
        Node remove = findIndex(index);
        unLink(remove);
        countSize--;

    }

    public void remove(Object obj) {
        isEmpty();
        Node remove = findCurElement(obj);
        unLink(remove);
        countSize--;
    }
    public void set(int index,Object obj){
        if (index > countSize + 1) {
            throw new RuntimeException("下标越界");
        }
        Node oldNode = findIndex(index);
        oldNode.data=obj;
    }
    public void display() {
        Node temp = head.next;
        isEmpty();
        System.out.print("[");
        while (temp.next != null) {
            System.out.print(temp.data + ",");
            temp = temp.next;
        }
        System.out.print(temp.data);
        System.out.println("]");
    }

}
