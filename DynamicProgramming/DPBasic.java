package DynamicProgramming;

import java.util.*;

public class DPBasic {
	public static int fibonacci(int n) {
		int dp[] = new int[n + 1];
		dp[0] = 0;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
	public static int climbStairs(int n) {
		int dp[] = new int[n + 1];
		dp[0] = dp[1] = 1;
		dp[2] = 2;
		for (int i = 3; i < dp.length; i++) {
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		return dp[n];
	}
	public static int climbStairsVariableJumps(int arr[]) {
		int n = arr.length;
		int dp[] = new int[n + 1];
		dp[n] = 1;
		for (int i = n - 1; i >= 0; i--) {
			for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
				dp[i] += dp[i + j]; 
			}
		}
		return dp[0];
	}
	
	public static int minMovesToTop(int arr[]) {
		int n = arr.length;
		int dp[] = new int[n + 1];
		for (int i = n - 1; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= arr[i] && i + j < dp.length; j++) {
				if (min > dp[i + j]) {
					min = dp[i + j];
				}
			}
			if (min == Integer.MAX_VALUE) {
				dp[i] = Integer.MAX_VALUE;
			}
			else dp[i] = min + 1;
		}
		return dp[0];
	}
	public static int minCostToTraversal (int maze[][]) {
		int m = maze.length, n = maze[0].length;
		int dp[][] = new int[m][n];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1) dp[i][j] = maze[i][j];
				else if (i == m - 1) dp[i][j] = maze[i][j] + dp[i][j + 1];
				else if (j == n - 1) dp[i][j] = maze[i][j] + dp[i + 1][j];
				else dp[i][j] = maze[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
			}
		}
		return dp[0][0];
	}
//	public static boolean flag = false;
	public static int targetSumSubsets(int arr[], int idx, int target, int dp[][]) {
//		if (idx == arr.length) {
//			if (sum == target) {
//				flag = true;
//			}
//			return;
//		}
//		targetSumSubsets(arr, idx + 1, sum + arr[idx], target);
//		targetSumSubsets(arr, idx + 1, sum, target);
		
		if (idx == arr.length) {
			if (target == 0) return 1;
			return 2;
		}
		if (target == 0) return 1;
		if (target < 0) return 2;
		
		if (dp[idx][target] != 0) return dp[idx][target];
		
		int inc = targetSumSubsets(arr, idx + 1, target - arr[idx], dp);
		if (inc == 1) {
			dp[idx][target] = 1;
			return 1;
		}
		
		int exc = targetSumSubsets(arr, idx + 1, target, dp);
		int res = exc == 1 ? 1 : 2;
		dp[idx][target] = res;
		return res;
	}
	public static int coinChangePermutations(int arr[], int target) {
		int n = arr.length;
		int dp[] = new int [target + 1];
		dp[0] = 1;
		
		for (int i = 1; i <= target; i++) {
			for (int j = 0; j < n; j++) {
				dp[i] += (i - arr[j] >= 0) ? dp[i - arr[j]] : 0;  
			}
		}
		return dp[target];
	}
	public static int coinChangeCombinations(int arr[], int target) {
		int n = target;
		int dp[] = new int [n + 1];
		dp[0] = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j <= target; j++) {
				dp[j] += (j - arr[i] >= 0) ? dp[j - arr[i]] : 0;
			}
		}
		return dp[target];
	}
	
//	public static int zeroOneKnapsack(int val[], int wt[], int W, int n) {
//		if (n == 0 || W == 0) return 0;
//		if (wt[n - 1] <= W)
//			return Math.max(val[n - 1] + zeroOneKnapsack(val, wt, W - wt[n - 1], n - 1),
//					zeroOneKnapsack(val, wt, W, n - 1));
//		return zeroOneKnapsack(val, wt, W, n - 1);
//	}
	
//	public static int[][] dp = new int[102][1002];
//	public static int zeroOneKnapsack(int val[], int wt[], int W, int n) {
//		if (n == 0 || W == 0) return 0;
//		if (dp[n][W] != -1) return dp[n][W];
//		if (wt[n - 1] <= W)
//			dp[n][W] = Math.max(val[n - 1] + zeroOneKnapsack(val, wt, W - wt[n - 1], n - 1),
//					zeroOneKnapsack(val, wt, W, n - 1));
//		else dp[n][W] = zeroOneKnapsack(val, wt, W, n - 1);
//		return dp[n][W];
//	}
	
	public static int zeroOneKnapsack(int val[], int wt[], int W, int n) {
		int dp[][] = new int[n + 1][W + 1];
		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				if (wt[i - 1] <= j) {
					dp[i][j] = Math.max(val[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
				}
				else if (wt[i - 1] > j) dp[i][j] = dp[i - 1][j];
			}
		}
		return dp[n][W];
	}
	
	public static int unboundedKnapsack(int val[], int wt[], int W, int n) {
		int dp[] = new int[W + 1];
		
		for (int i = 1; i <= W; i++) {
			int max = 0; 
			for (int j = 0; j < n; j++) {
				if (i >= wt[j]) {
					int rem_cap = i - wt[j];
					int pr = dp[rem_cap] + val[j];
					if (pr > max) max = pr;
				}
			}
			dp[i] = max;
		}
		return dp[W];
	}
	
	public static int countBinaryStrings(int n) {
		int dp[][] = new int[2][n + 1];
		dp[0][1] = 1;
		dp[1][1] = 1;
		
		for (int i = 2; i <= n; i++) {
			dp[0][i] = dp[1][i - 1];
			dp[1][i] = dp[0][i - 1] + dp[1][i - 1];
		}
		
		return dp[0][n] + dp[1][n];
	}
	
	public static int countEncodings(String str) {
		int n = str.length();
		int dp[] = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {
				dp[i] = 0;
			} 
			else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {
				dp[i] = dp[i - 1];
			} 
			else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {
				if (str.charAt(i) == 1 || str.charAt(i) == 2) {
					dp[i] = i >= 2 ? dp[i - 2] : 1;
				}
				else dp[i] = 0;
			} 
			else {
				int val = Integer.parseInt(str.substring(i - 1, i + 1));
				if (val <= 26) dp[i] = dp[i - 1] + (i >= 2 ? dp[i - 2] : 1);
				else dp[i] = dp[i - 1];
			}
		}
		return dp[str.length() - 1];
	}
	
	public static int abcSubsequence(String str) {
		int a = 0;
		int ab = 0;
		int abc = 0;
		
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == 'a') a = 2 * a + 1;
			else if (c == 'b') ab = 2 * ab + a;
			else if (c == 'c') abc = 2 * abc + ab;
		}
		
		return abc;
	}
	
	public static int maxSumNonAdj(int arr[]) {
		int inc = arr[0];
		int exc = 0;
		for (int i = 1; i < arr.length; i++) {
			int ninc = exc + arr[i];
			int nexc = Math.max(inc, exc);
			
			inc = ninc;
			exc = nexc;
		}
		return Math.max(inc, exc);
	}
	
	public static long paintHouse(int arr[][], int n) {
		long dp[][] = new long[n][3];
		dp[0][0] = arr[0][0];
		dp[0][1] = arr[0][1];
		dp[0][2] = arr[0][2];
		
		for (int i = 1; i < n; i++) {
			dp[i][0] = arr[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = arr[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = arr[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}
		return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
	}
	
	public static int paintHouse2(int arr[][]) {
		int dp[][] = new int[arr.length][arr[0].length];
//		for (int j = 0; j < arr[0].length; j++) {
//			dp[0][j] = arr[0][j];
//		}
//		
//		for (int i = 1; i < dp.length; i++) {
//			for (int j = 0; j < dp[0].length; j++) {
//				int min = Integer.MAX_VALUE;
//				
//				for (int k = 0; k < dp[0].length; k++) {
//					if (k != j) {
//						if (dp[i - 1][k] < min) {
//							min = dp[i - 1][k];
//						}
//					}
//				}
//				
//				dp[i][j] = arr[i][j] + min;
//			}
//		}
		
//		int min = Integer.MAX_VALUE;
//		
//		for (int j = 0; j < dp[0].length; j++) {
//			int val = dp[dp.length - 1][j];
//			if (val < min) min = val;
//		}
		
		
		int least = Integer.MAX_VALUE;
		int s_least = Integer.MAX_VALUE;
		
		for (int j = 0; j < arr[0].length; j++) {
			dp[0][j] = arr[0][j];
			
			if (arr[0][j] <= least) {
				s_least = least;
				least = arr[0][j];
			}
			else if (arr[0][j] <= s_least) {
				s_least = arr[0][j];
			}
 		}
		
		for (int i = 1; i < dp.length; i++) {
			int nLeast = Integer.MAX_VALUE;
			int nSleast = Integer.MAX_VALUE;
			for (int j = 0; j < dp[0].length; j++) {
				if (least == dp[i - 1][j]) {
					dp[i][j] = arr[i][j] + s_least; 
				}
				else {
					dp[i][j] = arr[i][j] + least;
				}
				
				if (dp[i][j] <= nLeast) {
					nSleast = nLeast;
					nLeast = dp[i][j];
				}
				else if (dp[i][j] <= nSleast) {
					nSleast = dp[i][j];
				}
			}
			least = nLeast;
			s_least = nSleast;
		}
		
		
		
		return least;
	}
	
	public static void main(String args[]) {
//		System.out.println(fibonacci(6));
//		System.out.println(climbStairs(4));
//		int arr[] = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
//		System.out.println(climbStairsVariableJumps(arr));
//		System.out.println(minMovesToTop(arr));
//		int maze[][] = {
//				    {0, 1, 4, 2, 8, 2},
//					{4, 3, 6, 5, 0, 4},
//					{1, 2, 4, 1, 4, 6},
//					{2, 0, 7, 3, 2, 2},
//					{3, 1, 5, 9, 2, 4},
//					{2, 7, 0, 8, 5, 1},
//		};
//		System.out.println(minCostToTraversal(maze));
//		int arr[] = {4, 2, 7, 1, 3};
//	    int res = targetSumSubsets(arr, 0, 0, new int[6][11]);
//	    boolean result = res == 1 ? true : false;
//	    System.out.println(result);
//	    System.out.println(flag);
//		int arr[] = {2, 3, 5, 6};
//		System.out.println(coinChangePermutations(arr, 7));
//		System.out.println(coinChangeCombinations(arr, 7));
		
//		int val[] = {15, 14, 10, 45, 30};
//		int wt[] = {2, 5, 1, 3, 4};
//		
//		for (int vals[] : dp) Arrays.fill(vals, -1);
//		int res = zeroOneKnapsack(val, wt, 7, 5);
//		int res = unboundedKnapsack(val, wt, 7, 5);
//		int res = countBinaryStrings(6);
//		int res = countEncodings("123");
//		int res = abcSubsequence("abcabc");
//		int arr[] = {5, 10, 10, 100, 5, 6};
//		int res = maxSumNonAdj(arr);
		
		int arr[][] = {
						{1, 5, 7},
						{5, 8, 4},
						{3, 2, 9},
						{1, 2, 4},
					  };
//		long res = paintHouse(arr, 4);
		
		int res = paintHouse2(arr);
		System.out.println(res);
	}
}
