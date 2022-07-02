package designmode;

public class Test {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Animal a = factory.build("A");
        a.say();
    }
}
class Factory{
    public Animal build(String str){
        if (str.equals("A")){
            return new Person();
        }else if (str.equals("B")){
            return new Dog();
        }else {
            return null;
        }
    }
}

interface Animal{
    void say();
}
class Person implements Animal{

    @Override
    public void say() {
        System.out.println("i am person");
    }
}
class Dog implements Animal{

    @Override
    public void say() {
        System.out.println("i am dog");
    }
}