package BinaryTree;
import java.util.*;

public class BinaryTreeConstructor {
	public static class Node {
		int data;
		Node left;
		Node right;
		
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
	
	public static void display(Node node) {
		if (node == null) return;
		// node self work
		String str = "";
		str += node.left == null ? "." : node.left.data + "";
		str += " <- " + node.data + " -> ";
		str += node.right == null ? "." : node.right.data + "";
		
		System.out.println(str);
		// display node left
		display(node.left);
		// display node right
		display(node.right);
	}
	
	public static void main(String args[]) {
		Integer[] arr = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
		
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
			else if (top.state == 3) stk.pop();
		}
		display(root);
	}
}
