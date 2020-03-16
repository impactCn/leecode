package middle;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * @program: 简化路径
 * @description:
 * 以 Unix 风格给出一个文件的绝对路径，你需要简化它。或者换句话说，将其转换为规范路径。
 *
 * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..） 表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。更多信息请参阅：Linux / Unix中的绝对路径 vs 相对路径
 *
 * 请注意，返回的规范路径必须始终以斜杠 / 开头，并且两个目录名之间必须只有一个斜杠 /。最后一个目录名（如果存在）不能以 / 结尾。此外，规范路径必须是表示绝对路径的最短字符串。
 *
 * 示例 1：
 *
 * 输入："/home/"
 * 输出："/home"
 * 解释：注意，最后一个目录名后面没有斜杠。
 * 示例 2：
 *
 * 输入："/../"
 * 输出："/"
 * 解释：从根目录向上一级是不可行的，因为根是你可以到达的最高级。
 * 示例 3：
 *
 * 输入："/home//foo/"
 * 输出："/home/foo"
 * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
 * 示例 4：
 *
 * 输入："/a/./b/../../c/"
 * 输出："/c"
 * 示例 5：
 *
 * 输入："/a/../../b/../c//.//"
 * 输出："/c"
 * 示例 6：
 *
 * 输入："/a//b////c/d//././/.."
 * 输出："/a/b/c"
 *
 * @author: SY_zheng
 * @create: 2020-03-02
 */
public class SimplifyPath {

    public static void main(String[] args) {

//        String path = "/a//b////c/d//././/..";
//        System.err.println(new SimplifyPath().methodOne(path));

        System.err.println(true && false);

    }

    /**
     * 先通过stack，获取到需要的字符串，然后反转
     * @param path
     * @return
     */
    private String methodOne(String path) {

        if ("/".equals(path)) {
            return "/";
        }

        Stack<String> stack = new Stack<>();
        String[] pathArr = path.split("/");

        for (String s : pathArr) {
            if ( !"".equals(s)) {
                if ("..".equals(s) && stack.size() != 0) {
                    stack.pop();
                    continue;
                }
                if (".".equals(s)) {
                    continue;
                }
                if (stack.size() == 0 && "..".equals(s)) {
                    continue;
                }
                stack.push(s);
            }

        }
        if (stack.empty()) {
            return "/";
        }

        StringBuilder stringBuilder = new StringBuilder();

        for (String s : stack) {
            stringBuilder.append("/");
            stringBuilder.append(s);
        }
        return stringBuilder.toString();
    }
}
