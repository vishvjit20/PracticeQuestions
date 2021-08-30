package RecursionNBacktracking;

import java.util.*;

public class Magnet {

	public static String items[] = {"+-", "-+", "XX"};
	public static boolean solution(char[][] arr, int[] top, int[] left, int[] right, int[] bottom, char[][] ans, int row, int col) {
		
		if (col == arr[0].length) {
			row++;
			col = 0;
		}
		
		if (row == ans.length) {
			if (isValidCountWise(ans, top, left, right, bottom)) print(ans);
			return;
		}
		
		if (arr[row][col] == 'L') {
			// place horizontally
			for (int i = 0; i < items.length; i++) {
				String item = items[i];
				
				if (canPlaceHorizontal(ans, row, col, item)) {
					// place
					ans[row][col] = item.charAt(0);
					ans[row][col + 1] = item.charAt(1);
					
					// call
					solution(arr, top, left, right, bottom, ans, row, col + 1);
					
					// update
					ans[row][col] = '.';
					ans[row][col + 1] = '.';
				}
			}
		}
		else if (arr[row][col] == 'T') {
			// place vertically
			for (int i = 0; i < items.length; i++) {
				String item = items[i];
				
				if (canPlaceVertical(ans, row, col, item)) {
					// place
					ans[row][col] = item.charAt(0);
					ans[row + 1][col] = item.charAt(1);
					
					// call
					solution(arr, top, left, right, bottom, ans, row, col + 1);
					
					// update
					ans[row][col] = '.';
					ans[row + 1][col] = '.';
				}
			}
		}
		else {
			// goto next box
			solution(arr, top, left, right, bottom, ans, row, col + 1);
		}
		return false;
	}
	
	public static boolean canPlaceHorizontal(char [][]ans, int i, int j, String item) {
		if (item.equals("XX")) return true;
		char ch0 = item.charAt(0);
		char ch1 = item.charAt(1);
		
		if ((i - 1 >= 0 && ans[i - 1][j] == ch0) || (j - 1 >= 0 && ans[i][j - 1] == ch0) || (i + 1 < ans.length && ans[i + 1][j] == ch0)) return false;
		
		if ((i - 1 >= 0 && j + 1 < ans[0].length && ans[i - 1][j + 1] == ch1) || (j + 2 < ans[0].length && ans[i][j + 2] == ch1) || (i + 1 < ans.length && j + 1 < ans[0].length && ans[i + 1][j] == ch1)) return false;
		
		return true;
	}
	
	public static boolean canPlaceVertical(char [][]ans, int i, int j, String item) {
		if (item.equals("XX")) return true;
		char ch0 = item.charAt(0);
		char ch1 = item.charAt(1);
		
		if ((i - 1 >= 0 && ans[i - 1][j] == ch0) || (j - 1 >= 0 && ans[i][j - 1] == ch0) || (j + 1 < ans[0].length && ans[i][j + 1] == ch0)) return false;
		
		if ((i - 1 >= 0 && j + 1 < ans[0].length && ans[i - 1][j + 1] == ch1) || (j + 2 < ans[0].length && ans[i][j + 2] == ch1) || (i + 1 < ans.length && j + 1 < ans[0].length && ans[i + 1][j] == ch1)) return false;
		
		return true;
	}
	
	public static boolean canPlaceVertical(char [][]ans, int r, int c, String item) {
		
	}

	public static void print(char[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int m = scn.nextInt();
		int n = scn.nextInt();
		char[][] arr = new char[m][n];
		for (int i = 0; i < arr.length; i++) {
			String str = scn.next();
			arr[i] = str.toCharArray();
		}
		int[] top = new int[n];
		for (int i = 0; i < n; i++) {
			top[i] = scn.nextInt();
		}
		int[] left = new int[m];
		for (int i = 0; i < m; i++) {
			left[i] = scn.nextInt();
		}
		int[] right = new int[m];
		for (int i = 0; i < m; i++) {
			right[i] = scn.nextInt();
		}
		int[] bottom = new int[n];
		for (int i = 0; i < n; i++) {
			bottom[i] = scn.nextInt();
		}

		//write your code here
	}

	
}