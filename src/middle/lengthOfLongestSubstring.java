package middle;

import java.util.HashSet;
import java.util.Set;

/**
 * @program:
 * @description:
 * @author: SY_zheng
 * @create: 2019-10-04
 */
public class lengthOfLongestSubstring {


    public static void main(String[] args) {
        String s = "aab";
        int n = s.length();
        int max = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        System.err.println(max);
    }
}
