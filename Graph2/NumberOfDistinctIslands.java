package Graph2;
import java.util.*;

public class NumberOfDistinctIslands {
	public static StringBuilder psf = new StringBuilder();
	public static int numDistinctIslands(int[][] grid) {
		HashSet<String> set = new HashSet<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					psf = new StringBuilder();
					psf.append("x");
					dfs(grid, i, j);
					set.add(psf.toString());
				}
			}
		}
		return set.size();
	}
	
	public static void dfs(int[][] grid, int i, int j) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) {
			psf.append("z");
			return;
		}
		
		grid[i][j] = 0;
		
		psf.append("r");
		dfs(grid, i + 1, j);
		psf.append("l");
		dfs(grid, i - 1, j);
		psf.append("d");
		dfs(grid, i, j - 1);
		psf.append("u");
		dfs(grid, i, j + 1);
	}
}
