import java.util.*;
public class ShortestPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String s = sc.nextLine();
        String result = shortestPalindrome(s);
        System.out.println("Shortest Palindrome: " + result);
        sc.close();
    }
    public static String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + reversed;
        int[] lps = computeLPS(combined);
        int longestPalPrefix = lps[lps.length - 1];
        String remaining = s.substring(longestPalPrefix);
        String toAdd = new StringBuilder(remaining).reverse().toString();
        return toAdd + s;
    }
    private static int[] computeLPS(String str) {
        int[] lps = new int[str.length()];
        int len = 0;
        int i = 1;
        while (i < str.length()) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
