package designmodel.factorymode;

/**
 * @author loongzhang
 * @Description  工厂类的缺点显而易见,就是需要知道类的具体的名字
 * 同时修改一个新的类的同时需要添加一个新的类,然后就是进行大量的if else 进行相应的判断
 *
 * @date 2023-01-28-17:51
 */
public class Test {
    public static void main(String[] args) {
        FactoryTest circle = new FactoryCenter().getShape("circle");
        circle.draw();
    }
}

interface FactoryTest{
    void draw();
}
class CircleTest implements FactoryTest{

    @Override
    public void draw() {
        System.out.println("我是圆形类");
    }
}
class SquareTest implements FactoryTest{

    @Override
    public void draw() {
        System.out.println("我是长方形类");
    }
}

class FactoryCenter{
    public FactoryTest getShape(String caseExample){
        if ("circle".equals(caseExample)){
            return new CircleTest();
        }else if ("square".equals(caseExample)){
            return new SquareTest();
        }else {
            return null;
        }
    }
}
