package chapter01;

public class SequenceList <T>{
    //定义泛型数组
    private T[] elem;
    //定义下标
    private int N;

    public SequenceList(int capacity) {
        //创建自定义长度数组
        this.elem = (T[])new Object[capacity];
        //初始化数组长度
        this.N=0;
    }
    //清空顺序表
    public void clear(){
        this.N=0;
    }
    //判断顺序表是否为空
    public boolean isEmpty(){
        if (this.N==0){
            return true;

        }else {
            return false;
        }
    }
    //获取线性表的长度
    public int length(){
        return elem.length+1;
    }
    //获取指定位置的元素
    public T get(int i){
        return elem[i-1];
    }
    //添加元素
    public void insert(T t){
        elem[N++]=t;
    }
public T remove(int del){
        for (int i=del;i<elem.length;i++){
            elem[i]=elem[i-1];
        }
        N--;
        return elem[del-1];
}
    public static void main(String[] args) {
        SequenceList seq=new SequenceList(10);
        seq.insert(1);
        for (int i=0;i<seq.elem.length;i++){
            System.out.println(seq.elem[i]);
        }

    }
}
