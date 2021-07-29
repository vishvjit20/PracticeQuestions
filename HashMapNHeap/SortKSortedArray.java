package HashMapNHeap;

import java.util.*;

public class SortKSortedArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        int k = sc.nextInt();
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // push starting k +  elements to pq
        for (int i = 0; i <= k; i++) pq.add(arr[i]);
        for (int i = k + 1; i < n; i++) {
        	System.out.println(pq.remove());
        	pq.add(arr[i]);
        }
        while (pq.size() > 0) System.out.println(pq.remove());
        
        sc.close();
    }
}
