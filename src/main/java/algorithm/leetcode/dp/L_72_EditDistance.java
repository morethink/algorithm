package algorithm.leetcode.dp;

/**
 * @author 李文浩
 * @date 2019-1-16
 */
public class L_72_EditDistance {
    public static void main(String[] args) {
        System.out.println(new L_72_EditDistance().minDistance("", ""));
        System.out.println(new L_72_EditDistance().minDistance("a", "b"));
        System.out.println(new L_72_EditDistance().minDistance("aa", "bb"));
        System.out.println(new L_72_EditDistance().minDistance("horse", "ros"));
        System.out.println(new L_72_EditDistance().minDistance("intention", "execution"));
        System.out.println(new L_72_EditDistance().minDistance("plasma", "altruism"));
    }

    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[n][m];
    }
}
