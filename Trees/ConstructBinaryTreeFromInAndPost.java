package Trees;
import java.util.*;

public class ConstructBinaryTreeFromInAndPost {
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
		sb.append(node.left == null ? "." : node.left.val);
		sb.append(" <- " + node.val + " ->");
		sb.append(node.right == null ? "." : node.right.val);
		
		System.out.println(sb.toString());
		
		display(node.left);
		display(node.right);
	}
	
	public static TreeNode buildTree(int in[], int post[]) {
		int n = post.length;
		return helper(post, in, 0, n - 1, 0, n - 1);
	}
	
	public static TreeNode helper(int []post, int []in, int ps, int pe, int is, int ie) {
		if (ps > pe) return null;
		TreeNode node = new TreeNode(post[pe]);
		int k = -1;
		for (int i = is; i <= ie; i++) {
			if (in[i] == node.val) {
				k = i;
				break;
			}
		}
		int cls = k - is;
		node.left = helper(post, in, ps, ps + cls - 1, is, k - 1);
		node.right = helper(post, in, ps + cls, pe - 1, k + 1, ie);
		return node;
		
	}
	
	public static void solve() {
		int n = sc.nextInt();
		int post[] = new int[n];
		int in[] = new int[n];
		
		for (int i = 0; i < post.length; i++) post[i] = sc.nextInt();
		for (int i = 0; i < in.length; i++) in[i] = sc.nextInt();
		
		TreeNode root = buildTree(in, post);
		display(root);
	}
	
	public static void main(String args[]) {
		solve();
	}
}
