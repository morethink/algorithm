package algorithm.leetcode.dp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 李文浩
 * @date 2019-1-26
 */
public class L_3_LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new L_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new L_3_LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("aaaaaaabcbb"));
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }
}
