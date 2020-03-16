package middle;

import java.util.HashMap;
import java.util.Map;

/**
 * @program:
 * @description:
 * @author: SY_zheng
 * @create: 2020-03-03
 */
public class MinStack {

    /**
     * 容器
     */
    private Integer[] list;

    /**
     * 初始化容器大小
     */
    private final int initCapacity = 2 << 13 - 1;

    /**
     * 指针位置
     */
    private int n = -1;
    /** initialize your data structure here. */
    public MinStack() {
         this.list = new Integer[initCapacity];
    }

    public void push(int x) {
        n++;
        list[n] = x;
    }

    public void pop() {
        n--;
    }

    public int top() {
        return list[n];
    }

    public int getMin() {
        int temp = list[0];
        for (int i = 1; i <= n; i++) {
            if (temp > list[i]) {
                temp = list[i];
            }
        }
        return temp;
    }

    public static void main(String[] args) {

        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        System.err.println( minStack.getMin());
        System.err.println(minStack.top());
        minStack.pop();

        System.err.println( minStack.getMin());


    }
}
