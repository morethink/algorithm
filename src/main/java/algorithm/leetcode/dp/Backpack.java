package algorithm.leetcode.dp;

/**
 * @author 李文浩
 * @date 2018/5/4
 */
public class Backpack {
    public static int getMaxValue(int[] weight, int[] value, int w) {
        int length = value.length;
        int[][] table = new int[length][w + 1];
        for (int i = 1; i < length; i++) { //物品
            for (int j = 1; j <= w; j++) {  //背包大小
                if (weight[i] > j) {
                    //当前物品i的重量比背包容量j大，装不下，肯定就是不装
                    table[i][j] = table[i - 1][j];
                    // System.out.print(table[i][j]+ " ");
                } else { //装得下，Max{装物品i， 不装物品i}
                    table[i][j] = Math.max(table[i - 1][j], table[i - 1][j - weight[i]] + value[i]);
                    //System.out.print(table[i][j]+ " ");
                }
            }
            // System.out.println();
        }
        return table[length - 1][w];
    }

    public static void main(String[] args) {

        int w = 11;                    //物品个数，背包容量
        int[] value = {0, 6, 3, 5, 4, 6};     //各个物品的价值
        int[] weight = {0, 2, 2, 6, 5, 4};    //各个物品的重量
        System.out.println(getMaxValue(weight, value, w));

    }
}
