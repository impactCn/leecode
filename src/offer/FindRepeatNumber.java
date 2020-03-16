package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: SY_zheng
 * @create: 2020-02-13
 */
public class FindRepeatNumber {

    public static void main(String[] args) {

        int[] nums = new int[]{0, 11, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        FindRepeatNumber findRepeatNumber = new FindRepeatNumber();
        findRepeatNumber.methodOne(nums);

    }


    /**
     * 暴力破解
     * @param nums
     * @return
     */
    private int methodOne(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.err.println(nums[i]);
            for (int j = i + 1; j < nums.length; j++) {

                if (nums[i] == nums[j]) {
                    return nums[i];
                }
            }
        }
        return nums[0];
    }

    /**
     * 使用 HashMap 特性
     * @param nums
     * @return
     */
    private int methodTwo(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i])) {
                return nums[i];
            } else {
                map.put(nums[i], 1);
            }

        }

        return nums[0];
    }

}
