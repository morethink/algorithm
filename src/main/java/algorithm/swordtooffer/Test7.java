package algorithm.swordtooffer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 *
 * @author 李文浩
 * @version 2017/8/5.
 */
public class Test7 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public static void main(String[] args) {
        Test7 queue = new Test7();
        queue.push(1);
        queue.push(2);
        queue.push(3);
//        queue.push(4);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
//        System.out.println(queue.pop());
    }
    public void push(int node) {

        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(node);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public int pop() {
        return stack1.pop();
    }

}
