package test;

import java.util.*;

public class DoublyLinkList {

    public static void main(String[] args) {
        HashMap<Integer,UUID> map = new HashMap(16);
        for (int i = 0; i <10; i++) {
            UUID a= UUID.randomUUID();
            System.out.println(i+"=>"+a);
            map.put(i,a);
        }

        for (Map.Entry res:map.entrySet()){
            System.out.printf("键{%s}===>值{%s}",res.getKey(),res.getValue());
            System.out.println();
        }
        System.out.println("========================");
        TreeMap<Integer,UUID> treeMap = new TreeMap();
        for (int i = 0; i <5; i++) {
            UUID a= UUID.randomUUID();
            System.out.println(i+"=>"+a);
            treeMap.put(i,a);
        }
        for (Map.Entry res:treeMap.entrySet()){
            System.out.println(res.getKey()+" "+res.getValue());
        }
    }

}
