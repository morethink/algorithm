package algorithm.leetcode.dp;

/**
 * @author 李文浩
 * @date 2018/12/27
 */
public class L_64_MinimumPathSum {
    public static void main(String[] args) {
        int[][] nums = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new L_64_MinimumPathSum().minPathSum(nums));
        int[][] nums2 = {
                {1, 0}
        };
        System.out.println(new L_64_MinimumPathSum().minPathSum(nums2));
    }

    /**
     * 62题变种而已
     *
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 1; i < n; i++) {
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < m; i++) {
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];
            }
        }
        return grid[n - 1][m - 1];
    }

}
