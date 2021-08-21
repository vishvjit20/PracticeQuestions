package RecursionNBacktracking;
import java.io.*;

public class QueensCombination2 {
	public static void queensCombinations(int qpsf, int n, boolean[][] chess, int i, int j){
        
		
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}
