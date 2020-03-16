package middle;

/**
 * @program:
 * @description:
 * @author: SY_zheng
 * @create: 2019-10-06
 */
public class longestPalindrome {

    public static void main(String[] args) {
        String s = "abaxc";
        int i = 0;
        int n = s.length();
        int j = s.length() - 1;
        int count = 0;
        while(i < n && j > 0) {
            System.err.println(i);
            System.err.println(j);
            if (i == j) {
                break;
            }

            if (s.charAt(i) == s.charAt(j)) {
                j = j - 1;
                i = i + 1;
                count++;

            }
            if (s.charAt(i) != s.charAt(j)) {
                i++;
                count--;
            }

        }
        System.err.println(count);

    }
}
