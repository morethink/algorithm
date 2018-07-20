package algorithm.leetcode;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 * 思路：
 * 操作数入栈；遇到操作符时，操作数出栈，求值，将结果入栈；
 * 当一遍后，栈顶就是表达式的值。因此逆波兰表达式的求值使用堆栈结构很容易实现，并且能很快求值。
 *
 * @author 李文浩
 * @date 2018/2/13
 */
public class L_150_EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] tokens = {"3", "4", "-", "5", "+"};
        System.out.println(evalRPN(tokens));
    }


    public static int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int num2 = operands.pop();
                int num1 = operands.pop();
                int num = 0;
                switch (token) {
                    case "+":
                        num = num1 + num2;
                        break;
                    case "-":
                        num = num1 - num2;
                        break;
                    case "*":
                        num = num1 * num2;
                        break;
                    case "/":
                        num = num1 / num2;
                        break;
                }
                operands.push(num);
            } else {
                operands.push(Integer.valueOf(token));
            }
        }
        return operands.peek();
    }
}
