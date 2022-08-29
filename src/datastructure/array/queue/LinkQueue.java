package datastructure.array.queue;

import collection.MyLinkList.Link;

import java.util.ArrayList;
import java.util.List;

public class LinkQueue {
    private LinkQueue front;
    private LinkQueue rear;
    private Object data;
    private LinkQueue next;
    public LinkQueue(){
        this.data=null;
        this.front=null;
        this.rear=null;
        this.next=null;
    }
    public void add(Object obj){
        LinkQueue linkQueue = new LinkQueue();
        linkQueue.data=obj;

        this.front.next=linkQueue;

    }
    public void display(){
        if (front==null){
            throw new RuntimeException("队列为空");
        }
        while (front.next!=null){
            System.out.println(front.data);
            front=front.next;
        }
    }
}
