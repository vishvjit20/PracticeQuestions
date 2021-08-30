package DynamicProgramming;

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
	}
}
