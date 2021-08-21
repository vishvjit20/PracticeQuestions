package RecursionNBacktracking;
import java.io.*;

public class QueensPermutation2 {
	public static void queensPermutations(int qpsf, int n, int row, int col, String asf, boolean[] queens) {
        
		if (row == n) {
			if (qpsf == n) {
				System.out.println(asf);
				System.out.println();
			}
			return;
		}
		
		for (int q = 0; q < n; q++) {
        	if (queens[q] == false) {
        		queens[q] = true;
        		if (col < n - 1) {
        			queensPermutations(qpsf + 1, n, row, col + 1, asf + "q" + (q + 1) + "\t", queens);
        		}
        		else {
        			queensPermutations(qpsf + 1, n, row + 1, 0, asf + "q" + (q + 1) + "\n", queens);
        		}
        		queens[q] = false;
        	}
        }
        
        if (col < n - 1) {
        	queensPermutations(qpsf, n, row, col + 1, asf + "-\t", queens);
        }
        else queensPermutations(qpsf, n, row + 1, 0, asf + "-\n", queens);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] queens = new boolean[n];

        queensPermutations(0, n, 0, 0, "", queens);
    }
}
