package datastructure.array.queue;

/**
 * 使用空一格位置的环形队列
 * @author DragonZhang
 */
public class CircleQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arrayCircleQueue;
    public CircleQueue(int maxSize){
        this.rear=0;
        this.front=0;
        this.maxSize=maxSize;
        arrayCircleQueue=new int[maxSize];
    }
    public boolean isFull(){
        // 为了区分和rear==font
        return (rear+1)%maxSize==front;
    }
    public boolean isEmpty(){
        return rear==front;
    }

    /**
     * 队列中个数
     * @return
     */
    public int size(){
        /**
         * 是由公式推导出来的
         * 当尾部大于头部时 rear-front就是
         * 当尾部小于头部时 rear-front是负数
         * 当一个负数加上一个大于该负数的正数 取余改正数 一定为正数且一定小小于改正数
         */
        return (rear-front+maxSize)%maxSize;
    }
    public void add(int numb){
        if (isFull()){
            throw new RuntimeException("队列已满");
        }
        this.arrayCircleQueue[rear]=numb;
        this.rear=(rear+1)%maxSize;
    }
    public int remove(){
    if (isEmpty()){
        throw new RuntimeException("队列已空");
    }
    int current=this.arrayCircleQueue[front];
    this.arrayCircleQueue[front]=0;
    front=(front+1)%maxSize;
    return current;
    }
    public int getIndex(){
        int index=this.arrayCircleQueue[front];
        return index;
    }
    public void display(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        for (int i = front; i < front+this.size(); i++) {
            if (i<front+this.size()-1){
                System.out.print(arrayCircleQueue[i]+",");
            }else{
                System.out.println(arrayCircleQueue[i]);
            }

        }
    }

}

