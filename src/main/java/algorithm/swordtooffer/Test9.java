package algorithm.swordtooffer;

/**
 * @author 李文浩
 * @version 2017/8/5.
 */
public class Test9 {
    public static void main(String[] args) {
        Test9 test9 = new Test9();
        System.out.println(test9.Fibonacci(10));
        System.out.println(test9.Fibonacci2(10));
    }


    /**
     * 为什么不采用递归？因为递归实际是大量调用自身，当数量足够大的时候，需要同时保存成千上百个调用记录，容易发生内存溢出。
     * 怎么优化？
     * 1. 采用尾递归，但是Java并没有基于尾递归进行优化，也就是说Java中采用递归还是无法避免很容易发生"栈溢出"错误（stack overflow）。
     * 因为尾递归都是位于调用函数的最后一行，此时可以删除以前所保存的函数内变量，想当于每次只调用了一个函数。
     * 2. 采用迭代
     *
     * @param n
     * @return
     */
    public int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        }
        int f1 = 0, f2 = 1;
        for (int i = 1; i <= n; i++) {
            f1 = f1 + f2;
            f2 = f1 - f2;
        }
        // 下面这种写法更为巧妙
//        while (n-- > 0) {
//            f1 = f1 + f2;
//            f2 = f1 - f2;
//        }
        return f1;
    }


    /**
     * 采用递归的方式
     *
     * @param n
     * @return
     */
    public int Fibonacci2(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return Fibonacci2(n - 1) + Fibonacci2(n - 2);
        }
    }
}
