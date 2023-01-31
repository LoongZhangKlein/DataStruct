package leetcode.hotproblems.Array;

import com.sun.deploy.util.StringUtils;

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
     *
     * @param s
     * @return
     */

    /**
     * 实现方法一
     */
    private static final Map<Character, Character> bracketMap = new HashMap<Character, Character>(3) {{
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    public static boolean isValid(String s) {
        Stack<Character> charactersStack = new Stack<>();
        char[] chars = s.toCharArray();
        // 不为偶数个一定不匹配
        if (chars.length % 2 != 0 || s == null) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            // 左符号入栈
            if (bracketMap.containsKey(chars[i])) {
                charactersStack.add(chars[i]);
            } else {
                // 遇到右符号 查找栈内左符号
                if (charactersStack.isEmpty()) {
                    return false;
                }
                if (!bracketMap.get(charactersStack.pop()).equals(chars[i])) {
                    return false;
                }
            }
        }
        if (!charactersStack.isEmpty()) {
            return false;
        }
        return true;
    }

    private static final Map<Character, Character> bracketMapTwo = new HashMap<Character, Character>(4) {{
       // put('?', '?');
        put('(', ')');
        put('{', '}');
        put('[', ']');
    }};

    /**
     * 实现方法二
     *
     * @param s
     * @return
     */
    public static boolean isValidTwo(String s) {
        // 若长度为0 且第一字符串不存在
        if (s.length() > 0 && !bracketMapTwo.containsKey(s.toCharArray()[0])) {
            return false;
        }
        Stack<Character> charactersStack = new Stack<>();
        charactersStack.add('?');
        for (Character character : s.toCharArray()) {
            // 若map中存在则往占中添加
            if (bracketMapTwo.containsKey(character)) {
                charactersStack.add(character);
            } else {
                if (!character.equals(bracketMapTwo.get(charactersStack.pop()))) {
                    return false;
                }
            }
            // 符号map不存在出栈相等则ture,不相等则false
        }
        if (charactersStack.size()>=1){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "(){}}{";
        boolean valid = isValidTwo(s);
        System.out.println(valid);
    }
}
