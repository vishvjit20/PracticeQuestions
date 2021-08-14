package RecursionNBacktracking;
import java.io.*;

public class QueensCombination {
	public static void queensCombinations(int noOfQueen, int n, int row, int col, String asf){
        
		if (row == n) {
			if (noOfQueen == n) System.out.println(asf);
			return;
		}
		
		if (col < n - 1) {
			queensCombinations(noOfQueen + 1, n, row, col + 1, asf + "q");
			queensCombinations(noOfQueen, n, row, col + 1, asf + "-");
		}
		else {
			queensCombinations(noOfQueen + 1, n, row + 1, 0, asf + "q\n");
			queensCombinations(noOfQueen, n, row + 1, 0, asf + "-\n");
		}
		
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}
