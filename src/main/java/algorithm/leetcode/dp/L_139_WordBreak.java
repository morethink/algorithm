package algorithm.leetcode.dp;

import java.util.*;

/**
 * @author 李文浩
 * @date 2018/3/18
 */
public class L_139_WordBreak {

    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        String[] strs = {"cbc", "bcda", "adb", "ddca", "bad", "bbb", "dad", "dac", "ba", "aa", "bd", "abab", "bb",
                "dbda", "cb", "caccc", "d", "dd", "aadb", "cc", "b", "bcc", "bcd", "cd", "cbca", "bbd", "ddd",
                "dabb", "ab", "acd", "a", "bbcc", "cdcbd", "cada", "dbca", "ac", "abacd", "cba", "cdb",
                "dbac", "aada", "cdcda", "cdc", "dbc", "dbcb", "bdb", "ddbdd", "cadaa", "ddbc", "babb"};

        for (String str : strs) {
            set.add(str);
        }
//
        // 重复的值，连续的重复值，
        System.out.println(new L_139_WordBreak().wordBreak("bccdbacdbdacddabbaaaadababadad", set));

        set.clear();
        set.add("a");
        set.add("b");
        set.add("bbb");
        set.add("bbbb");

        System.out.println(new L_139_WordBreak().wordBreak("bb", set));
//
        set.clear();
        set.add("leet");
        set.add("code");
//        System.out.println("leetcode".lastIndexOf("leet"));
//        System.out.println("leetcode".lastIndexOf("code"));
//        System.out.println("leetcode".substring(0, 4));
        System.out.println(new L_139_WordBreak().wordBreak("leetcode", set));

        set.clear();
        set.add("dog");
        set.add("s");
        set.add("gs");
        System.out.println(new L_139_WordBreak().wordBreak("dogs", set));

        set.clear();
        set.add("car");
        set.add("ca");
        set.add("rs");
        System.out.println(new L_139_WordBreak().wordBreak("cars", set));
    }


    /**
     * 暴力法，排除每一个可能，从一个单词单词，直到s可以分词或者dict为空
     *
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak(String s, Set<String> dict) {

        Set<String> cl = new HashSet<>();
        //删完单词
        while (!dict.isEmpty()) {
            String words = s;
            String first = "";
            boolean flag = false;

            cl.add("");
            while (words.length() != 0) {
                if (cl.contains("") && cl.size() == 1) {
                    cl.clear();
                }
                Iterator iterator = dict.iterator();
                while (iterator.hasNext()) {
                    String word = (String) iterator.next();
                    if (words.contains(word) && words.startsWith(word)) {
                        cl.add(word);
                    }
                }
                if (cl.isEmpty() && words.length() != 0) {
                    break;
                } else {
                    String s1 = cl.iterator().next();
                    if (!flag) {
                        first = s1;
                        flag = true;
                    }
                    words = words.replaceFirst(s1, "");
                    System.out.println(words);
                    cl.clear();
                }
            }

            System.out.println(first + words.length());
            if (words.length() != 0) {
                dict.remove(first);
            } else {
                break;
            }

        }
        return !dict.isEmpty();
    }

    /**
     * 动态规划
     *
     * 状态转移方程：
     * f(i) 表示s[0,i]是否可以分词
     * f(i) = f(j) && f(j+1,i); 0 <= j < i;
     *
     * @param s
     * @param dict
     * @return
     */
    public boolean wordBreak2(String s, Set<String> dict) {
        int len = s.length();
        boolean[] arrays = new boolean[len + 1];
        arrays[0] = true;
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arrays[j] && dict.contains(s.substring(j, i))) {
                    arrays[i] = true;
                    break;
                }
            }
        }
        return arrays[len];
    }
}
