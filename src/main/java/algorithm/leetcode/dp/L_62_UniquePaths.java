package algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * @author 李文浩
 * @date 2018/12/27
 */
public class L_62_UniquePaths {
    public static void main(String[] args) {
        System.out.println(new L_62_UniquePaths().uniquePaths(3, 3));
        System.out.println(new L_62_UniquePaths().uniquePaths(7, 3));
    }

    /**
     * 实际上是跳台阶的二维变种
     * 状态转移公式：
     * F(n,m) = F(n-1,m)+F(n,m-1)
     * 边界条件：
     * 当m或n==0时，只有1种方式。
     *
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], 1);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[n - 1][m - 1];
    }

}
