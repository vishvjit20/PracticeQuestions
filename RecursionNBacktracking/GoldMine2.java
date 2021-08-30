package RecursionNBacktracking;

public class GoldMine2 {
	static int max = 0;
	static int sum = 0;
	public static void getMaxGold(int[][] arr){
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] != 0) {
					sum = 0;
					getMaxGold(arr, i, j);
					if (max < sum) max = sum;
				}
			}
		}
	}
	public static void getMaxGold(int arr[][], int i, int j) {
		if (i < 0 || i >= arr.length || j < 0 || j >= arr[0].length || arr[i][j] == 0) return;
		sum += arr[i][j];
		arr[i][j] = 0;
		getMaxGold(arr, i + 1, j);
		getMaxGold(arr, i - 1, j);
		getMaxGold(arr, i, j + 1);
		getMaxGold(arr, i, j - 1);
	}
	public static void main(String args[]) {
		
		int[][] arr = {
						{0, 1, 4, 2, 8, 2},
						{4, 3, 6, 5, 0, 4},
						{1, 2, 4, 1, 4, 6},
						{2, 0, 7, 3, 2, 2},
						{3, 1, 5, 9, 2, 4},
						{2, 7, 0, 8, 5, 1},
					};
		
		getMaxGold(arr);
		System.out.println(max);
	}
}
