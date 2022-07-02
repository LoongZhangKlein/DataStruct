package designmode.adapterpattern;

public class AdapterPatternToObj {
    public static void main(String[] args) {
        SourceObj sourceObj = new SourceObj();
        TargetableObj targetable = new AdapterObj(sourceObj);
        targetable.method1();
        targetable.method2();
    }

}
/**
 * 类的适配器模式
 */
class SourceObj {
    public void method1() {
        System.out.println("这里是原先的方法...");
    }
}
interface TargetableObj {

    /**
     * 与原类中的方法相同
     */
    public void method1();

    /**
     * 新类的方法
     */
    public void method2();
}

class AdapterObj  implements TargetableObj {
    public SourceObj source;
    public AdapterObj (SourceObj source){
        this.source=source;
    }
    @Override
    public void method1() {
    source.method1();
    }

    @Override
    public void method2() {
        System.out.println("这里是扩产的适配器类...");
    }
}
