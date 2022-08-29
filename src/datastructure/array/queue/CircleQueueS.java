package datastructure.array.queue;

import com.sun.org.apache.xpath.internal.objects.XObject;

public class CircleQueueS {
    private int flag;
    private int front;
    private int rear;
    private Object[] arr;
    public CircleQueueS(int maxSize){
        this.flag=0;
        this.front=0;
        this.rear=0;
        arr=new Object[maxSize];
    }
    public boolean isEmpty(){
        if (front==rear&&  flag==0){
            return true;
        }
        return false;
    }
    public boolean isFull(){
        if (front==rear &&flag==1){
            return true;
        }
        return false;
    }
    public void add(Object obj){
        if (isFull()){
            throw new RuntimeException("队列满了");
        }
        arr[rear++]=obj;
        if (rear==front){
            flag=1;
        }
    }
    public Object remove(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        Object del=arr[front++];
        return del;
    }
    public Object getIndex(){
        return arr[front];
    }
    public int size(){
        return rear-front;
    }
    public void display(){
        if (isEmpty()){
                throw new RuntimeException("队列为空");
        }
        for (int i = front; i < front+this.size(); i++) {
            System.out.println(arr[i]);
        }
    }
}
