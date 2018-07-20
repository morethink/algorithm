package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 2016/9/20.
 */
public class L_204_Count_Primes {
    public static void main(String[] args) {
        //获取开始时
        long startTime = System.currentTimeMillis();
        System.out.println("The num is " + new L_204_Count_Primes().countPrimes4(2000000));
        long endTime = System.currentTimeMillis();
        //获取结束时间
        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
    }

    /**
     * 穷举
     *
     * @param n
     * @return
     */
    public int countPrimes(int n) {
        int num = 0;
        for (int i = 2; i < n; i++) {
            boolean flag = true;
            for (int j = 2; j < i - 1; j++)
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            if (flag) {
                num++;
            }
        }
        return num;
    }

    /**
     * 只能是奇数且小于$\sqrt{n}$
     *
     * @param n
     * @return
     */
    public int countPrimes2(int n) {
        int num = 1;
        for (int i = 3; i < n; i += 2) {
            boolean flag = true;
            for (int j = 2; j <= (int) Math.sqrt(i); j++)
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            if (flag) {
                num++;
            }
        }
        return num;
    }

    /**
     * 试除法
     *
     * @param n
     * @return
     */
    public int countPrimes3(int n) {
        if (n < 3) {
            return 0;
        }
        //0 1 不算做素数,2一定是素数
        List<Integer> list = new ArrayList<>();
        list.add(2);
        boolean flag;
        for (int i = 3; i < n; i += 2) {
            flag = true;
            for (int j = 0; j < list.size() && list.get(j) <= (int) Math.sqrt(n); j++) {
                if (i % list.get(j) == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(i);
            }
        }
        return list.size();
    }

    /**
     * 筛法
     *
     * @param n
     * @return
     */
    public int countPrimes4(int n) {
        if (n < 3) {
            return 0;
        }
        //false代表素数，true代表非素数
        boolean[] flags = new boolean[n];
        //0不是素数
        flags[0] = true;
        //1不是素数
        flags[1] = true;
        int num = n - 2;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            //当i为素数时，i的所有倍数都不是素数
            if (!flags[i]) {
                for (int j = 2 * i; j < n; j += i) {
                    if (!flags[j]) {
                        flags[j] = true;
                        num--;
                    }
                }

            }
        }
        return num;
    }
}
