package chapter01;

import java.util.Scanner;

class Sqlist{
    //顺序表的长度
    int usedSize;
    //顺序表
    int [] elem;
    public Sqlist(int size){
        elem=new int[size];
        usedSize=0;
        System.out.println("顺序表创建成功"+"长度为"+size);
    }

    /**
     * 判断顺序表是否为空
     * @return
     */
    public int isNull(){
        if (usedSize==0){
            return 0;
        }
        //不为空返回当前顺序表长度
        return usedSize;
    }
    /**
     * 顺序表的插入
     */
    public String insert(int locate,int values){
        if (isNull()!=0||locate<0||locate>elem.length){
            System.out.println("输入越界");
        }
        //核心逻辑对插入位置后边的元素后移,空出要插入的位置
        for (int i=elem.length-1;i>=locate;i--){
            elem[i+1]=elem[i];
        }
        elem[locate]=values;
        this.usedSize++;
        return "OK";
    }
}
public class SortTable {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        System.out.println("请输入顺序表的长度");
        int numb = scan.nextInt();
        //初始化长度
        Sqlist sqlist=new Sqlist(numb);
        System.out.println("请输入要插入的位置和数值");
        int locate=scan.nextInt();
        int values=scan.nextInt();
        sqlist.insert(locate,values);

    }
}
