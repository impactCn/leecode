package simple;

import java.util.List;

/**
 * @program: 用队列实现栈
 * @description:
 * 使用队列实现栈的下列操作：
 *
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 * 注意:
 *
 * 你只能使用队列的基本操作-- 也就是 push to back, peek/pop from front, size, 和 is empty 这些操作是合法的。
 * 你所使用的语言也许不支持队列。 你可以使用 list 或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 你可以假设所有操作都是有效的（例如, 对一个空的栈不会调用 pop 或者 top 操作）。
 *
 * @author: SY_zheng
 * @create: 2020-03-05
 */
public class MyStack {

    private int[] stack;

    /**
     * 初始化大小
     */
    private final int initCapacity = 2 << 13 - 1;

    /**
     * 指针
     */
    private int n = -1;


    /** Initialize your data structure here. */
    public MyStack() {
        this.stack = new int[initCapacity];
    }

    /** Push element x onto stack. */
    public void push(int x) {
        stack[++n] = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return stack[n--];
    }

    /** Get the top element. */
    public int top() {


        return stack[n];
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        System.err.println(n);
        if (n == -1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(1);
        System.err.println(myStack.top());
        System.err.println(myStack.pop());
        System.err.println(myStack.empty());


    }

}
