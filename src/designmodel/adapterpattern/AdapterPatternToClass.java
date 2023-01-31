package designmodel.adapterpattern;

/**
 * 有动机地修改一个正常运行的系统的接口，这时应该考虑使用适配器模式。
 * 1可以让任何两个没有关联的类一起运行。
 * 2、提高了类的复用。
 * 3、增加了类的透明度。
 * 4、灵活性好。
 *  消除由于接口不匹配所造成的的类的兼容性问题。
 *
 * 这个例子 合适吗?
 *
 * 通过继承和实现来完成
 */
public class AdapterPatternToClass {
    public static void main(String[] args) {
        Targetable targetable = new Adapter();
        targetable.method1();
        targetable.method2();
    }

}
/**
 * 类的适配器模式
 */
class Source {
    public void method1() {
        System.out.println("这里是原先的方法...");
    }
}
interface Targetable {

    /**
     * 与原类中的方法相同
     */
    public void method1();

    /**
     * 新类的方法
     */
    public void method2();
}

class Adapter extends Source implements Targetable {

    @Override
    public void method2() {
        System.out.println("这里是扩产的适配器类...");
    }
}



