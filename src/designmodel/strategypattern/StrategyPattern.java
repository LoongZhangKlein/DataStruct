package designmodel.strategypattern;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2023-01-12-17:18
 */


/**
 * 策略模式
 * 总体思路
 *  1.创建要实现逻辑或者算法的统一接口
 *  2.具体的算法或者操作实现该接口
 *  3.核心操作====创建使用该策略的桥接类,因为接口不能被实例化
 *  ,所以在桥接类的构造方法中需要实例化该类,
 *  4.使用该类,传入相关的操作
 *
 *  analyse:
 *   当使用时必须知道所要使用的方法的名字
 */
public class StrategyPattern {
    public static void main(String[] args) {
        Context context = new Context(new OperationAdd());
        int i = context.executeStrategy(1, 2);
        System.out.println("结果:"+i);
    }
}
/**
 * 定义策略接口
 */
interface Strategy {
    int doOperation(int numOne, int numTwo);
}

/**
 * 创建实用类
 */
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }
    /**
     * 执行对应的策略
     */
    public int executeStrategy(int num1,int num2){
        return strategy.doOperation(num1,num2);
    }
}

class OperationAdd implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class OperationSubtract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}

class OperationMultiply implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
