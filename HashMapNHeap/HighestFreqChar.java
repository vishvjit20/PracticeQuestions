package HashMapNHeap;
import java.util.*;

public class HighestFreqChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        char hfc = '\0';
        int mf = 0;

        for (char c : map.keySet()) {
            int val = map.get(c);
            if (val > mf) {
                mf = val;
                hfc = c;
            }
        }
        System.out.println(hfc);
        sc.close();
    }
}
