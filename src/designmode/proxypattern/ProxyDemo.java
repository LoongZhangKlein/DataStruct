package designmode.proxypattern;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2022-12-16-17:43
 */
public class ProxyDemo {
    public static void main(String[] args) {
        Images images = new ProxyImages("loongzhang");
        images.display();
        System.out.println();
        images.display();
    }
}
