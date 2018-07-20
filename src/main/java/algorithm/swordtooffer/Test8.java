package algorithm.swordtooffer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 *
 * @author 李文浩
 * @version 2017/8/5.
 */
public class Test8 {

    public static void main(String[] args) {
//        int[] a = {6, 3, 4, 5};
        int[] a = {6501, 6828, 6963, 7036, 7422, 7674, 8146, 8468, 8704, 8717, 9170, 9359, 9719, 9895, 9896, 9913, 9962, 154, 293, 334, 492, 1323, 1479, 1539, 1727, 1870, 1943, 2383, 2392, 2996, 3282, 3812, 3903, 4465, 4605, 4665, 4772, 4828, 5142, 5437, 5448, 5668, 5706, 5725, 6300, 6335};
        Test8 test8 = new Test8();
        System.out.println(test8.minNumberInRotateArray(a));
    }

    /**
     * 思路:
     * 我们的目标是最小的那个数，即接近有最大的数向最小的数过渡的那个点，
     * 因此，通过判断array[mid]与array[0]的大小关系，即可判断到底是low增加还是hight减小。
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        }
        int low = 0, high = array.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (array[mid] < array[mid - 1]) {
                return array[mid];
            } else {
                if (array[mid] < array[0]) {
                    high = mid + 1;
                } else {
                    low = mid - 1;
                }
            }
        }
        return 888888;
    }
}
