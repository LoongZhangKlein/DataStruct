package leetcode;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Day02 {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listRes = new ArrayList();


        for (int i =1; i <= numRows; i++) {
            ArrayList<Integer> list = new ArrayList();
            for (int j=0;j<i;j++){
                if (j==0||j==i){
                    list.add(1);
                }else if (i==1||i==2||j==i-1){
                    list.add(1);
                }else {
                    int lastRes=listRes.get(i-2).get(j-1)+listRes.get(i-2).get(j);
                    list.add(lastRes);
                }
                listRes.add(list);
            }

        }
    return listRes;
    }

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(5);
        for (int i = 0; i < generate.size(); i++) {
            System.out.println(generate.get(i));
        }
    }


}
