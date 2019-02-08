package algorithm.sort;

import java.util.Stack;

/**
 * @author 李文浩
 * @date 2018/11/16
 */
public class Test1 {
    public static void main(String[] args) {
        String s1 = "12ddddd3##";
        Stack<Character> stack1 = new Stack<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != '#') {
                stack1.push(s1.charAt(i));
            } else {
                if (!stack1.isEmpty()) {
                    stack1.pop();
                }
            }
        }

        String s2 = "dddd###DDDD";
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < s2.length(); i++) {
            if (s2.charAt(i) != '#') {
                stack2.push(s2.charAt(i));
            } else {
                if (!stack2.isEmpty()) {
                    stack2.pop();
                }
            }
        }
        boolean result = false;
        while ((!stack1.isEmpty() && !stack2.isEmpty()) && (stack1.peek() == stack2.peek())) {
            stack1.pop();
            stack2.pop();
        }
        if (stack1.isEmpty() && stack2.isEmpty()) {
            result = true;
        }
        System.out.println(result);

    }
}
