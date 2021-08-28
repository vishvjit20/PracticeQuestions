package RecursionNBacktracking;

public class SudokuValidate {

	public static boolean validateSudoku(char board[][]) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '.') {
					char temp = board[i][j];
					board[i][j] = '.';
					boolean res = isValid(board, i, j, temp);
					board[i][j] = temp;
					if (!res) return false;
				}
			}
		}
		return true;
	}
	public static boolean isValid(char[][] board, int i, int j, char d) {
		for (int c = 0 ; c < 9; c++) {
			if (board[i][c] == d) {
				return false;
			}
		}
		for (int r = 0 ; r < 9; r++) {
			if (board[r][j] == d) {
				return false;
			}
		}
		int smrs = (i / 3) * 3;
		int smcs = (j / 3) * 3;
		
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 3; c++) {
				if (board[smrs + r][smcs + c] == d) {
					return false;
				}
			}
		}
		return true;	
	}
	public static void main(String args[]) {
		char[][] board = {
					     {'5', '3', '.', '.' , '7', '.', '.', '.', '.'},
						 {'6', '.', '.', '1' , '9', '5', '.', '.', '.'},
						 {'.', '9', '8', '.' , '.', '.', '.', '6', '.'},
						 {'8', '.', '.', '.' , '6', '.', '.', '.', '3'},
						 {'4', '.', '.', '8' , '.', '3', '.', '.', '1'},
						 {'7', '.', '.', '.' , '2', '.', '.', '.', '6'},
						 {'.', '6', '.', '.' , '.', '.', '2', '8', '.'},
						 {'.', '.', '.', '4' , '1', '9', '.', '.', '5'},
						 {'.', '.', '.', '.' , '8', '.', '.', '7', '9'},
					};   
		System.out.println(validateSudoku(board));
	}
}
