package SortingAlgos;

public class CountSort {
	public static void countSort(int arr[], int min, int max) {
		int range = max - min + 1;
		int freq[] = new int[range];
		
		for (int i = 0; i < arr.length; i++) {
			int idx = arr[i] - min;
			freq[idx]++;
		}
		
//		for (int )
	}
}
