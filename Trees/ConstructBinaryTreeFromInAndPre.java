package Trees;
import java.util.*;

public class ConstructBinaryTreeFromInAndPre {
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
	
	public static TreeNode buildTree(int pre[], int in[]) {
		int n = pre.length;
		return helper(pre, in, 0, n - 1, 0, n - 1);
	}
	
	public static TreeNode helper(int []pre, int []in, int ps, int pe, int is, int ie) {
		if (ps > pe) return null;
		TreeNode root = new TreeNode(pre[ps]);
		int k = -1;
		for (int i = is; i <= ie; i++) {
			if (in[i] == root.val) {
				k = i;
				break;
			}
		}
		int cls = k - is;
		root.left = helper(pre, in, ps + 1, ps + cls, is, k - 1);
		root.right = helper(pre, in, ps + cls + 1, pe, k + 1, ie);
		return root;
	}
	
	public static void solve() {
		int n = sc.nextInt();
		int pre[] = new int[n];
		int in[] = new int[n];
		
		for (int i = 0; i < pre.length; i++) pre[i] = sc.nextInt();
		for (int i = 0; i < in.length; i++) in[i] = sc.nextInt();
		
		TreeNode root = buildTree(pre, in);
		display(root);
	}
	
	public static void main(String args[]) {
		solve();
	}
}



