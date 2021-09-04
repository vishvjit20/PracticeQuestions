package DesignQuestions;

import java.util.*;

public class SnakesAndLadders {
	public static int snakesAndLadders(int board[][]) {
		int n = board.length;
		int arr[] = new int[n * n];
		int idx = 0;
		int i = n - 1, j = 0, inc = 1;
		while (idx < n * n) {
			arr[idx++] = board[i][j];
			if ((inc == 1 && j == n - 1) || (inc == -1 && j == 0)) {
				inc = -inc;
				i--;
			}
			else j += inc;
		}
		boolean[] visited = new boolean[n * n];
		Queue<Integer> que = new ArrayDeque<>();
		int val = arr[0] > -1 ? arr[0] - 1 : 0;
		que.add(val);
		visited[val] = true;
		int noOfSteps = 0;
		while (!que.isEmpty()) {
			int size = que.size();
			while (size-- > 0) {
				int curr = que.remove();
				if (curr == n * n - 1) return noOfSteps;
				for (int next = curr + 1; next <= Math.min(curr + 6, n * n - 1); next++) {
					int dest = arr[next] > -1 ? arr[next] - 1 : next;
					if (!visited[dest]) {
						visited[dest] = true;
						que.add(dest);
					}
				}
			}
			noOfSteps++;
		}
		return -1;
	}
	public static void main(String args[]) {
		int board[][] = {
								{-1, -1, -1, -1, -1, -1},
								{-1, -1, -1, -1, -1, -1},
								{-1, -1, -1, -1, -1, -1},
								{-1, 35, -1, -1, 13, -1},
								{-1, -1, -1, -1, -1, -1},
								{-1, 15, -1, -1, -1, -1},
						};
		int res = snakesAndLadders(board);
		System.out.println(res);
	}
}
