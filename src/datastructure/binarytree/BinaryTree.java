package datastructure.binarytree;

public  class BinaryTree<E> {
    private Node<E> root;
    private int size;

    public void buildTree() {
        Node rootNode = new Node(0,"宋江");
        Node node2 = new Node(1,"吴用");
        Node node3 = new Node(2,"卢俊义");
        Node node4= new Node(3,"林冲");
        rootNode.leftNode=node2;
        rootNode.rightNode=node3;
        node3.rightNode=node4;
        root=rootNode;
    }


    public void preOrderTree() {
        if (root!=null){
            this.root.preOrder();
        }else {
            System.out.println("Tree is null");
        }

    }
    public void infixOrder(){
        if (root!=null){
            this.root.infixOrder();
        }else{
            System.out.println("null");
        }

    }
    public void postOrder(){
        if (root!=null){
            this.root.postOrder();
        }else{
            System.out.println("null");
        }

    }

}
