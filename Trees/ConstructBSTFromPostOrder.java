package Trees;

import java.util.Scanner;

public class ConstructBSTFromPostOrder {
    public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int idx;
    public static TreeNode bstFromPostorder(int[] postorder) {
    	idx = postorder.length - 1;
    	int left = Integer.MIN_VALUE;
    	int right = Integer.MAX_VALUE;
    	return helper(postorder, left, right);
    }
    public static TreeNode helper(int[]post, int left, int right) {
    	if (idx < 0 || post[idx] < left || post[idx] > right) return null;
    	
    	TreeNode node = new TreeNode(post[idx--]);
    	node.right = helper(post, node.val, right);
    	node.left = helper(post, left, node.val);
    	return node;
    }

    public static void display(TreeNode node) {
        if (node == null)
            return;

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
        int[] pre = new int[n];
        for (int i = 0; i < n; i++)
            pre[i] = scn.nextInt();

        TreeNode root = bstFromPostorder(pre);
        display(root);
    }

    public static void main(String[] args) {
        solve();
    }
}