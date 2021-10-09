package Trees;

import java.util.*;

public class ConstructBinaryTreeFromPreAndPost {
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
	
	public static TreeNode buildTree(int[] pre, int[] post) {
		int n = pre.length;
		return helper(pre, post, 0, n - 1, 0, n - 1);
	}
	
	public static TreeNode helper(int[] pre, int[] post, int ps, int pe, int pos, int poe) {
		if (ps > pe) return null;
		TreeNode node = new TreeNode(pre[ps]);
		if (ps == pe) return node;
		
		int idx = pos;
	    while (post[idx] != pre[ps + 1]) idx++;	
		
		int tnel = idx - pos + 1;
		
		node.left = helper(pre, post, ps + 1, ps + tnel, pos, idx);
		node.right = helper(pre, post, ps + tnel + 1, pe, idx + 1, poe - 1);
		
		return node;
	}
	
	public static void solve() {
		int n = sc.nextInt();
		
		int pre[] = new int[n];
		int post[] = new int[n];
		
		for (int i = 0; i < n; i++) post[i] = sc.nextInt();
		for (int i = 0; i < n; i++) pre[i] = sc.nextInt();
		
		TreeNode root = buildTree(pre, post);
		display(root);
	}
	
	public static void main(String args[]) {
		solve();
	}
}
