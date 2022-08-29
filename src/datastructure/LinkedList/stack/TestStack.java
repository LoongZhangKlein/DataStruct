package datastructure.LinkedList.stack;

import java.util.Stack;

public class TestStack {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.add("我");
        stack.add("是");
        stack.add("你");
        stack.add("吗");
        System.out.println(stack.size());
        while (!stack.empty()){
            String pop = stack.pop();
            System.out.println(pop);
        }


    }
}
