package Stack;
import java.util.*;

public class StackLevel1 {
	public static boolean duplicateBracket(String str) {
		Stack<Character> stk = new Stack<>();
		for (char c : str.toCharArray()) {
			if (c == '(') stk.push(c);
			else if (c == ')') {
				if (stk.peek() == '(') return true;
				else {
					while(stk.peek() != '(') stk.pop();
					stk.pop();
				}
			}
			else stk.push(c);
		}
		
		return false;
	}

	public static boolean balancedBracket(String str) {
		Stack <Character> stk = new Stack<>();
		for (char c : str.toCharArray()) {
			if (c == '[' || c == '{' || c == '(') stk.push(c);
			else if (c == ']') {
				if (stk.isEmpty() || stk.peek() != '[') return false;
				stk.pop();
			}
			else if (c == '}') {
				if (stk.isEmpty() || stk.peek() != '{') return false;
				stk.pop();
			}
			else if (c == ')') {
				if (stk.isEmpty() || stk.peek() != '(') return false;
				stk.pop();
			}
		}
		if (!stk.isEmpty()) return false;
		return true;
	}
	
	// 2, 5,  9,  3,  1, 12, 6,  8,  7
	// 5, 9, 12, 12, 12, -1, 8, -1, -1
	
	public static int[] ngr(int arr[]) {
		int n = arr.length;
		int[] res = new int[n];
		Stack<Integer> stk = new Stack<>();
		res[n - 1] = -1;
		stk.push(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			while (!stk.isEmpty() && arr[stk.peek()] < arr[i]) stk.pop();
			if (stk.isEmpty()) res[i] = -1;
			else res[i] = arr[stk.peek()];
			stk.push(i);
		}
		return res;
	}
	
	// 2, 5, 9, 3, 1, 12, 6, 8, 7
	// 1, 2, 3, 1, 1,  6, 1, 2, 1
	
	public static int[] stockSpan(int[] arr) {
		int n = arr.length;
		int res[] = new int[n];
		Stack<Integer> stk = new Stack<>();
		stk.push(0);
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			while (stk.size() > 0 && arr[i] >= arr[stk.peek()]) stk.pop();
			if (stk.size() == 0) res[i] = i + 1;
			else res[i] = i - stk.peek();
			stk.push(i);
		}
		return res;
	}

	
	public static int largestAreaOfHisto(int arr[]) {
		int n = arr.length;
		int []lb = new int[n];
		Stack<Integer> stk = new Stack<>();
		stk.push(0);
		lb[0] = -1;
		for (int i = 1; i < n; i++) {
			while (!stk.isEmpty() && arr[i] <= arr[stk.peek()]) stk.pop();
			if (stk.isEmpty()) lb[i] = -1;
			else lb[i] = stk.peek();
			stk.push(i);
		}
		
		int[] rb = new int[n];
		stk = new Stack<>();
		stk.push(n - 1);
		rb[n - 1] = n;
		for (int i = n - 2; i >= 0; i--) {
			while (!stk.isEmpty() && arr[i] <= arr[stk.peek()]) stk.pop();
			if (stk.isEmpty()) rb[i] = n;
			else rb[i] = stk.peek();
			stk.push(i);
		}
		
		int maxArea = 0;
		for (int i = 0; i < arr.length; i++) {
			int width = rb[i] - lb[i] - 1;
			int area = arr[i] * width;
			if (area > maxArea) {
				maxArea = area;
			}
		}
		
		return maxArea;
	}
	
	// [2 9 3 8 1 7 12 6 14 4 32 0 7 19 8 12 6], k = 4
	// [9 9 8 12 12 14 14 32 32 32 32 19 19 19]
	
	public static int[] slidingWindowMax(int arr[], int k) {
		int n = arr.length;
		int nge[] = new int[n];
		nge[n - 1] = n;
		Stack<Integer> stk = new Stack<>();
		stk.push(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			while (!stk.isEmpty() && arr[i] >= arr[stk.peek()]) stk.pop();
			if (stk.isEmpty()) nge[i] = n;
			else nge[i] = stk.peek();
			stk.push(i);
		}
		
		int res[] = new int[n - k + 1];
		int j = 0;
		for (int i = 0; i <= n - k; i++) {
			if (j < i) j = i;
			while (nge[j] < i + k) {
				j = nge[j];
			}
			res[i] = arr[j];
		}
		return res;
	}
	
	public static int findCelebrity(int[][] arr) {
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < arr.length; i++) stk.push(i);
		
		while (stk.size() >= 2) {
			int i = stk.pop();
			int j = stk.pop();
			if (arr[i][j] == 1) stk.push(j);
			else stk.push(i);
		}
		
		int pot = stk.pop();
		for (int i = 0; i < arr.length; i++) {
			if (i != pot) {
				if (arr[i][pot] == 0 || arr[pot][i] == 1) return -1;
			}
		}
		return pot;
	}
	
	public static void main(String args[]) {
//		String str = "((a + b) + ((c - d)))";
//		boolean res = duplicateBracket(str);
//		boolean res = balancedBracket("([(a + b) + {(c + d) * (e / f)}]");
//		int[] res = ngr(new int[]{2, 5, 9, 3, 1, 12, 6, 8, 7});
//		int res[] = stockSpan(new int[] {2, 5, 9, 3, 1, 12, 6, 8, 7});
//		int res = largestAreaOfHisto(new int[] {6, 2, 5, 4, 5, 1, 6});
//		System.out.println(res);
		int res[] = slidingWindowMax(new int[] {2, 9, 3, 8, 1, 7, 12, 6, 14, 4, 32, 0, 7, 19, 8, 12, 6}, 4);
		System.out.println(Arrays.toString(res));
	}
}
