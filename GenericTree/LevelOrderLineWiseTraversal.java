package GenericTree;
import java.io.*;
import java.util.*;

public class LevelOrderLineWiseTraversal {
	  private static class Node {
	    int data;
	    ArrayList<Node> children = new ArrayList<>();
	    Node () {}
	    public Node (int data) {
	    	this.data = data;
	    }
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

//	  public static void levelOrderLinewise(Node node){
//		  Queue<Node> mq = new ArrayDeque<>();
//		  Queue<Node> cq = new ArrayDeque<>();
//		  mq.add(node);
//		  
//		  while (mq.size() > 0) {
//			  node = mq.remove();
//			  System.out.print(node.data + " ");
//			  for (Node child : node.children) {
//				  cq.add(child);
//			  }
//			  
//			  if (mq.size() == 0) {
//				  mq = cq;
//				  cq = new ArrayDeque<>();
//				  System.out.println();
//			  }
//		  }
//	  }
	  
	  // Approach 2
//	  public static void levelOrderLinewise(Node node) {
//		  Queue<Node> que = new ArrayDeque<>();
//		  que.add(node);
//		  que.add(new Node(-1));
//		  
//		  while (que.size() > 0) {
//			  node = que.remove();
//			  if (node.data != -1) {
//				  System.out.print(node.data + " ");
//				  for (Node child : node.children) que.add(child);
//			  }
//			  else {
//				  if (que.size() > 0) {
//					  que.add(new Node(-1));
//					  System.out.println();
//				  }
//			  }
//		  }
//	  }
	  
	  // Approach 3
//	  public static void levelOrderLinewise(Node node) {
//		  Queue<Node> que = new ArrayDeque<>();
//		  que.add(node);
//		  
//		  while (que.size() > 0) {
//			  int count = que.size();
//			  
//			  for (int i = 0; i < count; i++) {
//				  node = que.remove();
//				  System.out.print(node.data + " ");
//				  for (Node child : node.children) {
//					  que.add(child);
//				  }
//			  }
//			  
//			  System.out.println();
//		  }
//	  }
	  
	  
	  public static class Pair {
		  Node node;
		  int level;
		  public Pair(Node node, int level) {
			  this.node = node;
			  this.level = level;
		  }
	  }
	  
	  // Approach 4
	  public static void levelOrderLinewise(Node node) {
		  Queue < Pair > que = new ArrayDeque<>();
		  que.add(new Pair(node, 1));
		  
		  int level = 1;
		  while (que.size() > 0) {
			  Pair p = que.remove();
			  if (level < p.level) {
				  level = p.level;
				  System.out.println();
			  }
			  System.out.print(p.node.data + " ");
			  for (Node child : p.node.children) {
				  Pair cp = new Pair(child, p.level + 1);
				  que.add(cp);
			  }
		  }
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
	    levelOrderLinewise(root);
	  }
}
