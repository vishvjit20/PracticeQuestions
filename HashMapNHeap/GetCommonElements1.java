package HashMapNHeap;
import java.util.*;

public class GetCommonElements1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int a[] = new int[n1];
        for (int i = 0; i < n1; i++) a[i] = sc.nextInt();

        int n2 = sc.nextInt();
        int b[] = new int[n2];
        for (int i = 0; i < n2; i++) b[i] = sc.nextInt();

        HashSet<Integer> set = new HashSet<>();
        for (int x : a) set.add(x);

        for (int x : b) {
            if (set.contains(x)) {
                System.out.println(x);
                set.remove(x);
            }
        }
        sc.close();
    }
}
