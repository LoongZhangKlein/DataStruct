package designmodel.proxypattern;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2022-12-20-17:26
 */
public class SaveMoneyImpl implements SaveMoney{

    @Override
    public void saveMoney() {
        System.out.println("真正的存钱类");
    }
}
