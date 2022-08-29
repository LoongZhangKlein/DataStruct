package leetcode.hotproblems.Array;

import java.util.ArrayList;
import java.util.List;

public class HanMingDistance {
   /* public  static int hammingDistance(int x, int y) {
    return 1;
    }*/
    public static int hammingDistance(int x, int y) {
        int s = x ^ y, ret = 0;
        while (s != 0) {
            ret =ret+(s & 1) ;
            s >>= 1;
        }
        return ret;
    }
    public static void main(String[] args) {
        int list = hammingDistance(4, 1);
        System.out.println(list);
        System.out.println("=============");
        System.out.println(3^1);
        System.out.println("========");
        System.out.println(-256&1);
        System.out.println(1&5);
        int a=8;
        System.out.println(a>>2);
        System.out.println(a<<2);
    }
}
