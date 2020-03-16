package simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: 下一个更大元素 I
 * @description:
 * 给定两个没有重复元素的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。找到 nums1 中每个元素在 nums2 中的下一个比其大的值。
 *
 * nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出-1。
 *
 * 示例 1:
 *
 * 输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * 输出: [-1,3,-1]
 * 解释:
 *     对于num1中的数字4，你无法在第二个数组中找到下一个更大的数字，因此输出 -1。
 *     对于num1中的数字1，第二个数组中数字1右边的下一个较大数字是 3。
 *     对于num1中的数字2，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 示例 2:
 *
 * 输入: nums1 = [2,4], nums2 = [1,2,3,4].
 * 输出: [3,-1]
 * 解释:
 *     对于num1中的数字2，第二个数组中的下一个较大数字是3。
 *     对于num1中的数字4，第二个数组中没有下一个更大的数字，因此输出 -1。
 * 注意:
 *
 * nums1和nums2中所有元素是唯一的。
 * nums1和nums2 的数组大小都不超过1000。
 * @author: SY_zheng
 * @create: 2020-03-15
 */
public class NextGreaterElement {

    public static void main(String[] args) {

        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        System.err.println(Arrays.toString(new NextGreaterElement().methodOne(nums1, nums2)));


    }


    /**
     * 穷举法
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] methodOne(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    // 存在子集
                    if (j == nums2.length - 1) {
                        result[i] = -1;
                        break;
                    }
                    for (int k = j + 1; k < nums2.length; k++) {
                        if (nums1[i] < nums2[k]) {
                            result[i] = nums2[k];
                            break;
                        }
                    }
                }
            }
            if (result[i] == 0) {
                result[i] = -1;
            }

        }
        return result;
    }

    /**
     *
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] methodTwo(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(nums2.length);
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums1.length];
        // 寻找下一个大数
        for (int i = 0; i < nums2.length; i++) {

            while (!stack.empty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        // 还在 stack 意味着没有找到下一个大数
        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < res.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
