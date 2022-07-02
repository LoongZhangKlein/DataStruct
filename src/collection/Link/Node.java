package collection.Link;

public class Node<E> {
    public Node<E> next;
    // 数据
    public E e;

    public Node(E e) {
        this.e = e;
    }

    @Override
    public String toString() {
        return "Node{" +
                "e=" + e +
                '}';
    }
}
