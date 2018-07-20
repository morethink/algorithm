package algorithm.swordtooffer;

/**
 * @author 李文浩
 * @version 2017/8/13.
 *          <p>
 *          <p>
 *          给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 */
public class Test14 {
    public static void main(String[] args) {
        Test14 test14 = new Test14();
        System.out.println(test14.Power(2, 3));
        System.out.println(test14.Power(0, 5));
        System.out.println(test14.Power(2, -3));
        System.out.println(test14.Power(2, 0));
        System.out.println(test14.Power(-2, 2));
    }

    /**
     * 代码的完整性
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        boolean isFu = false;
        if (exponent < 0) {
            exponent = -exponent;
            isFu = true;
        }

        double num = base;
        while (exponent-- > 1) {
            num *= base;
        }
        return isFu ? 1 / num : num;
    }

    /**
     * 采取移位操作
     *
     * @param base
     * @param n
     * @return
     */
    public double Power2(double base, int n) {
        double res = 1, curr = base;
        int exponent;
        if (n > 0) {
            exponent = n;
        } else if (n < 0) {
            if (base == 0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        } else {// n==0
            return 1;// 0的0次方
        }
        while (exponent != 0) {
            if ((exponent & 1) == 1)
                res *= curr;
            curr *= curr;// 翻倍
            exponent >>= 1;// 右移一位
        }
        return n >= 0 ? res : (1 / res);
    }

}
