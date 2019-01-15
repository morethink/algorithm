package algorithm.leetcode;

/**
 * @author 李文浩
 * @date 2018/12/15
 */
public class L_28 {
    public static void main(String[] args) {
        new L_28().strStr("1", "");
    }

    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}
