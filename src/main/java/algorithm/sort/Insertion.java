package algorithm.sort;

/**
 * @author 李文浩
 * @date 2018/1/25
 */
public class Insertion {

    /**
     * 通过交换进行插入排序，借鉴冒泡排序
     *
     * @param a
     */
    public static void sort(int[] a) {
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int temp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 通过将较大的元素都向右移动而不总是交换两个元素
     *
     * @param a
     */
    public static void sort2(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int num = a[i];
            int j;
            for (j = i; j > 0 && num < a[j]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = num;
        }
    }
}
