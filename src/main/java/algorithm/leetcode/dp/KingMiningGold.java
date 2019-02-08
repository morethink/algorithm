package algorithm.leetcode.dp;

/**
 * @author 李文浩
 * @date 2018/12/27
 */
public class KingMiningGold {
    public static void main(String[] args) {
        int g[] = {0, 200, 300, 350, 400, 500};
        int p[] = {0, 3, 2, 4, 5, 5};
        System.out.println(new KingMiningGold().kingMiningGold(g, p, 10));
    }

    /**
     *
     * @param g
     * @param p
     * @param sum
     * @return
     */
    public int kingMiningGold(int[] g, int[] p, int sum) {
        int m = g.length;
        int n = sum;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (j >= p[i - 1]) {
                    dp[i][j] = Math.max(dp[i - 1][j - p[i - 1]] + g[i - 1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

            }
        }
        for (int i = 0; i < m + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }

        return dp[m][n];
    }

}
