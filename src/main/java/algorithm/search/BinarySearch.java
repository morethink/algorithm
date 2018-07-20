package algorithm.search;

/**
 * 二分查找的时间复杂度是 O(lg n)
 * 二分查找的查找要求是有序数组
 *
 * @author 李文浩
 * @version 2017/8/5.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println(binarySearch.bsearchWithoutRecursion(a, 2));
    }

    /**
     * 递归
     *
     * @param array
     * @param low
     * @param high
     * @param target
     * @return
     */
    int binarysearch(int array[], int low, int high, int target) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (array[mid] > target)
            return binarysearch(array, low, mid - 1, target);
        if (array[mid] < target)
            return binarysearch(array, mid + 1, high, target);
        return mid;
    }

    /**
     * 非递归
     *
     * @param a
     * @param key
     * @return
     */
    int bsearchWithoutRecursion(int a[], int key) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] > key)
                high = mid - 1;
            else if (a[mid] < key)
                low = mid + 1;
            else
                return mid;
        }
        return -1;
    }


}
