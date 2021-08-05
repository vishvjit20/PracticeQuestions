package Graph;
import java.io.*;

public class NumberOfIslands {
	
	public static int count = 0;
	public static void main(String[] args) throws Exception {
	      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	      int m = Integer.parseInt(br.readLine());
	      int n = Integer.parseInt(br.readLine());
	      int[][] arr = new int[m][n];

	      for (int i = 0; i < arr.length; i++) {
	         String parts = br.readLine();
	         for (int j = 0; j < arr[0].length; j++) {
	            arr[i][j] = Integer.parseInt(parts.split(" ")[j]);
	         }
	      }

	      for (int i = 0; i < arr.length; i++) {
	    	  for (int j = 0; j < arr[0].length; j++) {
	    		  if (arr[i][j] == 0) {
	    			  count++;
	    			  dfs(i, j, arr);
	    		  }
	    	  }
	      }
	      System.out.println(count);
	}
	
	private static void dfs(int r, int c, int [][]grid) {
		if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] == 1) {
			return;
		}
		grid[r][c] = 1;
		dfs(r + 1, c, grid);
		dfs(r - 1, c, grid);
		dfs(r, c + 1, grid);
		dfs(r, c - 1, grid);
	}
}
