package RecursionNBacktracking;
import java.io.*;

public class QueensCombination2 {
	public static void queensCombinations(int qpsf, int n, boolean[][] chess, int i, int j){
        
		if (qpsf == n) {
			for (int row = 0; row < n; row++) {
				for (int col = 0; col < n; col++) {
					if (chess[row][col]) System.out.print("q\t");
					else System.out.print("-\t");
				}
				System.out.println();
			}
			System.out.println();
			return;
		}
		
		for (int col = j + 1; col < chess.length; col++) {
			chess[i][col] = true;
			queensCombinations(qpsf + 1, n, chess, i, col);
			chess[i][col] = false;
		}

        for (int row = i + 1; row < chess.length; row++) {
            for (int col = 0; col < chess.length; col++) {
                chess[row][col] = true;
                queensCombinations(qpsf + 1, n, chess, row, col);
			    chess[row][col] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}
