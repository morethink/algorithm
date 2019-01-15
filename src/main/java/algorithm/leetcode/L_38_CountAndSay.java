package algorithm.leetcode;

/**
 * @author 李文浩
 * @date 2018/12/16
 */
public class L_38_CountAndSay {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new L_38_CountAndSay().countAndSay(i));
        }
    }

    /**
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 0; i < n - 1; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < s.length(); ) {
                if (j + 1 == s.length() || s.charAt(j) != s.charAt(j + 1)) {
                    sb.append(1).append(s.charAt(j));
                    j++;
                } else {
                    int k = j + 1;
                    while (k < s.length() && s.charAt(k) == s.charAt(j)) {
                        k++;
                    }
                    int m = k - j;
                    sb.append(m).append(s.charAt(j));
                    j = k;
                }
            }
            s = sb.toString();
        }
        return s;
    }
}
