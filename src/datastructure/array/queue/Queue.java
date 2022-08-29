package datastructure.array.queue;

public class Queue {
    private int maxSize;
    private int rear=0;
    private int front=0;
    private int[] arrayQueue;
    public Queue(int maxSize){
        this.maxSize = maxSize;
    this.arrayQueue=new int[maxSize];
    }
    public boolean isFull(){
        return maxSize==rear;
    }
    public boolean isEmpty(){
        return rear==front;
    }
    public void add(int numb){
        if (isFull()){
            System.out.println("队列已满");
        }else {
            arrayQueue[rear++]=numb;
        }

    }
    public void remove(){
        if (isEmpty()){
            System.out.println("队列为空");
        }else {
            int flag=front;
            while(flag!=rear-1){
                arrayQueue[flag]=arrayQueue[++flag];
            }
            arrayQueue[rear-1]=0;
        }

    }
    public void display(){
        for (int i = 0; i < this.maxSize; i++) {
            if (i<this.maxSize -1){
                System.out.print(arrayQueue[i]+",");
            }else{
                System.out.print(arrayQueue[i]);
            }


        }
        System.out.println();
    }
    public int size(){
        return this.maxSize;
    }
}

