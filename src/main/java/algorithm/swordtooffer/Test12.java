package algorithm.swordtooffer;

/**
 * @author 李文浩
 * @version 2017/8/13.
 *          <p>
 *          <p>
 *          我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 *          请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 *          <p>
 *          思路
 *          要么横着摆，要么竖着摆，所以只有两种可能
 *          1. n-1 横着一根
 *          2. n-2 竖着摆两根
 */
public class Test12 {
    public static void main(String[] args) {
        Test12 test12 = new Test12();
        System.out.println(test12.RectCover(10));
        System.out.println(test12.RectCover2(0));
    }

    /**
     * 递归
     *
     * @param target
     * @return
     */
    public int RectCover(int target) {
        if (target == 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return RectCover(target - 1) + RectCover(target - 2);
        }
    }

    /**
     * 迭代
     *
     * @param target
     * @return
     */
    public int RectCover2(int target) {
        if (target == 0) {
            return 0;
        }
        int f1 = 0, f2 = 1;
        for (int i = 0; i <= target; i++) {
            f1 = f1 + f2;
            f2 = f1 - f2;
        }
        return f1;
    }
}
