package designmode.singletonpattern;

/**
 * 单例模式 创建对象的最佳方式
 */
public class SingletonPattern {
    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        /*SingleObject object = new SingleObject();*/
        //显示消息
        /*Singleton.getInstance();*/
        SingleHungry instance = SingleHungry.getInstance();
        instance.say();


    }
}

/**
 * 懒汉式 实现 一般不推荐使用
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
            System.out.println("我是新的我");
        }
        System.out.println("我还是我");
        return instance;
    }
    public void say(){
        System.out.println("hello  we are family");
    }
}

class SingleHungry {
    private static SingleHungry instance = new SingleHungry();

    private SingleHungry() {
    }

    public static SingleHungry getInstance() {
        System.out.println("我被调用了");
        return instance;
    }
    public void say(){
        System.out.println("hello  we are family");
    }
}

class SingletonCheck {
    private volatile static SingletonCheck singleton;

    private SingletonCheck() {
    }

    public static SingletonCheck getSingleton() {
        /**
         * 第一次一次进来两个线程,
         */
        if (singleton == null) {
            // 防止第一次创建时多线程问题
            synchronized (SingletonCheck.class) {
                /**
                 * 此处再次判断为null原因,例如当A B两个线程进入第一重判断后,A线程加锁,判空new 之后,释放锁
                 * 这时B线程进入就重新new了一个对象,不符合单例模式
                 */
                if (singleton == null) {
                    singleton = new SingletonCheck();
                }
            }
        }
        return singleton;
    }
}
