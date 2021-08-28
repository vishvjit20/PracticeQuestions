package BinaryTree;

import java.util.*;
import java.io.*;

public class SizeSumMaxNHeightOfBT {
	public static class Node {
		int data;
		Node left, right;
		
		Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	public static class Pair {
		Node node;
		int state;
		public Pair(Node node, int state) {
			this.node = node;
			this.state = state;
		}
	}
	public static Node construct(Integer[] arr) {
		Node root = new Node(arr[0], null, null);
		Pair rtp = new Pair(root, 1);
		Stack<Pair> stk = new Stack<>();
		stk.push(rtp);
		int idx = 0;
		while (stk.size() > 0) {
			Pair top = stk.peek();
			if (top.state == 1) {
				idx++;
				if (arr[idx] != null) {
					top.node.left = new Node(arr[idx], null, null);
					Pair lp = new Pair(top.node.left, 1);
					stk.push(lp);
				}
				else top.node.left = null;
				top.state++;
			}
			else if (top.state == 2) {
				idx++;
				if (arr[idx] != null) {
					top.node.right = new Node(arr[idx], null, null);
					Pair rp = new Pair(top.node.right, 1);
					stk.push(rp);
				}
				else top.node.right = null;
				top.state++;
			}
			else {
				stk.pop();
			}
		}
		return root;
	}
	public static int size(Node root) {
		if (root == null) return 0;
		int left = size(root.left);
		int right = size(root.right);
		int size = left + right + 1;
		return size;
	}
	public static int sum(Node root) {
		if (root == null) return 0;
		int ls = sum(root.left);
		int rs = sum(root.right);
		int sum = ls + rs + root.data;
		return sum;
	}
	public static int max(Node root) {
		if (root == null) return Integer.MIN_VALUE;
		int leftMax = max(root.left);
		int rtMax = max(root.right);
		int max = Math.max(root.data, Math.max(leftMax, rtMax));
		return max;
	}
	public static int height(Node root) {
		if (root == null) return -1;
		int ltHt = height(root.left);
		int rtHt = height(root.right);
		int maxHt = Math.max(ltHt, rtHt) + 1;
		return maxHt;
	}
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Integer[] arr = new Integer[n];
		String[] vals = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			if (!vals[i].equals("n")) arr[i] = Integer.parseInt(vals[i]);
			else arr[i] = null;
		}
		
		Node root = construct(arr);
		int size = size(root);
		int sum = sum(root);
		int max = max(root);
		int ht = height(root);
		System.out.println(size);
		System.out.println(sum);
		System.out.println(max);
		System.out.println(ht);
	}
}
