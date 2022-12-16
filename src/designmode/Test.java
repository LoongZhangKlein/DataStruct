package designmode;

import java.util.HashMap;
import java.util.Map;

interface Shape{
    void draw();
    default void  say(){
        System.out.println("我是梅赛德斯生产工厂");
    }
}
class Circle implements Shape{

    @Override
    public void draw() {
        System.out.println("我是轮子制造者");
    }
}
class Square implements Shape{

    @Override
    public void draw() {
        System.out.println("我是车身生产者");
    }
}

class CatFactory{
    private Map<String,Shape> stringShapeHashMap=new HashMap<String,Shape>();
    public CatFactory() {
        this.stringShapeHashMap.put("square",new Square());
        this.stringShapeHashMap.put("circle",new Circle());
    }
    public Shape createProduct(String msg){
        if (msg==null){
            throw new RuntimeException("请输入必要参数");
        }
        if (stringShapeHashMap.get(msg)==null){
            throw new RuntimeException("该类型为空");
        }
        return stringShapeHashMap.get(msg);

    }
}
public class Test {

    public static void main(String[] args) {
        CatFactory catFactory = new CatFactory();
        Shape square = catFactory.createProduct("square");
        Shape circle = catFactory.createProduct("circle");
        circle.say();
        square.draw();
        circle.draw();


    }
}
