package designmodel.templatepattern;

/**
 * @author loongzhang
 * @Description DOING
 * 优点： 1、封装不变部分，扩展可变部分。 2、提取公共代码，便于维护。 3、行为由父类控制，子类实现。
 * 缺点：每一个不同的实现都需要一个子类来实现，导致类的个数增加，使得系统更加庞大。
 * 使用场景： 1、有多个子类共有的方法，且逻辑相同。 2、重要的、复杂的方法，可以考虑作为模板方法。
 * @date 2022-12-13-17:34
 */
public class TemplatePattern {
    public static void main(String[] args) {
        Basketball basketball = new Basketball();
        basketball.playModel();
    }
}
