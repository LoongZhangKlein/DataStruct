package designmodel.proxypattern.dynamicproxy;

//房东 真实角色
public class Host implements Rent{
    public void rent() {
        System.out.println("房东要出租房子了");
    }
}