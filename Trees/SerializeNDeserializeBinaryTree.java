package Trees;
import java.util.*;

public class SerializeNDeserializeBinaryTree {
	public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int k;
    public static String serialize(TreeNode root) {
    	if (root == null) return "#";
    	String ls = serialize(root.left);
    	String rs = serialize(root.right);
    	return root.val + " " + ls + " " + rs;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String str) {
    	k = 0;
    	String[] chunks = str.split(" ");
    	return helper(chunks);
    }
    
    public static TreeNode helper(String[] strs) {
    	if (strs[k].equals("#")) {
    		k++;
    		return null;
    	}
    	else {
    		int data = Integer.parseInt(strs[k]);
    		k++;
    		
    		TreeNode node = new TreeNode(data);
    		node.left = helper(strs);
    		node.right = helper(strs);
    		
    		return node;
    	}
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

    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1) {
            IDX[0]++;
            return null;
        }
        TreeNode node = new TreeNode(arr[IDX[0]++]);
        node.left = createTree(arr, IDX);
        node.right = createTree(arr, IDX);

        return node;
    }

    public static void solve() {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int[] IDX = new int[1];
        TreeNode root = createTree(arr, IDX);

        String s = serialize(root);
        display(deserialize(s));
    }

    public static void main(String[] args) {
        solve();
    }
}
