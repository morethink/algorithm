package algorithm.leetcode.dp;

/**
 * @author 李文浩
 * @date 2018/12/27
 */
public class L_63_UniquePathsII {
    public static void main(String[] args) {
        int[][] nums = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println(new L_63_UniquePathsII().uniquePathsWithObstacles(nums));
        int[][] nums2 = {
                {1, 0}
        };
        System.out.println(new L_63_UniquePathsII().uniquePathsWithObstacles(nums2));
    }

    /**
     * 其实跟62题很像，只不过需要先处理一下数据
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 1;
        }
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            dp[0][i] = 1;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
