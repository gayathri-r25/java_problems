import java.util.*;
public class MaxProduct {
    public int solve(ArrayList<String> words) {
        int max = 0;
        for (int i = 0; i < words.size(); i++) {
            for (int j = i + 1; j < words.size(); j++) {
                String w1 = words.get(i);
                String w2 = words.get(j);

                if (!shareLetter(w1, w2)) {
                    int product = w1.length() * w2.length();
                    max = Math.max(max, product);
                }
            }
        }
        return max;
    }
    boolean shareLetter(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);

            if (b.indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of words:");
        int n = sc.nextInt();
        sc.nextLine();

        ArrayList<String> words = new ArrayList<>();

        System.out.println("Enter the words:");
        for (int i = 0; i < n; i++) {
            words.add(sc.nextLine());
        }
        MaxProduct obj = new MaxProduct();
        int result = obj.solve(words);

        System.out.println("Maximum Product: " + result);
        sc.close();
    }
}