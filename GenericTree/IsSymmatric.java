package GenericTree;
import java.io.*;
import java.util.*;

public class IsSymmatric {
	private static class Node {
	    int data;
	    ArrayList<Node> children = new ArrayList<>();
	}

	public static Node construct(int[] arr) {
	    Node root = null;

	    Stack<Node> st = new Stack<>();
	    for (int i = 0; i < arr.length; i++) {
	      if (arr[i] == -1) {
	        st.pop();
	      } else {
	        Node t = new Node();
	        t.data = arr[i];

	        if (st.size() > 0) {
	          st.peek().children.add(t);
	        } else {
	          root = t;
	        }

	        st.push(t);
	      }
	    }

	    return root;
	}

	public static boolean areMirror(Node n1, Node n2) {
		if (n1.children.size() != n2.children.size()) {
			return false;
		}
		
		for (int i = 0; i < n1.children.size(); i++) {
			int j = n1.children.size() - i - 1;
			Node c1 = n1.children.get(i);
			Node c2 = n2.children.get(j);
			if (!areMirror(c1, c2)) return false;
		}
		return true;
	}
	
	public static boolean IsSymmetric(Node node) {
		return areMirror(node, node) ? true : false;
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
	    boolean sym = IsSymmetric(root);
	    System.out.println(sym);
	}
}
