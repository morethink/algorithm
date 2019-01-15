package algorithm.leetcode.dp;

/**
 * @author 李文浩
 * @date 2018/12/27
 */
public class L_70_ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(new L_70_ClimbingStairs().climbStairs(1));
        System.out.println(new L_70_ClimbingStairs().climbStairs(2));
        System.out.println(new L_70_ClimbingStairs().climbStairs(3));
        System.out.println(new L_70_ClimbingStairs().climbStairs(4));
        System.out.println(new L_70_ClimbingStairs().climbStairs(5));
    }

    /**
     * 实际类似斐波那契数列
     * 状态转移方程：
     * F(n) = F(n-1)+F(n-2)
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int temp = b;
            b = b + a;
            a = temp;
        }
        return b;
    }

}
