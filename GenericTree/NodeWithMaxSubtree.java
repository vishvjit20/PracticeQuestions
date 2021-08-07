package GenericTree;
import java.io.*;
import java.util.*;

public class NodeWithMaxSubtree {
	
	private static class Node {
	    int data;
	    ArrayList<Node> children = new ArrayList<>();
	}	
	
	public static Node construct(int[] arr) {
	    Node root = null;

	    Stack<Node> st = new Stack<>();
	    for (int i = 0; i < arr.length; i++) {
	      if (arr[i] == -1)  st.pop();
	      else {
	        Node t = new Node();
	        t.data = arr[i];
	        if (st.size() > 0) st.peek().children.add(t);
	        else root = t;
	        st.push(t);
	      }
	    }

	    return root;
	}

	static int max_sum_node = 0;
	static int max_sum = Integer.MIN_VALUE;
	public static int maxSum(Node node) {
		int sum = 0;
		
		for (Node child : node.children) {
			int c_s = maxSum(child);
			sum += c_s;
		}
		
		sum += node.data;
		if (sum > max_sum) {
			max_sum = sum;
			max_sum_node = node.data;
		}
		return sum;
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
	    maxSum(root);
	    System.out.println(max_sum_node + "@" + max_sum);
    }
}
