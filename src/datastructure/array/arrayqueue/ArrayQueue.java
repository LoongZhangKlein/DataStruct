package datastructure.array.arrayqueue;

public class ArrayQueue {
    private int maxSize;
    private int font;
    private int rear;
    private int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        // 头指针
        this.font = -1;
        // 尾指针
        this.rear = -1;
        arr=new int[maxSize];
    }

    public boolean isEmpty(){
        return font==rear;
    }
    public boolean isFull(){
        return rear==maxSize-1;
    }
    public boolean addQueue(int n){
        if (isFull()){
            throw new RuntimeException("队列满了");
        }
        rear++;
        arr[rear]=n;
        return true;
    }
    public int getElement(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        font++;
        return arr[font];
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(10);
        boolean empty = arrayQueue.isEmpty();
        boolean full = arrayQueue.isFull();
        for (int i = 0; i < 9 ;i++) {
            arrayQueue.addQueue(i);
        }
        for (int i = 0; i < 9; i++) {
            int element = arrayQueue.getElement();
            System.out.print(element+" ==");

        }
        boolean empty1 = arrayQueue.isEmpty();
        boolean full1 = arrayQueue.isFull();
        System.out.println(empty+"    "+full);
        System.out.println(empty1+"    "+full1);


    }
}
