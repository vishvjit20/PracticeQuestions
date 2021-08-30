package Arrays;

public class BasicQuestions {
    
    public static int span(int arr[]) {
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	
    	for (int i = 0; i < arr.length; i++) {
    		if (arr[i] > max) max = arr[i];
    		if (arr[i] < min) min = arr[i];
    	}
    	return max - min;
    }
    public static int findNumber(int arr[] , int x) {
    	for (int i = 0 ; i < arr.length; i++) {
    		if (arr[i] == x) return i;
    	}
    	return -1;
    }
    public static void printBarChart(int arr[]) {
    	int max = Integer.MIN_VALUE;
    	for (int i = 0; i < arr.length; i++) max = Math.max(max, arr[i]);
    	for (int floor = max; floor >= 1; floor--) {
    		for (int i = 0 ; i < arr.length; i++) {
    			if (arr[i] >= floor) System.out.print("* ");
    			else System.out.print("  ");
    		}
    		System.out.println();
    	}
    }
    public static void rotate(int arr[], int start, int end) {
    	while (start < end) {
    		int temp = arr[start];
    		arr[start] = arr[end];
    		arr[end] = temp;
    		start++;
    		end--;
    	}
    }
    public static void rotateArr(int arr[], int k) {
    	int n = arr.length;
    	rotate(arr, 0, n - k - 1);
    	rotate(arr, n - k, n - 1);
    	rotate(arr, 0, n - 1);
    }
    public static int[] inverse(int arr[]) {
    	int []inv = new int[arr.length];
    	for (int i = 0; i < arr.length; i++) {
    		inv[arr[i]] = i;
    	}
    	return inv;
    }
    public static void subarr(int arr[]) {
    	int n = arr.length;
    	for (int i = 0; i < n; i++) {
    		for (int j = i; j <= n; j++) {
    			for (int k = i; k < j; k++) {
    				System.out.print(arr[k] + " ");
    			}
    			if (j > i) System.out.println();
    		}
    	}
    }
    public static void subsets(int arr[]) {
    	int n = arr.length;
    	int ts = (int)Math.pow(2, n);
    	
    	for (int d = 0; d < ts; d++) {
    		int binary[] = binary(d, n);
    		for (int i = 0; i < n; i++) {
    			if (binary[i] == 0) System.out.print("- ");
    			else System.out.print(arr[i] + " ");
    		}
    		System.out.println();
    	}
    }
    public static int[] binary(int d, int n) {
    	int arr[] = new int[n];
    	int cnt = n - 1;
    	while (d > 0) {
    		arr[cnt] = d % 2;
    		d = d / 2;
    		cnt--;
    	}
    	return arr;
    }
    public static void nearestDenomination(int arr[], int d) {
    	int low = 0;
    	int high = arr.length - 1;
    	int x = d, y = d;
    	while (low <= high) {
    		int mid = low + (high - low) / 2;
    		if (arr[mid] == d) {
    			x = y = arr[mid];
    			System.out.println(x);
    			return;
    		}
    		else if (arr[mid] > d) {
    			high = mid - 1;
    			y = arr[mid - 1];
    		}
    		else {
    			low = mid + 1;
    			x = arr[mid + 1];
    		}
    	}
    	System.out.println(x + " <-> " + y);
    }
    public static int maxSum(int arr[]) {
    	int max_sum = Integer.MIN_VALUE;
    	int sum = 0;
    	for (int i = 0; i < arr.length; i++) {
    		if (sum < 0) sum = 0;
    		sum += arr[i];
    		max_sum = Math.max(max_sum, sum);
    	}
    	return max_sum;
    }
    public static void main(String[] args) {
//        int arr[] = {15, 30, 40, 4, 11, 9};
//        System.out.println(span(arr));
//        System.out.println(findNumber(arr, 40));
//    	  int arr[] = {1, 2, 3, 4, 5, 6, 7};
//    	  printBarChart(arr);
//    	  rotateArr(arr, 3);
//    	  for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
//    	  int arr[] = {4, 0, 2, 3, 1};
//    	  int res[] = inverse(arr);
//    	  for (int i = 0; i < res.length; i++) System.out.print(res[i] + " ");
//    	  subarr(arr);
//    	  subsets(arr);
//    	  int arr[] = {1, 5, 10, 15, 22, 33, 40, 42, 55, 66, 34};
//    	  nearestDenomination(arr, 66);
    	  int arr[] = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    	  System.out.println(maxSum(arr));
    }
}
