package algorithm.leetcode.dp;

/**
 * @author 李文浩
 * @date 2019-1-20
 */
public class L_494_TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 12, 4, 9, 2, 3, 4, 5};
        System.out.println(new L_494_TargetSum().findTargetSumWays(nums, 10));
        int[] nums2 = {1000};
        System.out.println(new L_494_TargetSum().findTargetSumWays(nums2, -1000));
        int[] nums3 = {1, 2, 7, 9, 981};
        System.out.println(new L_494_TargetSum().findTargetSumWays(nums3, 1000000000));
        int[] nums4 = {0, 0, 0, 0, 0, 0, 0, 0, 1};
        System.out.println(new L_494_TargetSum().findTargetSumWays(nums4, 1));
        int[] nums5 = {1, 1, 1, 1, 1};
        System.out.println(new L_494_TargetSum().findTargetSumWays(nums5, 3));
    }

    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (S > sum || S < -sum) {
            return 0;
        }
        int[][] dp = new int[nums.length + 1][sum * 2 + 1];
        dp[0][0 + sum] = 1;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum * 2; j++) {
                if (j - nums[i - 1] >= 0) {
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                }
                if (j + nums[i - 1] <= 2 * sum) {
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
                }
            }
        }
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= sum * 2; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[nums.length][S + sum];
    }
}
