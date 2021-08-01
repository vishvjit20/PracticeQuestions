package GenericTree;
import java.io.*;
import java.util.*;

public class MaximumInGenericTree {

	public static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}
	
	public static Node construct(int arr[]) {
		Node root = null;
		Stack<Node> stk = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) {
				stk.pop();
			}
			else {
				Node temp = new Node();
				temp.data = arr[i];
				if (!stk.isEmpty()) stk.peek().children.add(temp);
				else root = temp;
				stk.push(temp);
			}
		}
		return root;
	}
	
	public static int max(Node node) {
		int max = Integer.MIN_VALUE;
		for (Node child : node.children) {
			int cm = max(child);
			max = Math.max(cm, max);
		}
		max = Math.max(max, node.data);
		return max;
	}
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		String values[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(values[i]);
		}
		
		Node root = construct(arr);
		int m = max(root);
		System.out.println(m);
	}
}
