package algorithm.swordtooffer;

import java.util.ArrayList;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 *
 * @author 李文浩
 * @version 2017/7/20.
 */
public class Test4 {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        System.out.println(test4.replaceSpace(new StringBuffer("We Are Happy.")));
    }

    /**
     *
     * 因为牛客网给的是StringBuffer类，这个类只有一个replace方法，因此先把空格的位置记录下来，
     * 然后当已经替换一个空格的时候，新的空格的位置等于前面空格的数量乘以2
     *
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        ArrayList<Integer> list = new ArrayList<Integer>(10);
        for (int i = 0; i < str.length(); i++) {
            if (' ' == str.charAt(i)) {
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + i * 2);
            str.replace(list.get(i), list.get(i) + 1, "%20");
        }
        return str.toString();
    }
}
