package RecursionNBacktracking;
import java.util.*;

public class WordsKSelection1 {
    public static void combination(int i, String ustr, int ssf, int ts, String asf ) {
        if (i == ustr.length()) {
            if (ssf == ts) System.out.println(asf);
            return;
        }
        char c = ustr.charAt(i);
        combination(i + 1, ustr, ssf + 1, ts, asf + c);
        combination(i + 1, ustr, ssf, ts, asf);
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        int k = scn.nextInt();
        scn.close();

        HashSet<Character> unique = new HashSet<>();
        String ustr = "";
        for (char ch : str.toCharArray()) {
            if (unique.contains(ch) == false) {
                unique.add(ch);
                ustr += ch;
            }
        }
        combination(0, ustr, 0, k, "");
    }
}
