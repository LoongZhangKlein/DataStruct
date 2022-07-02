package designmode.adapterpattern;

/**
 * 难度☆
 * 接口中有多个抽象方法写该接口的实现类时必须实现该接口的所有方法有时比较浪费
 * 因为并不是所有的方法都是我们需要的，有时只需要某一些
 *
 */
public class AdapterPatternToInterFace {

    private static Port chatPort = new Chat();
    private static Port serverPort = new Server();

    public static void main(String[] args) {
        // 聊天服务
        chatPort.NET();
        // 服务器
        serverPort.SSH();
        serverPort.NET();
        serverPort.Tomcat();
        serverPort.MySQL();
    }

}
/**
 * 定义端口接口，提供通信服务
 */
interface Port {
    /**
     * 远程SSH端口为22
     */
    void SSH();

    /**
     * 网络端口为80
     */
    void NET();

    /**
     * Tomcat容器端口为8080
     */
    void Tomcat();

    /**
     * MySQL数据库端口为3306
     */
    void MySQL();
}
/**
 * 定义抽象类实现端口接口，但是什么事情都不做
 */
abstract class Wrapper implements Port {
    @Override
    public void SSH() {

    }

    @Override
    public void NET() {

    }

    @Override
    public void Tomcat() {

    }

    @Override
    public void MySQL() {

    }
}
/**
 * 提供聊天服务
 * 需要网络功能
 */
class Chat extends Wrapper {
    @Override
    public void NET() {
        System.out.println("Hello World...");
    }
}

/**
 * 网站服务器
 * 需要Tomcat容器，Mysql数据库，网络服务，远程服务
 */
class Server extends Wrapper {
    @Override
    public void SSH() {
        System.out.println("Connect success...");
    }

    @Override
    public void NET() {
        System.out.println("WWW...");
    }

    @Override
    public void Tomcat() {
        System.out.println("Tomcat is running...");
    }

    @Override
    public void MySQL() {
        System.out.println("MySQL is running...");
    }
}


