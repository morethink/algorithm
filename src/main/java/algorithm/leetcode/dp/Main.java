package algorithm.leetcode.dp;

/**
 * @author 李文浩
 * @date 2019-1-26
 */
public class Main {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int n = 0;
        //if (in.hasNextLine()) {
        //    n = Integer.parseInt(in.nextLine());
        //}
        //int[] nums = new int[1000];
        //int i = 0;
        //while (i < 1000 && in.hasNextInt()) {
        //    nums[i++] = in.nextInt();
        //}
        //
        //System.out.println(new Main().danceRoom(n, nums));

        int[] nums1 = {1, 2};
        System.out.println(new Main().danceRoom(2, nums1));

    }

    public int danceRoom(int n, int[] p) {
        int[][] dp = new int[n + 1][n + 1];
        dp[1][1] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = 0;
            }
        }
        return 0;
    }
}
