package algorithm;

import java.util.*;

/**
 * @program:
 * @description:
 * @author: SY_zheng
 * @create: 2020-03-08
 */
public class Greedy {

    public static void main(String[] args) {

        int capacity = 150;
        int[] weights = {35, 30, 60, 50, 40, 10, 25};
        int[] values = {10, 40, 30, 50, 35, 40, 30};
        new Greedy().bag(capacity, weights, values);
    }

    /**
     * 背包问题
     * @param capacity
     * @param weights
     * @param values
     */
    private void bag(int capacity, int[] weights, int[] values) {
        // n 代码商品数量
        int n = weights.length;
        // 新建一个 map 来记录性价比
        Map<Integer, Float> map = new HashMap<>();
        // 遍历求出性价比
        for (int i = 0; i < n; i++) {
            map.put(i, (float) values[i] / weights[i]);

        }
        List<Map.Entry<Integer, Float>> list = new ArrayList<>(map.entrySet());
        // 根据性价比排序
        list.sort((t1, t2) -> t2.getValue().compareTo(t1.getValue()));
        // 记录商品
        int[] path = new int[n];
        int maxValue = 0;
        int maxWeight = 0;
        for (Map.Entry<Integer, Float> entry : list) {
            int index = entry.getKey();
            if (weights[index] <= capacity) {
                path[index] = 1;
                capacity -= weights[index];
                maxValue += values[index];
                maxWeight += weights[index];
            }
        }
        System.err.println(maxValue);
        System.err.println(maxWeight);
    }
}
