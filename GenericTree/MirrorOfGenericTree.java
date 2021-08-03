package GenericTree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;


public class MirrorOfGenericTree {
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

	public static void display(Node node) {
		  String str = node.data + " -> ";
		  for (Node child : node.children) {
			  str += child.data + ", ";
		  }
		  System.out.println(str);
		  
		  for (Node child : node.children) {
			  display(child);
		  }
	  }
	
	public static void mirror(Node node){
		for (Node child : node.children) {
			mirror(child);
		}
		Collections.reverse(node.children);
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
	    display(root);
	    mirror(root);
	    display(root);
	}
	
}
