package datastructure.binarytree;

public class Node<E> {
    public E data;
    public int id;
    public Node<E> leftNode;
    public Node<E> rightNode;

    public Node(E data, Node leftNode, Node rightNode) {
        this.rightNode = rightNode;
        this.leftNode = leftNode;
        this.data = data;
    }

    public Node(int id, E data) {
        this.data = data;
        this.id = id;
    }

    @Override
    public String toString() {
        return id + "=>" + String.valueOf(data);
    }

    public void preOrder() {
        if (this.data == null) {
            System.out.println("null");
        }
        System.out.println(this);
        if (this.leftNode != null) {
            this.leftNode.preOrder();
        }
        if (this.rightNode != null) {
            this.rightNode.preOrder();
        }
    }

    public void infixOrder() {
        if (this.leftNode != null) {
            this.leftNode.infixOrder();
        }
        System.out.println(this);
        if (this.rightNode != null) {
            this.rightNode.infixOrder();
        }
    }

    public void postOrder() {
        if (this.leftNode != null) {
            this.leftNode.postOrder();
        }
        if (this.rightNode != null) {
            this.rightNode.postOrder();
        }
        System.out.println(this);
    }

    public Node<E> preSearch(int no) {
        if (this.id == no) {
            return this;
        }
        Node node = null;
        if (this.leftNode != null) {
            node = this.leftNode.preSearch(no);
        }
        //no!=null
        if (node.id == no) {
            return this;
        }
        if (this.rightNode != null) {
            node = this.rightNode.preSearch(no);
        }
        return node;
    }

}
