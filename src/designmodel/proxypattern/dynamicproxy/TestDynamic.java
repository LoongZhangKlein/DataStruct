package designmodel.proxypattern.dynamicproxy;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2022-12-29-17:36
 */
public class TestDynamic {
    public static void main(String[] args) {

        Host host = new Host();
        JDKProxy jdkProxy = new JDKProxy();
        jdkProxy.setTargetObject(host);
        Rent targetObject = (Rent) jdkProxy.getTargetObject();
        targetObject.rent();
    }
}
