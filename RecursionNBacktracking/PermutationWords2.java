package RecursionNBacktracking;
import java.util.*;
import java.io.*;

public class PermutationWords2 {
    
    public static void generateWords(int cc, String str, Character[] spots, 
    HashMap<Character, Integer> lastOccurence) {

        if (cc == str.length()) {
            for (int i = 0; i < spots.length; i++) 
            System.out.print(spots[i]);
            System.out.println();
            return;
        }

        char c = str.charAt(cc);
        int lastOcc = lastOccurence.get(c);
        for (int i = lastOcc + 1; i < spots.length; i++) {
            if (spots[i] == null) {
                spots[i] = c;
                lastOccurence.put(c, i);
                generateWords(cc + 1, str, spots, lastOccurence);
                lastOccurence.put(c, lastOcc);
                spots[i] = null;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Character[] spots = new Character[str.length()];
        HashMap<Character, Integer> lastOccurence = new HashMap<>();
        for(char ch: str.toCharArray())  lastOccurence.put(ch, -1);

        generateWords(0, str, spots, lastOccurence);
    }
}
