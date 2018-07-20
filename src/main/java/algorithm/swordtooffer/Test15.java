package algorithm.swordtooffer;

/**
 * @author 李文浩
 * @version 2017/9/4.
 *          <p>
 *          输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *          所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Test15 {
    public static void main(String[] args) {
        int[] arr = {1, 80, 10, 89, 84, 48, 45, 53, 28, 75, 25};
//        int[] arr = new int[10];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = (int) (Math.random() * 100);
//        }
        Test15 test15 = new Test15();
        test15.reOrderArray(arr);

    }

    /**
     * 冒泡排序
     * 遍历数组，如果是奇数开始向前交换，然后再从此奇数开始，如果是偶数就交换，直到第一个数
     *
     * @param array
     */
    public void reOrderArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        for (int i = 1; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                for (int j = i; j > 0; j--) {
                    if (array[j - 1] % 2 == 0) {
                        int temp = array[j - 1];
                        array[j - 1] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
