package test;

import java.util.Arrays;

public class Demo {
    void methodOne(Demo2 demo2){
        System.out.println("我是方法1");
        System.out.println(demo2.printMsg());
    }
    void methodTwo(){
        System.out.println("我是方法2");
    }
    public static void main(String[] args) {
     new Demo().methodOne(new Demo2());
    }
}
