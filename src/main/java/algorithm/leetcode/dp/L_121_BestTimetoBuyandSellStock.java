package algorithm.leetcode.dp;

/**
 * @author 李文浩
 * @date 2018/5/6
 */
public class L_121_BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new L_121_BestTimetoBuyandSellStock().maxProfit(prices));

    }

    /**
     * max = max{max,prices[i]-min}
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            min = Math.min(min, price);
            max = Math.max(max, price - min);
        }
        return max;
    }
}
