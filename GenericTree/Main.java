package GenericTree;
import java.util.*;

public class Main {
	private static class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
		Node() {}
		public Node (int data) {
			this.data = data;
		}
		
	}
	
	private static void display(Node node) {
		
		System.out.print(node.data + " -> ");
		for (Node child : node.children) {
			System.out.print(child.data + ", ");
		}
		System.out.println();
		for (Node child : node.children) {
			display(child);
		}
	}
	
	private static int size(Node node) {	
		int size = 0;
		for (Node child : node.children) {
			size += size(child);
		}
		size++;
		return size;
	}
	
	private static int height(Node node) {
		int height = -1;
		for (Node child : node.children) {
			height = Math.max(height, height(child));
		}
		height = height + 1;
		return height;
	}
    
	private static void traversals(Node node) {
		System.out.println("Node pre " + node.data);
		for (Node child : node.children) {
			System.out.println("Edge pre" + child.data);
			traversals(child);
			System.out.println("Edge post" + child.data);
		}
		System.out.println("Node post" + node.data);
	}
	
	private static void levelOrder(Node node) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(node);
		
		while (!queue.isEmpty()) {
			Node rem = queue.remove();
			System.out.print(rem.data + " ");
			for (Node child : rem.children) {
				queue.add(child);
			}
		}
	}

	private static class Pair {
		Node node;
		int level;
		public Pair (Node node, int level) {
			this.node = node;
			this.level = level;
		}
	}
	
	private static void levelOrderLinewise(Node node) {
//		Approach - 1
//		Queue<Node> mq = new ArrayDeque<>();
//		Queue<Node> cq = new ArrayDeque<>();
//		mq.add(node);
//		
//		while (!mq.isEmpty()) {
//			Node rem = mq.remove();
//			System.out.print(rem.data + " ");
//			for (Node child : rem.children) {
//				cq.add(child);
//			}
//			if (mq.isEmpty()) {
//				mq = cq;
//				cq = new ArrayDeque<>();
//				System.out.println();
//			}
//		}
		
//		Approach - 2
//		Queue<Node> q = new ArrayDeque<>();
//		q.add(node);
//		q.add(new Node(-1));
//		
//		while (q.size() > 0) {
//			node = q.remove();
//			if (node.data != -1) {
//				System.out.print(node.data + " ");
//				for (Node child : node.children) q.add(child);
//			}
//			else {
//				if (q.size() > 0) {
//					q.add(new Node(-1));
//					System.out.println();
//				}
//			}
//		}
		
//		Approach - 3
//		Queue<Node> q = new ArrayDeque<>();
//		q.add(node);
//		
//		while (!q.isEmpty()) {
//			int count = q.size();
//
//			for (int i = 0; i < count; i++) {
//				node = q.remove();
//				System.out.print(node.data + " ");
//				for (Node child : node.children) q.add(child);
//			}
//			System.out.println();
//		}
		
//		Approach - 4
		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(node, 1));
		
		int level = 1;
		while (!q.isEmpty()) {
			Pair p = q.remove();
			if (level < p.level) {
				level = p.level;
				System.out.println();
			}
			System.out.print(p.node.data + " ");
			for (Node child : p.node.children) {
				q.add(new Pair(child, p.level + 1));
			}
		}
	}

	private static void levelOrderLinewiseZZ(Node node) {
		Stack<Node> ms = new Stack<>();
		Stack<Node> cs = new Stack<>();
		
		ms.push(node);
		int level = 0;
		while (!ms.isEmpty()) {
			node = ms.pop();
			System.out.print(node.data + " ");
			if (level % 2 == 0) {
				for (int i = 0; i < node.children.size(); i++) {
					cs.push(node.children.get(i));
				}
			}
			else {
				for (int i = node.children.size() - 1; i >= 0; i--) {
					cs.push(node.children.get(i));
				}
			}
			if (ms.size() == 0) {
				ms = cs;
				cs = new Stack<>();
				level++;
				System.out.println();
			}
		}
	}
	
	private static Node constructor(int arr[]) {
		Node root = null;
		Stack<Node> stk = new Stack<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == -1) stk.pop();
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
	
	private static void mirror(Node node) {
		for (Node child : node.children) {
			mirror(child);
		}
		Collections.reverse(node.children);
	}
	
	public static void removeLeaves(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);
			if (child.children.size() == 0) {
				node.children.remove(child);
			}
		}
		for (Node child : node.children) {
			removeLeaves(child);
		}
	}
	
	public static void linearize(Node node) {
		for (Node child : node.children) {
			linearize(child);
		}
		while (node.children.size() > 1) {
			Node last = node.children.remove(node.children.size() - 1);
			Node slast = node.children.get(node.children.size() - 1);
			Node slt = getTail(slast);
			slt.children.add(last);
		}
	}
	
	private static Node getTail(Node node) {
		while(node.children.size() == 1) {
			node = node.children.get(0);
		}
		return node;
	}
	
	private static boolean findInTree(Node node, int data) {
		if (node.data == data) {
			return true;
		}
		for (Node child : node.children) {
			boolean find = findInTree(child, data);
			if (find) return true;
		}
		return false;
	}
	
	private static ArrayList<Integer> nodeToRootPath(Node node, int data) {
		if (node.data == data) {
			ArrayList<Integer> res = new ArrayList<>();
			res.add(node.data);
			return res;
		}
		
		for (Node child : node.children) {
			ArrayList<Integer> res = nodeToRootPath(child, data);
			if (res.size() > 0) {
				res.add(node.data);
				return res;
			}
		}
		return new ArrayList<>();
	}
	
	private static int lca(Node node, int d1, int d2) {
		ArrayList<Integer> path1 = nodeToRootPath(node, d1);
		ArrayList<Integer> path2 = nodeToRootPath(node, d2);
		
		int i = path1.size() - 1;
		int j = path2.size() - 1;
		while (i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
			i--;
			j--;
		}
		i++;
		j++;
		return path1.get(i);
	}
	
	private static int distance(Node node, int d1, int d2) {
		ArrayList<Integer> path1 = nodeToRootPath(node, d1);
		ArrayList<Integer> path2 = nodeToRootPath(node, d2);
		
		int i = path1.size() - 1;
		int j = path2.size() - 1;
		
		while (i >= 0 && j >= 0 && path1.get(i) == path2.get(j)) {
			i--;
			j--;
		}
		i++;
		j++;
		return i + j;
	}
	
	private static boolean areSimilar(Node n1, Node n2) {
		if (n1.children.size() != n2.children.size()) return false;
		for (int i = 0; i < n1.children.size(); i++) {
			Node c1 = n1.children.get(i);
			Node c2 = n2.children.get(i);
			if (!areSimilar(c1, c2)) return false;
		}
		return true;
	}
	
	private static int max_sum_node = 0;
	private static int max_sum = Integer.MIN_VALUE;
	private static int maxSubtreeSum(Node node) {
		int sum = 0;
		
		for (Node child : node.children) {
			int c_s = maxSubtreeSum(child);
			sum += c_s;
		}
		sum += node.data;
		if (sum > max_sum) {
			max_sum = sum;
			max_sum_node = node.data;
		}
		return sum;
	}
	
	private static boolean areMirror(Node n1, Node n2) {
		if (n1.children.size() != n2.children.size()) return false;
		for (int i = 0; i < n1.children.size(); i++) {
			int j = n1.children.size() - i - 1;
			Node c1 = n1.children.get(i);
			Node c2 = n2.children.get(j);
			if (!areMirror(c1, c2)) return false;
		}
		return true;
	}

	private static boolean isSymmatric(Node node) {
		return areMirror(node, node);
	}
	
	private static Node predecessor;
	private static Node successor;
	private static int state = 0;
	private static void predecessorNSuccessor(Node node, int data) {
		if (state == 0) {
			if (node.data == data) state = 1;
			else predecessor = node;
		}
		else if (state == 1) {
			successor = node;
			state = 2;
		}
		
		for (Node child : node.children) {
			predecessorNSuccessor(child, data);
		}
	}
	
	private static int ceil = Integer.MAX_VALUE;
	private static int floor = Integer.MIN_VALUE;
	private static void ceilNFloor(Node node, int data) {
		if (node.data > data && node.data < ceil) ceil = node.data;
		if (node.data < data && node.data > floor) floor = node.data;
		
		for (Node child : node.children) {
			ceilNFloor(child, data);
		}
	}
	
	private static int dia = 0;
	private static int diameter(Node node) {
		int deepest = -1;
		int sDeepest = -1;
		
		for (Node child : node.children) {
			int ch = diameter(child);
			if (ch > deepest) {
				sDeepest = deepest;
				deepest = ch;
			}
			else if (ch > sDeepest) {
				sDeepest = ch;
			}
		}
		int temp_dia = deepest + sDeepest + 2;
		if (temp_dia > dia) dia = temp_dia;
		
		deepest += 1;
		return deepest;
	}
	
	public static void main(String args[]) {
		int arr[] = {10, 20, 50, -1, 60, -1,  -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
	    Node root = constructor(arr);
	    diameter(root);
	    System.out.println(dia);
	}
}
