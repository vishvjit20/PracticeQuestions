package GenericTree;
import java.util.*;

public class GenericTreeConstructor {
	  public static class Node {
		  int data;
		  ArrayList<Node> children = new ArrayList<>();
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
	  
	  public static void main(String args[]) {
		  int arr[] = {10, 20, 50, -1, 60, -1,  -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
		  Node root = null;
		  Stack<Node> stk = new Stack<>();
		  for (int i = 0; i < arr.length; i++) {
			  if (arr[i] != -1) {
				  Node t = new Node();
				  t.data = arr[i];
				  if (stk.size() > 0) stk.peek().children.add(t);
				  else root = t;
				  stk.push(t);
			  }
			  else stk.pop();
		  }
		  display(root);
	  }
}
