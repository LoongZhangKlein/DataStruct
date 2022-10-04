package datastructure.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test {
    static void threadBinaryTree(){
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.threadBinaryTree();
        System.out.println(threadedBinaryTree);
    }
    static void arraysBinaryTree(){
        ArraysBinaryTree arraysBinaryTree = new ArraysBinaryTree(7);
        for (int i = 1; i < 8; i++) {
            arraysBinaryTree.add(i);
        }
        arraysBinaryTree.preOrder();

    }
    static void binaryTree(){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.buildTree();
        binaryTree.preOrder();
        binaryTree.remove(4);
        binaryTree.preOrder();
    }
    static Map trans(){
        HashMap map = new HashMap();
        map.put(1,"克");
        map.put(2,"莱");
        map.put(3,"因");
        System.out.println(map);
        return map;
    }
    static void change(Map map){
        map.put(4,"蓝");
        map.put(1,null);
        System.out.println(map);
    }
    public static void main(String[] args) {
        
        // binaryTree();
       // arraysBinaryTree();
        threadBinaryTree();
    }
}
