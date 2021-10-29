package Graph2;
import java.util.*;

public class RottingOranges {
	public static class Pair {
		int i, j , t;
		public Pair (int i, int j, int t) {
			this.i = i;
			this.j = j;
			this.t = t;
		}
	}
	public static int rottingOranges(int grid[][]) {
		ArrayDeque<Pair> q = new ArrayDeque<>();
		
		int fo = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 2) {
					q.add(new Pair(i, j, 0));
				}
				else if (grid[i][j] == 1) fo++;
			}
		}
		
		int res = 0;
		int dirs[][] = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
		while (q.size() > 0) {
			Pair rem = q.remove();
			res = rem.t;
			for (int k = 0; k < 4; k++) {
				int ni = rem.i + dirs[k][0];
				int nj = rem.j + dirs[k][1];
				
				if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == 1) {
					q.add(new Pair(ni, nj, rem.t + 1));
					grid[ni][nj] = 2;
					fo--;
				}
			}
		}
		return fo == 0 ? res : -1;
	}
	
	public static void main(String args[]) {
		
		int[][] grid = {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
		int res = rottingOranges(grid);
		System.out.println(res);
	}
}
