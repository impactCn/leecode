package simple;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: 有效的括号
 * @description:
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 * @author: SY_zheng
 * @create: 2020-02-29
 */
public class IsValid {

    public static void main(String[] args) {

    }

    /**
     * 利用 stack 数据结构解决
     * @param s
     * @return
     */
    private boolean methodOne(String s) {

        if (s == null || s.length() == 0) {
            return true;
        }

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        Deque<Character>  deque = new ArrayDeque<>();
        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                deque.push(c);
            } else {
                if (deque.size() == 0 || !map.get(c).equals(deque.pop())) {
                    return false;
                }
            }
        }
        return deque.size() == 0;

    }
}
