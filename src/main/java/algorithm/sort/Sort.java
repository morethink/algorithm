package algorithm.sort;

/**
 * @author 李文浩
 * @date 2018/1/25
 */
public class Sort {
    public static void main(String[] args) {
        long staruTime = System.currentTimeMillis();
//        int[] a = {10, 2, 6, 3, 50, 26, 34, 6};
        int[] a = new int[20];
        for (int i = 0; i < a.length; i++)
            a[i] = (int) (Math.random() * 100);
        System.out.print("排序前: ");
        for (int n : a)
            System.out.print(n + " ");
        System.out.println();

        //插入排序
//        Insertion.sort(a);
        //希尔排序
//        Shell.sort(a);
        //选择排序

//堆排序
//        Heap.sort(a);
        //冒泡排序
//        Bubble.sort(a);
//        快速排序
//        Quick.sortByStack(a);
//        Quick.sort(a, 0, a.length - 1);
        Quick.sortThreeWay(a, 0, a.length - 1);
        //归并排序
//        Merge.sort(a);

        System.out.print("排序后: ");
        for (int i : a)
            System.out.print(i + " ");
        long endTime = System.currentTimeMillis();
        System.out.println();
        System.out.println((endTime - staruTime) + "ms");
    }
}
