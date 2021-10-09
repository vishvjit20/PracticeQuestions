package Trees;
import java.util.*;

public class ConstructBSTFromPreOrder {
	public static Scanner scn = new Scanner(System.in);
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int idx = 0;
    public static TreeNode constructFromPreOrder(int[] preOrder) {
        int n = preOrder.length;
        if (n < 1) return null;
        int left = Integer.MIN_VALUE;
        int right = Integer.MAX_VALUE;
        
        return constructBST(preOrder, left, right);
    }
    
    public static TreeNode constructBST(int[] pre, int min, int max) {
    	if (idx >= pre.length || pre[idx] < min || pre[idx] > max) return null;
    	TreeNode node = new TreeNode(pre[idx++]);
    	node.left = constructBST(pre, min, node.val - 1);
    	node.right = constructBST(pre, node.val + 1, max);
    	return node;
    }

    public static void display(TreeNode node) {
        if (node == null) return;
        StringBuilder sb = new StringBuilder();
        sb.append((node.left != null ? node.left.val : "."));
        sb.append(" -> " + node.val + " <- ");
        sb.append((node.right != null ? node.right.val : "."));

        System.out.println(sb.toString());
        display(node.left);
        display(node.right);

    }

    public static void solve() {
        int n = scn.nextInt();
        int[] in = new int[n];
        for (int i = 0; i < n; i++)
            in[i] = scn.nextInt();

        TreeNode root = constructFromPreOrder(in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
