package middle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @program: 三数之和
 * @description: 给定一个包含 n 个整数的数组 nums，判断 nums 
 * 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 *
 * 满足要求的三元组集合为：
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * @author: SY_zheng
 * @create: 2020-01-06
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] ints = new int[]{-1, 0, 1, 2, -1, -4};
        System.err.println(new ThreeSum().methodOne(ints));
    }

    public List<List<Integer>> methodOne(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        int j = 1;


        for (int i = 0; i < nums.length - 2; i++ ,j++) {
            for (int k = j; k < nums.length; k++) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);

                    if (!lists.isEmpty()) {
                        for (List<Integer> integers : lists) {
                            if (integers.contains(nums[i])
                            && integers.contains(nums[j])
                            && integers.contains(nums[k])) {
                                break;
                            }
                        }
                    }
                    list.sort(Integer::compareTo);
                    if (lists.contains(list)) {
                        continue;
                    }
                    lists.add(list);

                }
            }
        }
        return lists;
    }
}
