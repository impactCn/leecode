package middle;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: 字符串解码
 * @description:
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * @author: SY_zheng
 * @create: 2020-03-06
 */
public class DecodeString {

    public static void main(String[] args) {

        String s = "3[a2[c]]";
        System.err.println(new DecodeString().methodThree(s));
    }

    /**
     * 不能解决 "3[a2[c]]", 返回 "accaccacc"
     * @param s
     * @return
     */
    private String methodOne(String s) {
        char[] chars = s.toCharArray();
        // 保存数字
        Stack<Integer> intStack = new Stack<>();

        // 保存字符串
        StringBuilder builder = new StringBuilder();
        // 数字
        StringBuilder intBuilder = new StringBuilder();
        StringBuilder finishString = new StringBuilder();

        for (int i = 0; i < chars.length; i++) {

            if (chars[i] == '[') {
                intStack.push(Integer.parseInt(intBuilder.toString()));
                intBuilder.setLength(0);
                continue;
            }
            if (chars[i] == ']') {
                int n = intStack.pop();
                String s1 = builder.toString();
                for (int j = 0; j < n - 1; j++) {

                    builder.append(s1);
                }
                finishString.append(builder);
                builder.setLength(0);
                continue;
            }
            // 连续
            if (Character.isDigit(chars[i])) {
                intBuilder.append(chars[i]);
                continue;
            }
            builder.append(chars[i]);

        }
        return finishString.append(builder).toString();
    }

    /**
     * 不能解决 "3[a2[c]]", 返回 "accaccacc"
     * @param s
     * @return
     */
    private String methodTwo(String s) {

        char[] chars = s.toCharArray();
        // 保存数字
        Stack<Integer> intStack = new Stack<>();
        Stack<String> strStack = new Stack<>();


        StringBuilder intBuilder = new StringBuilder();
        StringBuilder strBuilder = new StringBuilder();
        StringBuilder finish = new StringBuilder();
        for (char aChar : chars) {
            // 是数字
            if (Character.isDigit(aChar)) {
                intBuilder.append(aChar);
                if (strBuilder.length() > 0) {
                    strStack.push(strBuilder.toString());
                    strBuilder.setLength(0);
                }
            }
            // 是字母
            if (!Character.isDigit(aChar) && aChar != '[' && aChar != ']') {
                strBuilder.append(aChar);
            }
            if (aChar == '[') {
                // 数字压栈
                intStack.push(Integer.parseInt(intBuilder.toString()));
                // 初始化
                intBuilder.setLength(0);
            }
            if (aChar == ']') {
                int n = intStack.pop();

                if (strBuilder.length() > 0) {
                    strStack.push(strBuilder.toString());
                }

                // 初始化
                strBuilder.setLength(0);
                String string = strStack.pop();

                for (int i = 0; i < n; i++) {
                    strBuilder.append(string);
                }
                finish.append(strBuilder);
                strBuilder.setLength(0);
            }
        }
        return finish.toString();

    }

    private String methodThree(String s) {

        // 字符拼接
        StringBuilder res = new StringBuilder();
        int multi = 0;
        // 保存数字
        LinkedList<Integer> intStack = new LinkedList<>();
        // 保存字母
        LinkedList<String> strStack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '[') {
                intStack.addLast(multi);
                strStack.addLast(res.toString());
                multi = 0;
                res.setLength(0);
            }
            else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                int curIntStack = intStack.removeLast();
                for (int i = 0; i < curIntStack; i++) {
                    tmp.append(res);
                }
                res = new StringBuilder(strStack.removeLast() + tmp);
            }
            // 是数字
            else if (Character.isDigit(c)) {
                multi = multi * 10 + Integer.parseInt(c + "");
            }
            // 字符
            else {
                res.append(c);
            }
        }
        return res.toString();

    }
}
