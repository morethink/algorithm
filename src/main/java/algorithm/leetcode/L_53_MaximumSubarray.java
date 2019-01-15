package algorithm.leetcode;

/**
 * @author 李文浩
 * @date 2018/12/27
 */
public class L_53_MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new L_53_MaximumSubarray().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        if (nums.length == 1)
            return nums[0];

        int localMax = nums[0];
        int globalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            localMax = Math.max(nums[i] + localMax, nums[i]);
            globalMax = Math.max(localMax, globalMax);
        }

        return globalMax;

    }

}
