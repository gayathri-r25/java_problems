import java.util.*;
public class KthLargest {
    public static int solve(ArrayList<Integer> nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements:");
        int n = sc.nextInt();

        ArrayList<Integer> nums = new ArrayList<>();

        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) {
            nums.add(sc.nextInt());
        }

        System.out.println("Enter k:");
        int k = sc.nextInt();
        int result = solve(nums, k);
        System.out.println("Kth Largest Element: " + result);
        sc.close();
    }
}