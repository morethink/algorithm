package algorithm.swordtooffer;

/**
 * @author 李文浩
 * @version 2017/8/13.
 *          <p>
 *          <p>
 *          一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *          <p>
 *          思路
 *          因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
 *          跳1级，剩下n-1级，则剩下跳法是f(n-1)
 *          跳2级，剩下n-2级，则剩下跳法是f(n-2)
 *          所以f(n)=f(n-1)+f(n-2)+...+f(1)
 *          因为f(n-1)=f(n-2)+f(n-3)+...+f(1)
 *          所以f(n)=f(n-1)+f(n-1)=2*f(n-1)
 */
public class Test11 {
    public static void main(String[] args) {
        Test11 test11 = new Test11();
        System.out.println(test11.JumpFloorII(10));
        System.out.println(test11.JumpFloorII2(10));
        System.out.println(test11.JumpFloorII3(10));
    }

    /**
     * 递归
     *
     * @param target
     * @return
     */
    public int JumpFloorII2(int target) {
        if (target <= 0) {
            return -1;
        } else if (target == 1) {
            return 1;
        } else {
            return 2 * JumpFloorII2(target - 1);
        }
    }

    /**
     * 迭代
     *
     * @param target
     * @return
     */
    public int JumpFloorII3(int target) {
        int f = 1;
        for (int i = 1; i < target; i++) {
            f *= 2;
        }
        return f;
    }

    /**
     * 此种思路充分说明了数学是算法的皇后
     * <p>
     * 每个台阶都有跳与不跳两种情况(第n阶台阶必须跳),所以总共有 2 ^ (n - 1)种跳法，
     *
     * @param target
     * @return
     */
    public int JumpFloorII(int target) {
        //使用Math类的方法
//        return (int) Math.pow(2, target - 1);
        //2^(n-1)可以用位移操作进行，更快
        return 1 << --target;
    }
}
