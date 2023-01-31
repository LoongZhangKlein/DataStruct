package designmodel.factorymode;

import java.util.HashMap;
import java.util.Map;

interface Shape {
    void draw();
}

/**
 *
 */
class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("我是圆");
    }
}

class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("我是长方形");
    }
}

/**
 * 该类是工厂类
 */
//class ShapeFactory {
//    public Shape create(String str) {
//    if (str.equals("C")){
//        return new Circle();
//    }else if (str.equals("S")){
//        return new Square();
//    }else {
//        return null;
//    }
//    }
//}

/**
 * 优化后的写法
 *
 */
class ShapeFactory {
    Map<String,Shape> stringShapeMap= new HashMap<String,Shape>();
    public Shape create(String str) {
        if (str.equals("C")){
            return new Circle();
        }else if (str.equals("S")){
            return new Square();
        }else {
            return null;
        }
    }
}
/**
 * 该类用来使用工厂
 */
public class FactoryMode {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        Shape c = shapeFactory.create("S");

        c.draw();
    }

}
