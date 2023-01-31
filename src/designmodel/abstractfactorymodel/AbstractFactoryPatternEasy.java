package designmodel.abstractfactorymodel;

/**
 * 抽象工厂简洁版本
 *和简单工厂对比 这样新添加类的时候就不用在工厂类中修改了,满足了开闭原则
 *同时 完美的运用了多态
 *
 * 我的疑问
 * 这样做需要新建工厂的同时 新建类
 */
public class AbstractFactoryPatternEasy {
    public static void main(String[] args) {
        Provide provide=new DogFactory();
        Animal provide1 = provide.provide();
        provide1.say();
        Provide provide2=new RabbitFactory();
        Animal provide3 = provide2.provide();
        provide3.say();
    }
}
interface Provide{
    Animal provide();
}
interface Animal{
    void say();
}
class Dog implements Animal{

    @Override
    public void say() {
        System.out.println("我是小狗");
    }
}
class Cat implements Animal{
    @Override
    public void say() {
        System.out.println("我是小猫");
    }
}

/**
 * 新添加类使用
 */
class Rabbit implements Animal{

    @Override
    public void say() {
        System.out.println("我是小兔子");
    }
}
class RabbitFactory implements Provide{

    @Override
    public Animal provide() {
        return new Rabbit();
    }
}
class DogFactory implements Provide{

    @Override
    public Animal provide() {
        return new Dog();
    }
}
class CatFactory implements Provide{

    @Override
    public Animal provide() {
        return new Cat();
    }
}
