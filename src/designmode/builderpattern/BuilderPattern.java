package designmode.builderpattern;

/**
 * 难度指数 ☆☆☆☆
 * 适用场景
 * 基本部件不变,组合经常变化
 * 将各种产品集中起来管理，用来创建复合对象，所谓复合对象就是指某个类具有不同的属性。
 * <p>
 * 第一遍没看懂
 */
public class BuilderPattern {
    public static void main(String[] args) {
        // 通过抽象类 来接收组装类
        Builder mBuilder = new MoonComputerBuilder();
        // 通过建造类 来建造抽象类
        Director director = new Director(mBuilder);
        director.createComputer("intel i7 6500U", "紫东", "DDR3L");

    }
}

/**
 * 产品类
 */
class Computer {
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

/**
 * 规范产品组件
 * 组装整个产品类呗
 */
abstract class Builder {
    public abstract void buildCpu(String cpu);

    public abstract void buildBoard(String board);

    public abstract void buildRam(String ram);

    public abstract Computer create();
}

/**
 * 具体组装类 继承规范产品类
 *
 */
class MoonComputerBuilder extends Builder {
    private Computer computer = new Computer();

    @Override
    public void buildCpu(String cpu) {
        computer.setCpu(cpu);
    }

    @Override
    public void buildBoard(String board) {
        computer.setMainBoard(board);
    }

    @Override
    public void buildRam(String ram) {
        computer.setRam(ram);
    }

    @Override
    public Computer create() {
        return computer;
    }
}

/**
 * 导演类 统一组装过程
 */

class Director {
    Builder mBuilder = null;

    public Director(Builder mBuilder) {
        this.mBuilder = mBuilder;
    }

    public Computer createComputer(String cpu, String board, String ram) {
        this.mBuilder.buildBoard(board);
        this.mBuilder.buildCpu(cpu);
        this.mBuilder.buildRam(ram);
        return mBuilder.create();
    }
}


