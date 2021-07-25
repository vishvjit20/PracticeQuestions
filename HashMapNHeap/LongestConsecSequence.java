package HashMapNHeap;

import java.util.HashMap;
import java.util.Scanner;

public class LongestConsecSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i = 0; i < n; i++) if (!map.containsKey(arr[i])) map.put(arr[i], true);

        for (int key : map.keySet()) if (map.containsKey(key - 1)) map.put(key, false);
        
        int start = -1;
        int maxLen = 0;

        for (int key : map.keySet()) {
            int ele = key;
            int len = 1;
            if (map.get(ele)) {
                while(map.containsKey(ele + len)) len++;
                if (len > maxLen) {
                    maxLen = len;
                    start = ele;
                }
            }
        }

        for (int k = start; k < maxLen; k++) 
        System.out.println(k);

        sc.close();
    }
}
