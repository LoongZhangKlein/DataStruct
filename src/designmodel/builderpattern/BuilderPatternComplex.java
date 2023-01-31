package designmodel.builderpattern;

/**
 * @author loongzhang
 * @Description 菜鸟教程的建造者实现方式
 * @date 2023-01-04-17:25
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 食物包装条目接口
 */
interface Item {
    String name();

    Packing packing();

    float price();
}

/**
 * 包装接口
 */
interface Packing {
    String pack();
}

/**
 * 包装纸类要实现打包接口
 */
class Wrapper implements Packing {

    @Override
    public String pack() {
        return "Wrapper包装纸包装";
    }
}

/**
 * 瓶装类实现打包操作
 */
class Bottle implements Packing {

    @Override
    public String pack() {
        return "Bottle瓶装";
    }
}

/**
 * 汉堡包实现包装条目
 * 1.使用纸包装方式
 */
abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    /**
     * 此处访问修饰符不可省略
     * 访问修饰符必须大于等于接口中
     * ☆☆☆☆☆☆抽象类默认修饰符为default
     *
     * @return
     */
    @Override
    public abstract float price();
}

/**
 * 冷饮实现并且用瓶包装
 */
abstract class ColdDrink implements Item {

    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}

/**
 * 扩展汉堡对象1
 */
class VegBurger extends Burger {

    @Override
    public float price() {
        return 25.0f;
    }

    @Override
    public String name() {
        return "Veg Burger";
    }
}

/**
 * 扩展汉堡对象2
 */
class ChickenBurger extends Burger {

    @Override
    public float price() {
        return 50.5f;
    }

    @Override
    public String name() {
        return "Chicken Burger";
    }
}

/**
 * 扩展可乐对象1
 */
class Coke extends ColdDrink {

    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "Coke";
    }
}

/**
 * 扩展可乐对象2
 */
class Pepsi extends ColdDrink {

    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "Pepsi";
    }
}
/**
 * 该类用来获得各个菜单
 */
class Meal {
    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}

/**
 * 该类用来创建组合组合可以自定义
 * 比如蔬菜汉堡和可乐
 * 蔬菜汉堡喝百事
 *
 */
class MealBuilder {

    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
    public Meal prepareVegAndChicken(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new VegBurger());
        return meal;
    }
}

/**
 * 建造者模式的使用
 * 其实该模式的使用屏蔽了MealBuilder以上的所有操作
 * 只专注于菜单创建已有的组合
 * 并且执行相应组合的已有方法
 * 该菜单创建有点类似模板方法
 * 这个例子确实绕了写
 *
 * 该例子整体实现流程:
 * 创建一个基本服务接口,接口包含实现所需操作的基本方法
 * 然后将
 */
public class BuilderPatternComplex {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.prepareNonVegMeal();
        meal.showItems();
    }
}
