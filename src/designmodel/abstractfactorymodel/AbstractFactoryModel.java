package designmodel.abstractfactorymodel;

/**
 * 抽象工厂实例
 */
public class AbstractFactoryModel {

}

class FactoryProducer {
    void getFactory(){

    }
}

/**
 * 抽象工厂
 */
abstract class AbstractFactory {
    abstract void getShape();

    abstract void getColor();


}

class ShapeFactory extends AbstractFactory {

    @Override
    void getShape() {

    }

    @Override
    void getColor() {

    }
}

class ColorFactory extends AbstractFactory {

    @Override
    void getShape() {

    }

    @Override
    void getColor() {

    }
}

interface Shape {
    void draw();
}
interface Color{
    void fill();
}

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
