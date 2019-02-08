package algorithm.sort;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author 李文浩
 * @date 2018/11/16
 */
public class Test2 {
    public static void main(String[] args) {
        String s1 = "12ddddd3###";
        Queue<Integer> queue1 = new LinkedList<>();
        int cycle = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == '#') {
                if (cycle > 0) {
                    for (int j = 0; j < cycle; j++) {
                        ((LinkedList<Integer>) queue1).pop();
                        ((LinkedList<Integer>) queue1).pop();
                    }
                    for (int j = cycle; j >= 0; j--) {
                        ((LinkedList<Integer>) queue1).push(i - (2 * j + 1));
                        ((LinkedList<Integer>) queue1).push(i - (2 * j));
                    }
                } else {
                    queue1.offer(i - 1);
                    queue1.offer(i);
                }
                cycle++;
            } else {
                cycle = 0;
            }
        }

        String s2 = "dddd###DDDD";
        cycle = 0;
        Queue<Integer> queue2 = new LinkedList<>();
        for (int i = 0; i < s2.length(); i++) {
            if (s1.charAt(i) == '#') {
                if (cycle > 0) {
                    for (int j = 0; j < cycle; j++) {
                        ((LinkedList<Integer>) queue2).pop();
                        ((LinkedList<Integer>) queue2).pop();
                    }
                    for (int j = cycle; j >= 0; j--) {
                        ((LinkedList<Integer>) queue2).push(i - (2 * j + 1));
                        ((LinkedList<Integer>) queue2).push(i - (2 * j));
                    }
                } else {
                    queue2.offer(i - 1);
                    queue2.offer(i);
                }
                cycle++;
            } else {
                cycle = 0;
            }
        }
        boolean result = false;
        int i = 0, j = 0;
        while (i <= s1.length() && j < s2.length()) {
            if (i == queue1.peek()) {
                ((LinkedList<Integer>) queue1).pop();
            }
            if (j == queue2.peek()) {
                ((LinkedList<Integer>) queue1).pop();
            }
            i++;
            j++;
        }
    }
}
