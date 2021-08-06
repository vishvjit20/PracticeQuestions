package GenericTree;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class KthLargest {
	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	
	private static Node construct(int arr[]) {
		Node root = null;
		Stack<Node> stk = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				stk.pop();
			}
			else {
				Node temp = new Node();
				temp.data = arr[i];
				if (stk.size() > 0) stk.peek().children.add(temp);
				else root = temp;
				
				stk.push(temp);
			}
		}
		return root;
	}
	
	static int ceil;
	static int floor;
	public static void ceilAndFloor(Node node, int data) {
		if (node.data > data && node.data < ceil) ceil = node.data;
		if (node.data < data && node.data > floor) floor = node.data;
		
		for (Node child : node.children) {
			ceilAndFloor(child, data);
		}
	}
	
	public static int kthLargest(Node root, int k) {
		floor = Integer.MIN_VALUE;
		int factor = Integer.MAX_VALUE;
		for (int i = 0; i < k ;i++) {
			ceilAndFloor(root, factor);
			factor = floor;
			floor = Integer.MIN_VALUE;
		}
		return factor;
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
		
		int k = sc.nextInt();
		Node root = construct(arr);
		int kthLargest = kthLargest(root, k);
	    System.out.println(kthLargest);
		sc.close();
	}
}
