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

    public static boolean isValid(String s) {
        // 接收输入符号
        char[] chars = s.toCharArray();
        // 创建左符号栈
        Stack<String> leftBracketStack = new Stack();
        // 创建右符号栈
        Stack<String> rightBracketStack = new Stack<>();
        // 所有可匹配的符号
        HashMap<String, String> leftRightBracketMap = new HashMap<>(3);
        leftRightBracketMap.put("(", ")");
        leftRightBracketMap.put("[", "]");
        leftRightBracketMap.put("{", "}");
        Set<String> leftBracketSet = leftRightBracketMap.keySet();
        for (int i = 0; i < chars.length; i++) {
            String str = String.valueOf(chars[i]);
            // 左括号必须以相应的顺序闭合
            // 若为左括号进入左括号栈
            // 进入后判断右括号栈是否为空,为空直接返回false,不为空出栈,若不匹配直接返回false
            if (!leftBracketStack.isEmpty()){
                if (!str.equals(leftRightBracketMap.get(leftBracketStack.pop()))){
                    return false;
                }else{
                    continue;
                }
            }
            if (leftBracketSet.contains(str)) {
                // 若是左符号,左符号栈若为空直接入栈
                if (leftBracketStack.isEmpty()){
                    leftBracketStack.add(str);
                    continue;
                }
                if (leftBracketStack.contains(str)){
                    return false;
                }
                leftBracketStack.add(str);
                // 做符号栈不为空,且当次入栈符号在符号栈中存在直接返回 false
                // 符号栈不为空,且当次入栈符号在符号栈中不存在直接入栈


                if (!leftBracketStack.isEmpty() && !rightBracketStack.isEmpty()){
                    if (!(leftRightBracketMap.get(leftBracketStack.pop()).equals(rightBracketStack.pop()))){
                        return false;
                    }
                }
                // 左括号进入左符号栈
                leftBracketStack.add(str);


            } else {
                //有括号进入右括号栈
                rightBracketStack.add(str);
            }
        }
        // 若左右符号栈个数不一致直接返回错误
        if (leftBracketStack.size() != rightBracketStack.size()) {
            return false;
        }
        // 个数一致
        while (!leftBracketStack.isEmpty()){
            String leftBracket = leftBracketStack.pop();
            // 如果右符号栈存在配对符号 出栈
            if (rightBracketStack.contains(leftRightBracketMap.get(leftBracket))){
                rightBracketStack.remove(leftRightBracketMap.get(leftBracket));
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "{[]}";
        boolean valid = isValid(s);
        System.out.println(valid);
    }
}
