package BinaryTree;

import java.io.*;
import java.util.*;

public class NodeToRootPath {
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
	public static ArrayList<Integer> path;
	public static boolean find(Node node, int data) {
		if (node == null) return false;
		if (node.data == data) {
			path.add(node.data);
			return true;
		}
		
		boolean filc = find(node.left, data);
		if (filc) {
			path.add(node.data);
			return true;
		}
		
		boolean firc = find(node.right, data);
		if (firc) {
			path.add(node.data);
			return true;
		}
		
		return false;
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
		
		int data = Integer.parseInt(br.readLine());
		
		Node root = construct(arr);
		path = new ArrayList<>();
		find(root, data);
	    System.out.println(path);
	}
}
