package designmode.builderpattern;

/**
 * 最笨拙的实现
 */
public class StupidPattern {
    public static void main(String[] args) {
        MyComputer myComputer = new MyComputer();
        myComputer.setCpu("1");
        myComputer.setMainBoard("1");
        myComputer.setRam("1");
    }
}
/**
 * 产品类
 */
class MyComputer {
    private String cpu;
    private String mainBoard;
    private String ram;

    public void setCpu(String mCpu) {
        this.cpu = mCpu;
        System.out.println("安装CPU:" + cpu);
    }

    public void setMainBoard(String board) {
        this.mainBoard = board;
        System.out.println("安装主板:" + mainBoard);
    }

    public void setRam(String ram) {
        this.ram = ram;
        System.out.println("安装内存:" + this.ram);
    }

}
