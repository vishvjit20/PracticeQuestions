package RecursionNBacktracking;
import java.io.*;
import java.util.*;

class PermutationWords1 {
    public static void generateWords(int cs, int ts, HashMap<Character, Integer> fmap, String asf) {
        if (cs > ts) {
            System.out.println(asf);
            return;
        }
        for (char c : fmap.keySet()) {
            if (fmap.get(c) > 0) {
                fmap.put(c, fmap.get(c) - 1);
                generateWords(cs + 1, ts, fmap, asf + c);
                fmap.put(c, fmap.get(c) + 1);
            }  
        }
    }    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        HashMap<Character, Integer> map = new HashMap<>();
        char[] frequencies = str.toCharArray();
        for(char c : frequencies) map.put(c, map.getOrDefault(c, 0) + 1);
        
        generateWords(1, str.length(), map, "");
    }
}
