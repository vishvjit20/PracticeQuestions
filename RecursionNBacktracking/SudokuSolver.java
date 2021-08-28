package RecursionNBacktracking;

public class SudokuSolver {
	public static void solveSudoku(int board[][], int i, int j) {
		if (j == board[0].length) {
			i++; j = 0;
		}
		
		if (i == board.length) {
			display(board);
			return;
		}
		
		if (board[i][j] != 0) solveSudoku(board, i, j + 1);			
		else {
			for (int d = 1; d <= 9; d++) {
				if (isValid(board, i, j, d)) {
					board[i][j] = d;
					solveSudoku(board, i, j + 1);
					board[i][j] = 0;
				}
			}
		}
		
	}
	public static boolean isValid(int board[][], int i, int j, int d) {
		// ith row check
		for (int c = 0; c < 9; c++)
			if (board[i][c] == d) 
				return false;
		
		// jth col check
		for (int r = 0 ; r < 9; r++) 
			if (board[r][j] == d) 
				return false;
		
		// submatrix check
		int smrs = (i/3)*3;
		int smcs = (j/3)*3;
		
		for (int r = 0; r < 3; r++) 
			for (int c = 0; c < 3; c++)
				if (board[smrs + r][smcs + c] == d) 
					return false;
		
		return true;
	}
	public static void display(int board[][]) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void main(String args[]) {
		int board[][] = {
							{3, 0, 6, 5, 0, 8, 4, 0, 0},
							{5, 2, 0, 0, 0, 0, 0, 0, 0},
							{0, 8, 7, 0, 0, 0, 0, 3, 1},
							{0, 0, 3, 0, 1, 0, 0, 8, 0},
							{9, 0, 0, 8, 6, 3, 0, 0, 5},
							{0, 5, 0, 0, 9, 0, 6, 0, 0},
							{1, 3, 0, 0, 0, 0, 2, 5, 0},
							{0, 0, 0, 0, 0, 0, 0, 7, 4},
							{0, 0, 5, 2, 0, 6, 3, 0, 0},
						};
		solveSudoku(board, 0, 0);
	}
}
