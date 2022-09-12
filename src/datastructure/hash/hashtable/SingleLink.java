package datastructure.hash.hashtable;

public class SingleLink {
    private Node node;
    public SingleLink(){
        node=new Node();
    }
    private Node findLast(){
        Node temp=node;
        while (true){
            if (temp.next==null){
                return temp;
            }
            temp=temp.next;
        }
    }
    public void add(Object obj){
        Node node = new Node();
        node.data=obj;
        Node last = findLast();
        last.next=node;
    }
    private Node findElementBefore(Object obj){
        Node temp=node;
        while (true){
            if (temp==null){
                System.out.println("未找到钙元素");
                return  null;
            }
            if (temp.next.data==obj){
                return temp;
            }
            temp=temp.next;
        }
    }
    private Node findElementCurrent(Object obj){
        Node temp=node;
        while (true){
            if (temp==null){
                System.out.println("未找到钙元素");
                return  null;
            }
            if (temp.data==obj){
                return temp;
            }
            temp=temp.next;
        }
    }
    public void remove(Object obj){
        Node removeBefore = findElementBefore(obj);
        removeBefore.next=removeBefore.next.next;
        removeBefore=null;
    }
    public boolean update(Object old,Object neo){
        Node current= findElementCurrent(old);
        current.data=neo;
        if (current==null){
            return false;
        }
        return true;

    }
    public void display(){
        Node temp=node.next;
        while (true){
            if (temp==null){
                break;
            }
            System.out.print(temp.data+"-->");
            temp=temp.next;
        }
    }
}
