package designmodel.templatepattern;

/**
 * @author loongzhang
 * @Description
 * 模板方法使用思路
 * 定义抽象类, 抽象方法,
 * @date 2022-12-13-17:34
 */
public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void endPlay();
    public final void playModel(){
        initialize();
        startPlay();
        endPlay();
    }


}
