package designmode.templatepattern;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2022-12-13-17:38
 */
public class Basketball extends Game{
    @Override
    void initialize() {
        System.out.println("这里是篮球的热身阶段");
    }

    @Override
    void startPlay() {
        System.out.println("这里是篮球开始阶段");
    }

    @Override
    void endPlay() {
        System.out.println("夕阳晚霞一球两人一世界");
    }
}
