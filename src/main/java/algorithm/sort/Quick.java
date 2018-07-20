package algorithm.sort;

import java.util.Stack;

/**
 * Created by think on 2016/9/16.
 */
public class Quick {
    public static void sort(int[] a, int low, int high) {
        //已经排完
        if (low >= high) {
            return;
        }
        int left = low;
        int right = high;

        //保存基准值
        int pivot = a[left];
        while (left < right) {
            //从后向前找到比基准小的元素
            while (left < right && a[right] >= pivot)
                right--;
            a[left] = a[right];
            //从前往后找到比基准大的元素
            while (left < right && a[left] <= pivot)
                left++;
            a[right] = a[left];
        }
        // 放置基准值，准备分治递归快排
        a[left] = pivot;
        sort(a, low, left - 1);
        sort(a, left + 1, high);
    }


    public static void sortThreeWay(int[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int v = a[lo], lt = lo, i = lo + 1, gt = hi;
        while (i <= gt) {
            if (a[i] < v) {
                swap(a, i++, lt++);
            } else if (a[i] > v) {
                swap(a, i, gt--);
            } else {
                i++;
            }
        }
        sortThreeWay(a, lo, lt - 1);
        sortThreeWay(a, gt + 1, hi);
    }

    private static void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void sortByStack(int[] a) {
        Stack<Integer> stack = new Stack<Integer>();

        //初始状态的左右指针入栈
        stack.push(0);
        stack.push(a.length - 1);
        while (!stack.isEmpty()) {
            //出栈进行划分
            int high = stack.pop();
            int low = stack.pop();

            int pivotIndex = partition(a, low, high);

            //保存中间变量
            if (pivotIndex > low) {
                stack.push(low);
                stack.push(pivotIndex - 1);
            }
            if (pivotIndex < high && pivotIndex >= 0) {
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }

    private static int partition(int[] a, int low, int high) {
        if (low >= high) return -1;
        int left = low;
        int right = high;
        //保存基准的值
        int pivot = a[left];
        while (left < right) {
            //从后向前找到比基准小的元素，插入到基准位置中
            while (left < right && a[right] >= pivot) {
                right--;
            }
            a[left] = a[right];
            //从前往后找到比基准大的元素
            while (left < right && a[left] <= pivot) {
                left++;
            }
            a[right] = a[left];
        }
        //放置基准值，准备分治递归快排
        a[left] = pivot;
        return left;
    }
}
