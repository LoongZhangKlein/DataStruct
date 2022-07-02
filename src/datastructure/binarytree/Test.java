package datastructure.binarytree;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a=new int[]{1,6,8,5,9};
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.buildTree();
        /*binaryTree.postOrder();*/
        binaryTree.infixOrder();
       /* binaryTree.preOrderTree();*/

    }
}
