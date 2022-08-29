package leetcode.hotproblems.Array;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTree {
    public static void diameterOfBinaryTree(TreeNode root) {
        while(root.val!=0){
                System.out.println(root.val);
            if (root.left.val!=0){
                root=root.left;
                System.out.println(root.val);
            }
            if (root.right.val!=0){
                root=root.right;
                System.out.println(root.val);
            }

        }

    }
    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        treeNode.left=treeNode1;
        treeNode.right=treeNode2;
        treeNode1.left=treeNode3;
        treeNode1.right=treeNode4;
        diameterOfBinaryTree(treeNode);
    }
}
