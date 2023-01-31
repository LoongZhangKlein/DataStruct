package designmodel.decoratorpattern;

/**
 * @author loongzhang
 * @Description 装饰模式使用
 * @date 2023-01-12-17:41
 */

public class DecoratorPattern {
    public static void main(String[] args) {

    }
}

interface Shape {
    void draw();
}

class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("hello 圆形类");
    }
}

class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("我是长方形类");
    }
}

/**
 * 装饰器
 */
class ShapeDecorator implements Shape {
    Shape shape;


    public ShapeDecorator(Shape shape){
        this.shape=shape;
    }
    @Override
    public void draw() {
        shape.draw();
    }
}

/**
 * 扩展类 [扩展装饰器]
 */
 class RedShapeDecorator extends ShapeDecorator{

    public RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        setRedBorder(shape);
    }

    /**
     * 扩展方法
     * @param decoratedShape
     */
    private void setRedBorder(Shape decoratedShape){
        System.out.println("Border Color: Red");
    }
}