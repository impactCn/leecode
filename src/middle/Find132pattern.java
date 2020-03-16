package middle;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @program: 132模式
 * @description:
 * 给定一个整数序列：a1, a2, ..., an，一个132模式的子序列 ai, aj, ak 被定义为：当 i < j < k 时，ai < ak < aj。设计一个算法，当给定有 n 个数字的序列时，验证这个序列中是否含有132模式的子序列。
 *
 * 注意：n 的值小于15000。
 *
 * 示例1:
 *
 * 输入: [1, 2, 3, 4]
 *
 * 输出: False
 *
 * 解释: 序列中不存在132模式的子序列。
 * 示例 2:
 *
 * 输入: [3, 1, 4, 2]
 *
 * 输出: True
 *
 * 解释: 序列中有 1 个132模式的子序列： [1, 4, 2].
 * 示例 3:
 *
 * 输入: [-1, 3, 2, 0]
 *
 * 输出: True
 *
 * 解释: 序列中有 3 个132模式的的子序列: [-1, 3, 2], [-1, 3, 0] 和 [-1, 2, 0].
 * @author: SY_zheng
 * @create: 2020-03-13
 */
public class Find132pattern {

    public static void main(String[] args) {
        int[] nums = {3,5,0,3,4};
        System.err.println(new Find132pattern().methodTwo(nums));
    }


    /**
     * 穷举法，超时时间限制
     * @param nums
     * @return
     */
    private boolean methodOne(int[] nums) {

        LinkedList<Integer> stack = new LinkedList<>();

        for (int num : nums) {

            if (stack.size() >= 2) {
                for (int i = 0; i < stack.size(); i++) {
                    if (i == stack.size() - 1) {
                        break;
                    }
                    if (stack.get(i) < num) {
                        for (int j = i + 1; j < stack.size(); j++) {
                            if (stack.get(j) > num) {
                                return true;
                            }
                        }
                    }
                }
            }

            stack.addLast(num);
        }

        return false;
    }

    /**
     *
     * @param nums
     * @return
     */
    private boolean methodTwo(int[] nums) {
        if (nums.length < 3) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        
        int[] min = new int[nums.length];
        min[0] = nums[0];
        // 找出当前循环 i 范围的最小值
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > min[i]) {
                // 找到第二大数
                while (!stack.isEmpty() && stack.peek() <= min[i]) {
                    stack.pop();
                }
                // 找到最大值
                if (!stack.isEmpty() && stack.peek() < nums[i]) {
                    return true;
                }
                stack.push(nums[i]);
            }
        }
        return false;
    }
}
