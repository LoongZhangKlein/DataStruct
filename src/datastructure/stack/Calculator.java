package datastructure.stack;

import java.nio.channels.MulticastChannel;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 实现思想:
 * 1.遍历表达式 取出其中的数 或者符号
 * 2.是数就放到数栈
 * 3.是符放入 符号栈 但应遵循如下规则
 * 3.1若符号栈为空,直接放入符号栈即可
 * 不为空放入符号栈时应遵循,当待入栈符号与符号栈内符号比较时 优先级低于或者等于栈中元素时
 * 符号栈中元素出栈,然后数栈出栈两个数进行运算后,将结果放入数栈
 * 不为空但待入栈符号与符号栈内符号比较时,优先级高于符号栈内符号时,入栈即可
 * 4.当表达式遍历完成后
 * 符号栈出栈一符号,数栈出栈两个数,进行计算将结果放入数栈重复进行直至符号栈为空
 * 5.此时数栈只剩下一个数组,将结果弹出即可
 */
public class Calculator {
    private int index = 0;

    /**
     * 相当于启动类
     */
    public void operation() {
        Calculator c = new Calculator();
        String a = "1+6/2*3+1+8-5-7";
        // 创建对应的栈
        MyStack numberStack = c.buildStack();
        MyStack operatorStack = c.buildStack();

        while (true) {
            String aChar = c.getChar(a);
            // 如果返回为空表示读取结束
            if (aChar == null) {
                // 所有符号均出栈 然后 出数进行运算 直至符号栈为空
                expressionReadEnd(numberStack, operatorStack);
                // 符号栈为空后出数栈最后元素即可
                System.out.format("表达式是:%s=%d", a, Integer.parseInt(String.valueOf(numberStack.pop())));
                break;
            }
            // 是数就进入数栈
            if (isNumber(aChar)) {
                if (aChar != null) {
                    numberStack.add(aChar);
                }

            }
            // 是符号放入符号栈
            if (isOperator(aChar)) {
                // 是空的直接放入符号栈
                if (operatorStack.isEmpty()) {
                    operatorStack.add(aChar);
                } else {
                    // 不为空分类讨论
                    // 当待入栈符号与符号栈内符号比较时 优先级低于或者等于栈中元素时
                    // 符号栈中元素出栈,然后数栈出栈两个数进行运算后,将结果放入数栈
                    if (level(aChar) <= level((String) operatorStack.peek())) {
                        String popOperate = (String) operatorStack.pop();
                        int before = Integer.parseInt((String) numberStack.pop());
                        int last = Integer.parseInt((String) numberStack.pop());
                        int operRes = operation(before, last, popOperate);
                        numberStack.add(String.valueOf(operRes));
                        operatorStack.add(aChar);
                    } else {
                        // 当优先级大时直接进入
                        operatorStack.add(aChar);
                    }

                }
            }
        }
    }

    public void expressionReadEnd(MyStack numberStack, MyStack operatorStack) {
        while (true) {
            if (operatorStack.isEmpty()) {
                break;
            }
            // 当符号栈读取结束  符号栈出一符号 数栈出两个数
            String popOperator = (String) operatorStack.pop();
            int later = Integer.parseInt(String.valueOf(numberStack.pop()));
            int before = Integer.parseInt(String.valueOf(numberStack.pop()));
            int operation = operation(before, later, popOperator);
            numberStack.add(operation);
        }

    }

    /**
     * 运算操作
     * 当进行加法操作和除法操作时需要注意考虑栈的特点  是后边的减去或者除前边的
     *
     * @param beforeNumber
     * @param lateNumber
     * @param operate
     * @return
     */
    public int operation(int beforeNumber, int lateNumber, String operate) {
        switch (operate) {
            case "+":
                return beforeNumber + lateNumber;
            case "-":
                return lateNumber - beforeNumber;
            case "*":
                return beforeNumber * lateNumber;
            case "/":
                return lateNumber / beforeNumber;
            default:
                return -001;
        }

    }

    /**
     * 从表达式中取数或者符号
     *
     * @param expression
     * @return
     */
    public String getChar(String expression) {
        if (index >= expression.length()) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String substring = expression.substring(index, index + 1);
        if (isNumber(substring)){
            while (true){

                if (index+1 >= expression.length()-1){
                    break;
                }
                if (isNumber(expression.substring(index+1,index+2))){
                    substring = expression.substring(index, index + 1);
                    stringBuffer.append(substring);
                    index++;
                }else {
                    break;
                }
            }
        }

        stringBuffer.append(substring);
        index++;
        return stringBuffer.toString();
    }

    /**
     * 判断是否是数字
     *
     * @param numb
     * @return
     */
    public boolean isNumber(String numb) {
        if (numb != null) {
            boolean digit = Character.isDigit(numb.charAt(0));
            return digit;
        }
        return false;

    }

    /**
     * 判断是否是运算符
     *
     * @param operation
     * @return
     */
    public boolean isOperator(String operation) {
        Set set = new HashSet();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        if (set.contains(operation)) {
            return true;
        }
        return false;
    }

    /**
     * 判断运算符级别
     *
     * @param operation
     * @return
     */
    public int level(String operation) {
        if ("+".equals(operation) || "-".equals(operation)) {
            return 0;
        } else if ("*".equals(operation) || "/".equals(operation)) {
            return 1;
        }
        return -1;
    }

    public MyStack buildStack() {
        return new MyStack();
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();
        String a = "1000+2000";
        while (true){
            String aChar = c.getChar(a);
            System.out.println(aChar);
            if (aChar==null){
                break;
            }

        }




    }
}
