package leetcode;


import java.util.*;

public class Day07 {

/*a-a-b-c-c-c-c-c-a-a-a*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] split = scanner.nextLine().split("-");
        ArrayList list = new ArrayList();
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }

        for (int i=0;i<list.size()-2;i++){
            int flag=i+1;
            for (int j=flag;j<list.size();j++){
                if (list.get(i).equals(list.get(j))){
                    list.remove(j);
                    j=flag-1;
                }
            }
        }
        for (Object res:list) {
            System.out.println(res);
        }
    }
}
