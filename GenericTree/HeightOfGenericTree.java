package GenericTree;
import java.util.*;
import java.io.*;

public class HeightOfGenericTree {
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
	
	public static int height(Node node) {
		int height = -1;	
		for (Node child : node.children) {
			height = Math.max(height, height(child));
		}
		height += 1;
		
		return height;
	}
	
	public static void main(String[] args) throws Exception {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[] arr = new int[n];
	    String[] values = br.readLine().split(" ");
	    for (int i = 0; i < n; i++) {
	      arr[i] = Integer.parseInt(values[i]);
	    }

	    Node root = construct(arr);
	    int h = height(root);
	    System.out.println(h);
	  }
}
