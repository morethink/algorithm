package algorithm.sort;

/**
 * @author 李文浩
 * @date 2018/2/3
 */
public class Heap {

    public static void main(String[] args) {
        int[] a = {10, 2, 6, 3, 50, 26, 34, 6};
//        int[] a = new int[20];
//        for (int i = 0; i < a.length; i++)
//            a[i] = (int) (Math.random() * 10000);
//        num[0] = 0;
        System.out.print("排序前: ");
        for (int n : a)
            System.out.print(n + " ");
        System.out.println();
        Heap.sort(a);
        System.out.print("排序后: ");
        for (int i : a)
            System.out.print(i + " ");
    }

    /**
     * @param a
     */
    public static void sort(int[] a) {

        for (int i = a.length - 1; i > 0; i--) {
            max_heapify(a, i);

            //堆顶元素(第一个元素)与Kn交换
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
        }
    }

    /***
     *
     *  将数组堆化
     *  i = 第一个非叶子节点。
     *  从第一个非叶子节点开始即可。无需从最后一个叶子节点开始。
     *  叶子节点可以看作已符合堆要求的节点，根节点就是它自己且自己以下值为最大。
     *
     * @param a
     * @param n
     */
    public static void max_heapify(int[] a, int n) {
        int child;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            //左子节点位置
            child = 2 * i + 1;
            //右子节点存在且大于左子节点，child变成右子节点
            if (child != n && a[child] < a[child + 1]) {
                child++;
            }
            //交换父节点与左右子节点中的最大值
            if (a[i] < a[child]) {
                int temp = a[i];
                a[i] = a[child];
                a[child] = temp;
            }
        }
    }
}

