import java.util.*;
public class CroakingFrogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter croak string: ");
        String croakOfFrogs = sc.nextLine();
        int result = minNumberOfFrogs(croakOfFrogs);
        System.out.println("Minimum Frogs Needed: " + result);
        sc.close();
    }
    public static int minNumberOfFrogs(String croakOfFrogs) {
        int c = 0, r = 0, o = 0, a = 0;
        int activeFrogs = 0;
        int maxFrogs = 0;
        for (char ch : croakOfFrogs.toCharArray()) {
            if (ch == 'c') {
                c++;
                activeFrogs++;
                maxFrogs = Math.max(maxFrogs, activeFrogs);
            }
            else if (ch == 'r') {
                if (c == 0) return -1;
                c--;
                r++;
            }
            else if (ch == 'o') {
                if (r == 0) return -1;
                r--;
                o++;
            }
            else if (ch == 'a') {
                if (o == 0) return -1;
                o--;
                a++;
            }
            else if (ch == 'k') {
                if (a == 0) return -1;
                a--;
                activeFrogs--;
            }
        }
        if (c != 0 || r != 0 || o != 0 || a != 0) {
            return -1;
        }
        return maxFrogs;
    }
}
