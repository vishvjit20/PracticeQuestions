package HashMapNHeap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int k = sc.nextInt();

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            if (pq.size() < k) pq.add(arr[i]);
            else if (pq.peek() < arr[i]) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        while (pq.size() > 0) {
            System.out.println(pq.remove());
        }

        sc.close();
    }
}
