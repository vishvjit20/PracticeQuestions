package RecursionNBacktracking;
import java.util.*;

public class RecursionGenericQuestions {
	public static void displayArr(int arr[], int idx) {
		if (idx == arr.length) return;
		System.out.println(arr[idx]);
		displayArr(arr, idx + 1);
	}
	public static void displayRevArr(int arr[] , int idx) {
		if (idx == arr.length) return;
		displayRevArr(arr, idx + 1);
		System.out.println(arr[idx]);
	}
	public static int maxVal = Integer.MIN_VALUE;
	public static void findMax(int arr[], int idx) {
		if (idx == arr.length) return;
		if (maxVal < arr[idx]) maxVal = arr[idx];
		findMax(arr, idx + 1);
	}
	public static int firstIndex(int arr[], int idx, int val) {
		if (idx < arr.length && arr[idx] == val) return idx;
		else if (idx == arr.length) return -1;
		int res = firstIndex(arr, idx + 1, val);
		return res;
	}
	public static int lastIndex(int arr[], int idx, int val) {
		if (idx == -1) return -1;
		int res = -1;
		if (arr[idx] == val) {
			return idx;
		}
		res = lastIndex(arr, idx - 1, val);
		return res;
	}
	public static int[] allIndices(int arr[], int idx, int val, int cnt) {
		if (idx == arr.length) {
			return new int[cnt];
		}
		
		if (arr[idx] == val) {
			int res[] = allIndices(arr, idx + 1, val, cnt + 1);
			res[cnt] = idx;
			return res;
		}
		else {
			int res[] = allIndices(arr, idx + 1, val, cnt);
			return res;
		}
	}
	public static ArrayList<String> getSubsequence(String str) {
		if (str.length() == 0) {
			ArrayList<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		char c = str.charAt(0);
		ArrayList<String> res = getSubsequence(str.substring(1));
		ArrayList<String> ans = new ArrayList<>();
		for (String s : res) ans.add(s);
		for (String s : res) ans.add(c + s);
		return ans;
	}
	public static String[] keys = {";", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
	public static ArrayList<String> getKPC(String str) {	
		if (str.length() == 0) {
			ArrayList<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		char c = str.charAt(0);
		ArrayList<String> res = getKPC(str.substring(1));
		ArrayList<String> ans = new ArrayList<>();
		int charVal = c - '0';
		String codes =  keys[charVal];
		for (char code : codes.toCharArray())
		for (String s : res) ans.add(code + s);
		return ans;
	}
	public static ArrayList<String> stairsPaths(int n) {
		if(n == 0) {
			ArrayList<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		else if (n < 0) return new ArrayList<>();
		
		ArrayList<String> paths1 = stairsPaths(n - 1);
		ArrayList<String> paths2 = stairsPaths(n - 2);
		ArrayList<String> paths3 = stairsPaths(n - 3);
		
		ArrayList<String> res = new ArrayList<>();
		
		for (String path : paths1) res.add("1" + path);
		for (String path : paths2) res.add("2" + path);
		for (String path : paths3) res.add("3" + path);
		
		return res;
	}
	public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
		
		if (sr == dr && sc == dc) {
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}
		else if (sr > dr || sc > dc) return new ArrayList<>();
		ArrayList<String> horizontal = getMazePaths(sr, sc + 1, dr, dc);
		ArrayList<String> vertical = getMazePaths(sr + 1, sc, dr, dc);
		ArrayList<String> res = new ArrayList<>();
		
		for (String path : horizontal) res.add("h" + path);
		for (String path : vertical) res.add("v" + path);

		return res;
	}
	public static ArrayList<String> getMazePathWithJumps(int sr, int sc, int dr, int dc) {
		if (sr == dr && sc == dc) {
			ArrayList<String> res = new ArrayList<>();
			res.add("");
			return res;
		}
		ArrayList<String> result = new ArrayList<>();
		
		// horizontal moves
		for (int i = 1; i <= dc - sc; i++) {
			ArrayList<String> hPaths = getMazePathWithJumps(sr, sc + i, dr, dc);
			for (String path : hPaths) result.add("h" + i + path);
		}
		// vertical moves
		for (int i = 1; i <= dr - sr; i++) {
			ArrayList<String> vPaths = getMazePathWithJumps(sr + i, sc, dr, dc);
			for (String path : vPaths) result.add("v" + i + path);
		}
		// diagonal moves
		for (int i = 1; i <= dr - sr && i <= dc - sc; i++) {
			ArrayList<String> dPaths = getMazePathWithJumps(sr + i, sc + i, dr, dc);
			for (String path : dPaths) result.add("d" + i + path);
		}
		return result;
	}
	public static void printSubseq(String str, String psf) {
		if (str.length() == 0) {
			System.out.println(psf);
			return;
		}
		char c = str.charAt(0);
		String s = str.substring(1);
		printSubseq(s, psf + c);
		printSubseq(s, psf);	
	}
	public static void printKPC(String str, String psf) {
		if (str.length() == 0) {
			System.out.println(psf);
			return;
		}
		char c = str.charAt(0);
		String s = str.substring(1);
		int val = c - '0';
		String codes = keys[val];
		for (char code : codes.toCharArray())
		printKPC(s, psf + code);
	}
	public static void printStairs(int n, String psf) {
		if (n == 0) {
			System.out.println(psf);
			return;
		}
		else if (n < 0) return;
		
		printStairs(n - 1, psf + "1");
		printStairs(n - 2, psf + "2");
		printStairs(n - 3, psf + "3");
	}
	public static void printMazePaths(int sr, int sc, int dr, int dc, String psf) {
		if (sr == dr && sc == dc) {
			System.out.println(psf);
			return;
		}
		else if (sr > dr || sc > dc) return;
		printMazePaths(sr, sc + 1, dr, dc, psf + "h");
		printMazePaths(sr + 1, sc, dr, dc, psf + "v");
	}
	public static void printMazePathWithJumps(int sr, int sc, int dr, int dc, String psf) {
		if (sr == dr && sc == dc) {
			System.out.println(psf);
			return;
		}
		for (int i = 1; i <= dc - sc; i++)
			printMazePathWithJumps(sr, sc + i, dr, dc, psf + "h" + i);
		for (int i = 1; i <= dr - sr; i++)
			printMazePathWithJumps(sr + i, sc, dr, dc, psf + "v" + i);
		for (int i = 1; i <= dc - sc && i <= dr - sr; i++)
			printMazePathWithJumps(sr + i, sc + i, dr, dc, psf + "d" + i);
	}
	public static void printPermutations(String str, String psf) {
		if (str.length() == 0) {
			System.out.println(psf);
			return;
		}
		for (int i = 0; i < str.length(); i++) {
			String lpart = str.substring(0, i);
			String rpart = str.substring(i + 1);
			char c = str.charAt(i);
			printPermutations(lpart + rpart, psf + c);
		}
	}
	public static void printEncodings(String str, String psf) {
		if (str.length() == 0) {
			System.out.println(psf);
			return;
		}
		int c = str.charAt(0) - '0';
		if (c > 0) printEncodings(str.substring(1), psf + (char)(c + 'a' - 1));
		if (str.length() >= 2) {
			int n = Integer.parseInt(str.substring(0, 2));
			if (n >= 10 && n <= 26) printEncodings(str.substring(2), psf + (char)(n + 'a' - 1));
		}
	}
	public static void floodfill(int maze[][], int i, int j, String asf, boolean[][] visited) {
		if (i < 0 || j < 0 || i >= maze.length || j >= maze[0].length || maze[i][j] == 1 || visited[i][j]) return;
		if (i == maze.length - 1 && j == maze[0].length - 1) {
			System.out.println(asf);
			return;
		}
		visited[i][j] = true;
		floodfill(maze, i, j + 1, asf + "R", visited);
		floodfill(maze, i, j - 1, asf + "L", visited);
		floodfill(maze, i + 1, j, asf + "D", visited);
		floodfill(maze, i - 1, j, asf + "U", visited);
		visited[i][j] = false;
	}
	public static void printNQueens(int [][]board, String psf, int row) {
		if (row == board.length) {
			System.out.println(psf);
			return;
		}
		
		for (int col = 0; col < board.length; col++) {
			if (isItSafe(board, row, col)) {
				board[row][col] = 1;
				printNQueens(board, psf + row + " - " + col + ", ", row + 1);
				board[row][col] = 0;
			}
		}
	}
	public static boolean isItSafe(int [][]board, int row, int col) {
		for (int i = row - 1, j = col; i >= 0; i--) 
			if (board[i][j] == 1) return false;
		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) 
			if (board[i][j] == 1) return false;
		for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
			if (board[i][j] == 1) return false;
		return true;
	}
	public static void knightsTour(int board[][], int i, int j, int move) {
		int n = board.length;
		if (i < 0 || i >= n || j < 0 || j >= n || board[i][j] > 0) {
			return;
		}
		else if (move == n * n) {
			board[i][j] = move;
			display(board);
			System.out.println();
			board[i][j] = 0;
			return;
		}
		board[i][j] = move;
		knightsTour(board, i - 2, j + 1, move + 1);
		knightsTour(board, i - 1, j + 2, move + 1);
		knightsTour(board, i + 1, j + 2, move + 1);
		knightsTour(board, i + 2, j + 1, move + 1);
		knightsTour(board, i + 2, j - 1, move + 1);
		knightsTour(board, i + 1, j - 2, move + 1);
		knightsTour(board, i - 1, j - 2, move + 1);
		knightsTour(board, i - 2, j - 1, move + 1);
		board[i][j] = 0;
	}
	public static void display(int arr[][]) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	public static void printTargetSum(int arr[], int idx, String psf, int sum, int target) {
		if (idx == arr.length) {
			if (sum == target)
				System.out.println(psf);
			return;
		}
		printTargetSum(arr, idx + 1, psf + arr[idx] + ", ", sum + arr[idx], target);
		printTargetSum(arr, idx + 1, psf, sum, target);
	}
		
	public static void main(String args[]) {
//		int arr[] = { 15, 5, 30, 40, 4, 11, 4, 9, 11, 55, 4, 9, 3, 7 };
//		displayArr(arr, 0);
//		displayRevArr(arr, 0);
//		findMax(arr, 0);
//		System.out.println(maxVal);
//		int res = firstIndex(arr, 0, -5);
//		int res = lastIndex(arr, arr.length - 1, 4);
//		int[] res = allIndices(arr, 0, 4, 0);
//		for (int i = 0; i < res.length; i++) 
//		System.out.print(res[i] +", ");
//		System.out.println(getSubsequence("abc"));
//		System.out.println(getKPC("37"));
//		System.out.println(stairsPaths(5));
//		System.out.println(getMazePaths(0, 0, 2, 2));
//		System.out.println(getMazePathWithJumps(1, 1, 2, 2));
//		printSubseq("ybTA", "");
//		printKPC("78", "");
//		printStairs(5, "");
//		printMazePaths(1, 1, 3, 3, "");
//		printMazePathWithJumps(1, 1, 3, 3, "");
//		printPermutations("abc", "");
//		printEncodings("655196", "");
//		int arr[][] = {
//						{0, 0, 1, 1}, 
//						{1, 0, 0, 1}, 
//						{1, 0, 0, 1}, 
//						{1, 0, 0, 0}
//					};
//		floodfill(arr, 0, 0, "", new boolean[4][4]);
//		knightsTour(new int[5][5], 2, 0, 1);
		int arr[] = {10, 20, 30, 40, 50};
		printTargetSum(arr, 0, "", 0, 60);
	}
}
