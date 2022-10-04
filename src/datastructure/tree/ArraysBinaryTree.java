package datastructure.tree;



public class ArraysBinaryTree {
    private Object[] binaryTree;
    private int countCapacity;
    public ArraysBinaryTree(int size){
        countCapacity=0;
        binaryTree=new Object[size];
    }

    /**
     * 顺序添加元素
     * @param object
     */
    public void add(Object object){
        if (countCapacity==binaryTree.length){
            System.out.println("容量已满");
            return;
        }
            binaryTree[countCapacity++]=object;
    }

    /**
     * 前序遍历(后序遍历只需要更改相应输出位置即可)
     */
    public void preOrderInner(int flag){
        // 传入根元
        System.out.println(binaryTree[flag]);
        //判断根元素 是否有左子结点有继续遍历,遍历终止条件为数组长度
        int equationsLeft=2*flag+1;
        int equationsRight=2*flag+2;
        if (equationsLeft<binaryTree.length){
            preOrderInner(equationsLeft);
        }
        if (equationsRight<binaryTree.length){
            preOrderInner(equationsRight);
        }
    }
    public void preOrder(){
        if (binaryTree.length==0){
            System.out.println("该树为空");
            return;
        }
        preOrderInner(0);
    }
}
