package algorithm.swordtooffer;

/**
 * @author 李文浩
 * @version 2017/8/11.
 *          <p>
 *          <p>
 *          一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *          <p>
 *          思路:
 */
public class Test10 {
    public static void main(String[] args) {
        Test10 test10 = new Test10();
        System.out.println(test10.JumpFloor(10));
        System.out.println(test10.JumpFloor2(10));
    }

    /**
     * @param target
     * @return
     */
    public int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        int f1 = 1, f2 = 0;
        for (int i = 1; i <= target; i++) {
            f1 = f1 + f2;
            f2 = f1 - f2;
        }
        return f1;
    }

    /**
     * @param target
     * @return
     */
    public int JumpFloor2(int target) {
        if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            return JumpFloor2(target - 1) + JumpFloor2(target - 2);
        }

    }


}
