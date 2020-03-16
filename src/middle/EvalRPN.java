package middle;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program:
 * @description:
 * @author: SY_zheng
 * @create: 2020-03-03
 */
public class EvalRPN {

    public static void main(String[] args) {

        String[] tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.err.println(new EvalRPN().methodTwo(tokens));
    }

    /**
     * 使用 if-else 加 stack，优化部分使用拆箱的 parseInt，减少拆箱操作。
     * @param tokens
     * @return
     */
    private int methodOne(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Map<String, String> map = new HashMap<>();
        map.put("*", "true");
        map.put("/", "true");
        map.put("+", "true");
        map.put("-", "true");
        for (String token : tokens) {
            int temp = 0;
            if (map.containsKey(token)) {

                if ("*".equals(token)) {
                    temp = stack.pop() * stack.pop();
                }
                else if ("+".equals(token)) {
                    temp = stack.pop() + stack.pop();
                }
                else if ("-".equals(token)) {
                    temp =  (temp - stack.pop() + stack.pop());
                }
                else if ("/".equals(token)) {
                    // 分母
                    int parent = stack.pop();
                    // 分子
                    int sun = stack.pop();
                    temp = sun / parent;
                }

                stack.push(temp);
                continue;
            }
            stack.push(Integer.parseInt(token));
        }
        return stack.pop();
    }

    /**
     * 利用 switch 优化 if-else
     * @param tokens
     * @return
     */
    private int methodTwo(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            int temp = 0;
            switch (token) {
                case "+":
                    temp = stack.pop() + stack.pop();
                    stack.push(temp);
                    break;
                case "-":
                    temp =  (temp - stack.pop() + stack.pop());
                    stack.push(temp);
                    break;
                case "*":
                    temp = stack.pop() * stack.pop();
                    stack.push(temp);
                    break;
                case "/":
                    // 分母
                    int parent = stack.pop();
                    // 分子
                    int sun = stack.pop();
                    temp = sun / parent;
                    stack.push(temp);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
