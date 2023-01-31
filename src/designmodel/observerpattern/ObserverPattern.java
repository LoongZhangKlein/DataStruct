package designmodel.observerpattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * @author loongzhang
 * @Description 定义对象中间的一种对一对多的依赖关系, 当一个对象的状态发生改变时
 * 所有依赖与他的对象都得到通知,并且自动更新
 * @Resolve 一个对象间的状态发生过改变所有的依赖对象都得到通知, 并且进行广播通知
 * @date 2023-01-17-16:58
 */



public class ObserverPattern {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);
        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);

    }

}
/**
 * 二进制观察者
 */
class BinaryObserver extends MyObserver {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        // 将该字符转换为二进制
        System.out.println("Binary String: "
                + Integer.toBinaryString(subject.getState()));
    }
}

class OctalObserver extends MyObserver {
    public OctalObserver(Subject subject) {
        this.subject = subject;
        // todo 没看明白
        this.subject.attach(this);

    }

    @Override
    public void update() {
        System.out.println("Octal String: " + Integer.toOctalString(subject.getState()));

    }
}

class HexaObserver extends MyObserver {

    public HexaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Hex String: "
                + Integer.toHexString(subject.getState()).toUpperCase());
    }
}


