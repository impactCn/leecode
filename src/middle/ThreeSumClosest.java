package middle;

/**
 * @program: 最接近的三数之和
 * @description: 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 *
 * 例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
 *
 * 与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).
 * @author: SY_zheng
 * @create: 2020-01-09
 */
public class ThreeSumClosest {

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,4,8,16,32,64,128};
        int target = 82;
        System.err.println(ThreeSumClosest.methodOne(ints, target));
    }

    /**
     * @param nums
     * @param target
     * @return
     */
    public static int methodOne(int[] nums, int target) {

        if (nums.length < 3) {
            return 0;
        }

        int j = 1;
        int result = nums[0] + nums[1] + nums[2];

        return result;

    }
}
