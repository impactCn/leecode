package simple;

/**
 * @program: 用栈实现队列
 * @description:
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * 说明:
 *
 * 你只能使用标准的栈操作 -- 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 * 假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）。
 *
 * @author: SY_zheng
 * @create: 2020-03-05
 */
public class MyQueue {

    private int[] queue;

    private int initCapacity = 2 << 4;

    /**
     * 记录数组的大小
     */
    private int n = -1;

    /**
     * 记录位置
     */
    private int location = 0;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.queue = new int[initCapacity];
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        queue[++n] = x;
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return queue[location++];
    }

    /** Get the front element. */
    public int peek() {
        return queue[location];
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return (n+1) == location;
    }
}
