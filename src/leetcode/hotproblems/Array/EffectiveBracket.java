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
    /**
     * 该实现思路加上左括号的闭合顺序即可
     * @param s
     * @return
     */

    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack leftBracketStack = new Stack();
        HashMap<String, String> map = new HashMap<>();
        map.put("(",")");
        map.put("[","]");
        map.put("{","}");
        Stack<String> rightBracketStack = new Stack<>();
        Set<String> strings = map.keySet();
        for (int i = 0; i < chars.length; i++) {
            String str=String.valueOf(chars[i]);
            if (strings.contains(str)) {
                leftBracketStack.add(str);
            } else {
                rightBracketStack.add(str);
            }
        }
        if (leftBracketStack.size() != rightBracketStack.size()) {
            return false;
        }
        while (!leftBracketStack.isEmpty()) {
            String pop = (String) leftBracketStack.pop();
            if (rightBracketStack.contains(map.get(pop))){
                rightBracketStack.remove(map.get(pop));
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "([)]";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
}
