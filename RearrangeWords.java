import java.util.*;
public class RearrangeWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the sentence: ");
        String sentence = sc.nextLine();
        String result = arrangeWords(sentence);
        System.out.println("Rearranged Sentence: " + result);
        sc.close();
    }
    public static String arrangeWords(String sentence) {
        sentence = sentence.toLowerCase();
        String[] words = sentence.split(" ");
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        String result = String.join(" ", words);
        result = Character.toUpperCase(result.charAt(0)) + result.substring(1);
        return result;
    }
}
