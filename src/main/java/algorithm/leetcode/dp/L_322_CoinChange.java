package algorithm.leetcode.dp;

import java.util.Arrays;

/**
 * @author 李文浩
 * @date 2018/4/23
 */
public class L_322_CoinChange {
    public static void main(String[] args) {
        System.out.println(new L_322_CoinChange().coinChange(new int[]{1, 3, 5}, 4));
        System.out.println(new L_322_CoinChange().coinChange(new int[]{1}, 1));
        System.out.println(new L_322_CoinChange().coinChange(new int[]{2}, 1));
    }

    /**
     * 状态转移方程：
     * dp[i] = min(dp[i-coins[0]]...dp[i-coins[j]]...dp[i-coins[coins.len-1]])+1
     *
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            boolean flag = false;
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != -1) {
                    flag = true;
                    min = Math.min(min, dp[i - coin]);
                }
            }
            if (flag) {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }
}
