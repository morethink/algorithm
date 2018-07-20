package algorithm.tencent;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李文浩
 * @date 2018/1/28
 */
public class Main {
    public static List<Integer> list;

    static {
        list = new ArrayList<Integer>(40);
        list.add(2);
    }

    public static void main(String[] args) {
        System.out.println(getPrimePair(12));
    }

    public static int getPrimePair(int n) {
        if (n <=3 || n >= 1000) {
            return 0;
        }
        //0 1 不算做素数,2一定是素数
        for (int i = 3; i < n; i += 2) {
            if (isPrime(i)) {
                list.add(i);
            }
        }
//        System.out.print("素数为:");
//        for (Integer integer : list) {
//            System.out.print(integer + " ");
//        }
//        System.out.println();
        Integer[] integers = new Integer[list.size()];
        list.toArray(integers);

        int num = 0;
        for (int i = 0; i < integers.length; i++) {
            for (int j = integers.length - 1; j >= i; j--) {
                if ((integers[i] + integers[j]) == n) {
                    num++;
                }
            }
        }
        return num;
    }

    public static boolean isPrime(int n) {
        for (int i = 0; list.get(i) <= (int) Math.sqrt(n); i++) {
            if (n % list.get(i) == 0)
                return false;
        }
        return true;
    }


    public static void prime() {
        for (int n = 0; n <= 200; n++) {
            if (isPrime(n)) {
                list.add(n);
            }
        }
    }


}
