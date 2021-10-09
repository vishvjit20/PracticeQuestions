package Trees;
import java.util.*;

public class ConstructBinaryTreeFromInAndLevel {
	public static Scanner sc = new Scanner(System.in);
	public static class TreeNode {
		int val = 0;
		TreeNode left = null, right = null;
		public TreeNode(int val) {
			this.val = val;
		}
	}
	
	public static void display(TreeNode node) {
		if (node == null) return;
		StringBuilder sb = new StringBuilder();
		sb.append(node.left != null ? node.left.val : ".");
		sb.append(" <- " + node.val + " -> ");
		sb.append(node.right != null ? node.right.val : ".");
		System.out.println(sb.toString());
		
		display(node.left);
		display(node.right);
	}
	public static Map<Integer, Integer> map;
	public static TreeNode buildTree(int[] in, int[] level) {
		int n = in.length;
		map = new HashMap<>();
		for (int i = 0; i < n; i++) map.put(in[i], i);
		return helper(in, level, 0, n - 1);
	}
	
	public static TreeNode helper(int[] in, int level[], int is, int ie) {
		if (is > ie) return null;
		TreeNode node = new TreeNode(level[0]);
		int k = map.get(node.val);
		
		int ls = k - is;
		int rs = level.length - ls - 1;
		
		int llo[] = new int[ls];
		int rlo[] = new int[rs];
		
		int p = 0, q = 0;
		for (int i = 1; i < level.length; i++) {
			int idx = map.get(level[i]);
			if (idx < k) llo[p++] = level[i];
			else if (idx > k) rlo[q++] = level[i];
		}
		
		node.left = helper(in, llo, is, k - 1);
		node.right = helper(in, rlo, k + 1, ie);
		return node;
	}
	
	public static void solve() {
		int n = sc.nextInt();
		
		int in[] = new int[n];
		int level[] = new int[n];
		
		for (int i = 0; i < n; i++) in[i] = sc.nextInt();
		for (int i = 0; i < n; i++) level[i] = sc.nextInt();
		
		TreeNode root = buildTree(in, level);
		display(root);
	}
	
	public static void main(String args[]) {
		solve();
	}
}
