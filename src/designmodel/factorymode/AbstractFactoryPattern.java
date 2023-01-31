package designmodel.factorymode;

/**
 * @author loongzhang
 * @Description 抽象工厂的实现
 * @date 2023-01-31-17:23
 */
public class AbstractFactoryPattern {
    /**
     * 使用抽象工厂
     */
    public static void main(String[] args) {
        AbstractFactory shape = AbstractFactoryProducer.getFactory("shape");
        ColorAbstract blue = shape.getColor("blue");
        blue.fill();
        ColorAbstract purple = shape.getColor("purple");
        purple.fill();


    }


}

interface ShapeAbstract {
    void draw();
}

interface ColorAbstract {
    void fill();
}

class CircleAbstract implements ShapeAbstract {

    @Override
    public void draw() {
        System.out.println("我是圆形");
    }
}

class SquareAbstract implements ShapeAbstract {

    @Override
    public void draw() {
        System.out.println("我是方形");
    }
}

class Purple implements ColorAbstract {

    @Override
    public void fill() {
        System.out.println("我是紫色");
    }
}

class Blue implements ColorAbstract {

    @Override
    public void fill() {
        System.out.println("我是蓝色");
    }
}

/**
 * 创建抽象工厂
 */
abstract class AbstractFactory {
    public abstract ShapeAbstract getShape(String shape);

    public abstract ColorAbstract getColor(String color);
}

/**
 * 创建抽象工厂实现类
 */
class ShapeFactoryRealize extends AbstractFactory {

    @Override
    public ShapeAbstract getShape(String shape) {
        if (shape==null){
            return null;
        } else if (shape.equalsIgnoreCase("circle")) {
            return new CircleAbstract();
        } else if (shape.equalsIgnoreCase("square")) {
            return new SquareAbstract();
        }
        return null;
    }

    @Override
    public ColorAbstract getColor(String color) {
        return null;
    }
}
class ColorFactoryRealize extends AbstractFactory {

    @Override
    public ShapeAbstract getShape(String shape) {
        return null;
    }

    @Override
    public ColorAbstract getColor(String color) {
        if (color==null){
            return null;
        } else if (color.equalsIgnoreCase("purple")) {
            return new Purple();
        } else if (color.equalsIgnoreCase("blue")) {
            return new Blue();
        }
        return null;
    }

}

/**
 * 工厂生成器
 */
class AbstractFactoryProducer{
    public static AbstractFactory getFactory(String factoryChoice){
        if (factoryChoice==null){
            return null;
        } else if (factoryChoice.equalsIgnoreCase("shape")) {
            return new ShapeFactoryRealize();
        } else if (factoryChoice.equalsIgnoreCase("color")) {
            return new ColorFactoryRealize();
        }
        return null;
    }
}
