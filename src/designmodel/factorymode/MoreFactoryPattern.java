package designmodel.factorymode;

/**
 * 多工厂实质上是对选择分支的细划分
 * 静态工厂实质上只是方便调用和加载的方式不同
 *这样可以避免因为传入条件的错误从而出现返回错误
 */
public class MoreFactoryPattern {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Animal cat = factory.createCat();
        cat.say();
        Animal dog = factory.createDog();
        dog.say();

    }
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

class Factory{
    public Animal createDog(){
        return new Dog();
    }
    public Animal createCat(){
        return new Cat();
    }
}

