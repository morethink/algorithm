package algorithm.leetcode.dp;

import java.util.*;

/**
 * @author 李文浩
 * @date 2018/3/18
 */
public class L_140_WordBreakII {

    public static void main(String[] args) {
        String s = "pineapplepenapple";
        String[] wordDict = {"apple", "pen", "applepen", "pine", "pineapple"};
        List<String> set = new ArrayList<>(Arrays.asList(wordDict));
        System.out.println(new L_140_WordBreakII().wordBreak(s, set));
    }

    public ArrayList<String> wordBreak(String s, List<String> wordDict) {
        return DFS(s, wordDict, new HashMap<String, ArrayList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    ArrayList<String> DFS(String s, List<String> wordDict, HashMap<String, ArrayList<String>> map) {
        if (map.containsKey(s))
            return map.get(s);

        ArrayList<String> res = new ArrayList<String>();
        if (s.length() == 0) {
            res.add("");
            return res;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                List<String> sublist = DFS(s.substring(word.length()), wordDict, map);
                for (String sub : sublist)
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
            }
        }
        map.put(s, res);
        return res;
    }
}
