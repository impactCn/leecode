package simple;

/**
 * @program: 两数之和
 * @description:
 * @author: SY_zheng
 * @create: 2019-07-13
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {

        int sum = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length ; j++) {
                sum = nums[i] + nums[j];
                if (sum == target) {
                    return new int[]{i, j};
                }
            }
            System.err.println("");
            sum = 0;
        }
        char[] a = null;
        return null;
    }


    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        System.err.println(twoSum.twoSum(new int[]{1, 2 }, 3)[0]);


    }

}
