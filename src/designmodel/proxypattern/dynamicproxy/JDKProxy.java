package designmodel.proxypattern.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author loongzhang
 * @Description DOING
 * @date 2022-12-29-17:25
 */
public class JDKProxy implements InvocationHandler {
    // 需要代理的目标对象
    public Object targetObject;
    //代理对象目标
    public void setTargetObject(Object targetObject) {
        this.targetObject = targetObject;
    }

    public Object getTargetObject(){
        /**
         * 指定当前对象的类加载器
         * 目标对象实现的接口类型
         * 事件处理器 this 指下边重写的invoke方法
         */
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader()
                , targetObject.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        method.invoke(targetObject);
        contract();
        agencyFee();
        return null;
    }
    public void seeHouse(){
        System.out.println("中介带你看房子");
    }
    public void contract(){
        System.out.println("签订租赁合同");
    }
    public void agencyFee(){
        System.out.println("收中介费");
    }

}
