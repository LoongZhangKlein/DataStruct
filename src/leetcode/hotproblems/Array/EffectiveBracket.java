package leetcode.hotproblems.Array;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class EffectiveBracket {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public static boolean isValid(String s) {
        List<Character> list = new ArrayList();
        HashSet hashSet = new HashSet();
        hashSet.add('(');
        hashSet.add('[');
        hashSet.add('{');
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (hashSet.contains(chars[i])) {
                list.add(chars[i]);
            } else {
                if (')'==(chars[i])){
                    int i1 = list.indexOf('(');
                    if (list.size()>1){
                        if (list.get(list.size()-1)!='(' || list.indexOf('(')==-1  ){
                            return false;
                        }else{
                            list.remove(list.size()-1);
                        }
                    }


                }
                if (']'==(chars[i])){
                    if (list.size()>1){
                        if (list.get(list.size()-1)!='[' || list.indexOf('[')==-1  ){
                            return false;
                        }else{
                            list.remove(list.size()-1);
                        }
                    }


                }
                if ('}'==(chars[i])){
                    if(list.size()>1){
                        if (list.get(list.size()-1)!='{' || list.indexOf('{')==-1  ){
                            return false;
                        }else{
                            list.remove(list.size()-1);
                        }
                    }


                }
            }
        }
        if (list.size()==0){
            return true;
        }else{
            return false;
        }

    }

    public static void main(String[] args) {

        String s = "()";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
}
