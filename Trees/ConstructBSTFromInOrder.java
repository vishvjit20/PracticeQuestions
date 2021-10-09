package Trees;
import java.util.*;

public class ConstructBSTFromInOrder {
	public static Scanner scn = new Scanner(System.in);
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructFromInOrder(int[] inOrder) {
        if (inOrder.length < 1) return null;
        int n = inOrder.length;
        return helper(inOrder, 0, n - 1);
    }
    
    public static TreeNode helper(int[] in, int l, int r) {
    	if (l > r) return null;
    	int mid = (l + r) / 2;
    	TreeNode node = new TreeNode(in[mid]);
    	node.left = helper(in, l, mid - 1);
    	node.right = helper(in, mid + 1, r);
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

        TreeNode root = constructFromInOrder(in);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}
