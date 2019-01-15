package algorithm.leetcode;

/**
 * @author 李文浩
 * @date 2018/12/15
 */
public class L_35_SearchInsertPosition {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6, 8};
        int n = 7;
        System.out.println(new L_35_SearchInsertPosition().searchInsert(nums, 0));
        System.out.println(new L_35_SearchInsertPosition().searchInsert(nums, 2));
        System.out.println(new L_35_SearchInsertPosition().searchInsert(nums, 3));
        System.out.println(new L_35_SearchInsertPosition().searchInsert(nums, 6));
        System.out.println(new L_35_SearchInsertPosition().searchInsert(nums, 7));
        System.out.println(new L_35_SearchInsertPosition().searchInsert(nums, 10));

    }

    /**
     * 二分查找
     * 没找到的话low 代表插入的序号
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
