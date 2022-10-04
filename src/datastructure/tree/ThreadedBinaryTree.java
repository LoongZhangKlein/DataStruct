package datastructure.tree;

/**
 * 线索化二叉树
 *
 * @author DragonZhang
 */
public class ThreadedBinaryTree {
    private ThreadNode root;
    // 在递归线索化是pre总是保留前一个节点
    private ThreadNode pre=null;

    public void buildTree() {
        root = new ThreadNode(1);
        ThreadNode node3 = new ThreadNode(3);
        ThreadNode node6 = new ThreadNode(6);
        ThreadNode node8 = new ThreadNode(8);
        ThreadNode node10 = new ThreadNode(10);
        ThreadNode node14 = new ThreadNode(14);
        root.leftNode = node3;
        root.rightNode = node6;
        node3.leftNode = node8;
        node3.rightNode = node10;
        node6.leftNode = node14;
    }
    public void threadBinaryTree(){
        threadedBinaryTree(root);
    }
    /**
     * 中序线索化二叉树
     * 规则:leftType==0 表示左子树,为1表示指向前驱节点
     * 规则:rightType==0 表示左子树,为1表示指向前驱节点
     *
     * @param root
     */
    private void threadedBinaryTree(ThreadNode root) {
        if (root == null) {
            System.out.println("该树为空");
            return;
        }
        // 线索化左子树  目的是找到最左边的那个节点 本数来说就是8
        if (root.leftNode != null) {
            threadedBinaryTree(root.leftNode);
        }
        /**
         * 线索化根  难度↑↑↑↑
         * 处理当前节点的前驱结点
         */
        if (root.leftNode == null) {
            pre = root;
            root.leftNode.leftType = 1;
        }
        if (pre!=null && pre.rightNode==null){
            pre.rightNode=root;
            pre.rightNode.rightType=1;
        }
        pre=root;
        // 线索化右子树
        if (root.rightNode != null) {
            threadedBinaryTree(root.rightNode);
        }
    }

}
