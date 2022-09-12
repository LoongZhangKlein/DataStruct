package datastructure.hash.hashtable;

import com.sun.deploy.panel.JreTableModel;

public class HashTable {
    private SingleLink[] singleLinkArray;
    private int size;
    public HashTable(int size){
        this.size=size;
        singleLinkArray =new SingleLink[size];
        for (int i = 0; i < size; i++) {
            singleLinkArray[i]=new SingleLink();
        }
    }
    public int hashFun(Object obj){
        return obj.hashCode()%size;
    }

    public Object add(Object object){
        int position = hashFun(object);
        singleLinkArray[position].add(object);
        return object;
    }
    public Object remove(Object object){
        int position = hashFun(object);
        singleLinkArray[position].remove(object);
        return object;

    }
    public Object update(Object old,Object neo){
        int position = hashFun(old);
        boolean update = singleLinkArray[position].update(old, neo);
        return update;
    }

    public void display(){
        for (int i = 0; i <size; i++) {
            System.out.printf("第%d条链表:",i);
            singleLinkArray[i].display();
            System.out.println();
        }
    }
}
