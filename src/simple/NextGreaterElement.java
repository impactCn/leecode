package simple;

import java.util.Arrays;

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

        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.err.println(Arrays.toString(new NextGreaterElement().methodOne(nums1, nums2)));


    }


    /**
     * 穷举
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] methodOne(int[] nums1, int[] nums2) {

        int[] result = new int[nums1.length];
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int temp = 0;
            if (nums1[i] >= nums2.length) {
                result[i] = -1;
            } else  {
                temp = nums2[nums1[i]] + count;
                if (temp > nums2.length) {
                    result[i] = -1;
                    continue;
                }
                result[i] = nums2[nums1[i]];
                count++;
            }
        }
        return result;

    }
}
