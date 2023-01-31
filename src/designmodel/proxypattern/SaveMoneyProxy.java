package designmodel.proxypattern;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2022-12-20-17:27
 */
public class SaveMoneyProxy implements SaveMoney{
    private SaveMoney saveMoney;
    public SaveMoneyProxy(SaveMoney saveMoney){
        this.saveMoney=saveMoney;
    }

    @Override
    public void saveMoney() {
        System.out.println("增强功能1");
        System.out.println("这里是存钱代理类");
        System.out.println("增强功能1");
        System.out.println("增强功能1");
        saveMoney.saveMoney();
    }
}
