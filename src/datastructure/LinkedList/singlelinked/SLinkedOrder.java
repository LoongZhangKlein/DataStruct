package datastructure.LinkedList.singlelinked;

/**
 * 这种方法是保证插入顺序的单链表
 */
public class SLinkedOrder {
    private NodeOrder header;
    private int size;
    private int counter;

    public SLinkedOrder() {
        header = new NodeOrder(null, null);
    }
    public SLinkedOrder(NodeOrder nodeOrder){
        header=nodeOrder;
    }

    public void add(int numb, Object obj) {
        NodeOrder node = new NodeOrder(numb, obj);
        NodeOrder temp = header;
        boolean flag = false;
        // todo 一直没理解的问题是 当插入元素小于原来的元素时,不应该插入元素排在前编码
        while (true) {
            if (temp.next == null) {
                break;
            }
            // 当插入元素大于前边元素
            if (temp.next.numb > numb) {
                break;
                // 重复插入
            } else if (temp.next.numb == numb) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("重复插入");
        } else {
            node.next = temp.next;
            temp.next = node;
            size++;

        }

    }
    public SLinkedOrder reverse(){
        NodeOrder reverseNode=new NodeOrder(null,null);
        NodeOrder temp=header.next;
        if (temp==null){
            throw new RuntimeException("连表为空");
        }
        while (true){
            if (temp==null){
                break;
            }
            temp.next=reverseNode.next;
            reverseNode.next=temp;
            temp=temp.next;
        }
        return new SLinkedOrder(reverseNode);
    }
    /**
     * 求单链表中倒数第几个节点
     * @return
     */
    public NodeOrder searchInverted(int numb){
        int target=size-(size-numb);
        NodeOrder node=header;
        for (int i = 0; i < target-1; i++) {
            node=node.next;
        }
        return node;
    }
    public int countSize(){
        NodeOrder temp=header.next;
        if (temp==null){
            return 0;
        }
        while (true){
            if (temp==null){
                break;
            }
            counter++;
            temp=temp.next;
        }
        return counter;
    }
    public void display() {
        NodeOrder temp = header.next;
        if (temp==null){
            throw new RuntimeException("连表为空");
        }
        while (true) {
            if (temp == null) {
               break;
            }
            System.out.println(temp.numb + " " + temp.data);
            temp = temp.next;
        }
    }
}
