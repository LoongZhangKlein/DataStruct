package datastructure.array.queue;

import java.sql.ClientInfoStatus;

public class Test {
   static void Queue(){
       CircleQueue circleQueue = new CircleQueue(2);
       circleQueue.add(1);
       int remove = circleQueue.remove();
       System.out.println(remove);
       circleQueue.display();

   }
   static void CircleQueue(){
       CircleQueueS circleQueueS = new CircleQueueS(5);
       for (int i = 0; i < 5; i++) {
           circleQueueS.add(i);
       }
       System.out.println(circleQueueS.size());
       Object remove = circleQueueS.remove();
       System.out.println("删除元素为"+remove);
       int size = circleQueueS.size();
       System.out.println("长度"+size);
       circleQueueS.display();
   }
   static void linkQueue(){
       LinkQueue linkQueue = new LinkQueue();
       linkQueue.add("我");
       linkQueue.add("你");
       linkQueue.display();
   }
    public static void main(String[] args) {
       /* Queue();*/
        /*CircleQueue();*/
        linkQueue();

    }
}
