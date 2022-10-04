package datastructure.tree;

/**
 * 树的构造
 * 1.构造种类
 *  普通二叉树(不完全二叉树)  完全二叉树 满二叉树  等等
 *  当然相对较好的办法是根据元素的个数进行二叉树种类的构建,例如当五个元素进行构建时
 *  构建成树时,满二叉树是最好的选择,但是这样做太过于复杂
 *  按照普通二叉树为例
 *  构造普通二叉树
 *  按照元素的个数进行树的装填
 * 实现二叉树遍历时的方法
 * 1:各种遍历时传入需要遍历的二叉树的根节点
 * 2:时找出二叉树的根节点,显然不现实,因为这样至少需要一个标记位置,来标记是否是根节点
 * 否则遍历查找二叉树中谁是根节点不现实,而且会大量浪费其余空间,然后,当二叉树的极致理想化,
 * 就会演变成一个链表,显然不显示
 *
 *
 */
public class BinaryTree {
    private Node root;
    private int monitorCount=0;
    /**
     * 最普通的方式构建
     */
    public void buildTree(){
        root=new Node(1);
        Node node = new Node(2);
        Node node1 = new Node(3);
        Node node2 = new Node(4);
        Node node3 = new Node(5);
        Node node4 = new Node(6);
        Node node5 = new Node(7);
        Node node6 = new Node(8);
        root.leftNode=node;
        root.rightNode=node1;
        node.leftNode=node2;
        node.rightNode=node3;
        node1.rightNode=node4;
        node3.leftNode=node5;
        node3.rightNode=node6;
    }

    /**
     * 前序遍历
     */
    public void preOrder(){
        if (root==null){
            System.out.println("该树为空");
            return;
        }
        preOrderInner(root);
        System.out.println();
    }

    /**
     * 前序遍历打印版本内部方法
     * @param root
     */
    private void preOrderInner(Node root){
        System.out.print(root.date+"-->");
        if (root.leftNode!=null){
            preOrderInner(root.leftNode);
        }
        if (root.rightNode!=null){
            preOrderInner(root.rightNode);
        }
    }

    /**
     * 前序查找内部方法
     * @param root
     * @param o
     * @return
     */
    private Node preSearchInner(Node root,Object o){
        monitorCount++;
        if (root.date==o){
            System.out.println();
            return root;
        }
        Node temp=null;
        if (root.leftNode!=null){
             temp=preSearchInner(root.leftNode, o);
        }
        if (temp!=null){
            return temp;
        }
        if (root.rightNode!=null){
             temp=preSearchInner(root.rightNode, o);
        }
        return temp;
    }

    /**
     *
     * @param root
     * @param o
     * @return
     */
    private Node infixSearchInner(Node root,Object o){
        Node temp=null;
        if (root.leftNode!=null){
            temp=infixSearchInner(root.leftNode,o);
        }
        if (temp!=null){
            return temp;
        }
        monitorCount++;
        if (root.date==o){
            return root;
        }
        if (root.rightNode!=null){
            temp= infixSearchInner(root.rightNode, o);
        }
        return temp;

    }
    private Node postOrderSearchInner(Node root, Object o){
        Node temp=null;
        if (root.leftNode!=null){
            temp=postOrderSearchInner(root.leftNode,o);
        }
        if (temp!=null){
            return temp;
        }
        if (root.rightNode!=null){
            temp= postOrderSearchInner(root.rightNode, o);
        }
        if (temp!=null){
            return temp;
        }
        monitorCount++;
        if (root.date==o){
            return root;
        }
        return temp;
    }

    /**
     * 前序查找
     * @param o
     * @return
     */
    public Node preSearch(Object o){
        monitorCount=0;
        if (root==null){
            System.out.println("该树为空");
            return null;
        }
        Node node = preSearchInner(root, o);
        System.out.printf("查找次数%s",monitorCount+" ");
        return node;
    }
    public Node infixSearch(Object o){
        monitorCount=0;
        if (root==null){
            System.out.println("该树为空");
            return null;
        }
        Node node = infixSearchInner(root, o);
        System.out.printf("查找次数%s",monitorCount+" ");
        return node;
    }
    public Node orderPostSearch(Object o){
        monitorCount=0;
        if (root==null){
            System.out.println("该树为空");
            return null;
        }
        Node node = postOrderSearchInner(root, o);
        System.out.printf("查找次数%s",monitorCount+"  ");
        return node;
    }


    /**
     * 二叉树节点删除
     * @param object
     * @return
     */
    public Node removeInner(Object object,Node root){
        Node temp=null;
        if (root.leftNode!=null &&root.leftNode.date==object){
            temp=root.leftNode;
            root.leftNode=null;
            return temp;
        }
        if (root.rightNode!=null && root.rightNode.date==object){
            temp=root.rightNode;
            root.rightNode=null;
            return temp;
        }
        if (root.leftNode!=null){
            removeInner(object,root.leftNode);
        }
        if (temp!=null){
            return temp;
        }
        if (root.rightNode!=null){
            removeInner(object,root.rightNode);
        }
        return temp;
    }
    /**
     * 二叉树节点删除
     * @param object
     * @return
     */
    public Node remove(Object object){
        if (root==null){
            System.out.println("空数");
            return null;
        }else{
            if (root.date==object){
                Node temp=root;
                root=null;
                return temp;
            }else{
                Node node = removeInner(object,root);
                return node;
            }
        }
    }
    private boolean isEmpty(){
        return root==null;
    }

}
