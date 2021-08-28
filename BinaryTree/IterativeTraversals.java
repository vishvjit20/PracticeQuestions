package BinaryTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class IterativeTraversals {
	public static class Node {
		int data;
		Node left, right;
		public Node (int data, Node left, Node right) {
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
	public static Node construct(Integer arr[]) {
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
			else stk.pop();
		}
		return root;
	}
	public static void iterativePrePostInTraversal(Node node) {
		Stack<Pair> stk = new Stack<>();
		Pair rtp = new Pair(node, 1);
		stk.push(rtp);
		String pre = "";
		String in = "";
		String post = "";
		while (stk.size() > 0) {
			Pair top = stk.peek();
			if (top.state == 1) {
				pre += top.node.data + " ";
				top.state++;
				if (top.node.left != null) {
					Pair lp = new Pair(top.node.left, 1);
					stk.push(lp);
				}
			}
			else if (top.state == 2) {
				in += top.node.data + " ";
				top.state++;
				if (top.node.right != null) {
					Pair rp = new Pair(top.node.right, 1);
					stk.push(rp);
				}
			}
			else {
				post += top.node.data + " ";
				stk.pop();
			}
		}
		System.out.println(pre);
		System.out.println(in);
		System.out.println(post);
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
		iterativePrePostInTraversal(root);
	}
}
