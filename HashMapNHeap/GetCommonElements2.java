package HashMapNHeap;
import java.util.*;

public class GetCommonElements2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int a[] = new int[n1];
        for (int i = 0; i < n1; i++) a[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int b[] = new int[n2];
        for (int i = 0; i < n2; i++) b[i] = sc.nextInt();

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : a) map.put(x, map.getOrDefault(x, 0) + 1);

        for (int x : b) {
            if (map.containsKey(x) && map.get(x) > 0) {
                map.put(x, map.get(x) - 1);
                System.out.println(x);
            }
        }
        sc.close();
    }
}
