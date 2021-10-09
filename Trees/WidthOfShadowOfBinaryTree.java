package Trees;
import java.util.*;

public class WidthOfShadowOfBinaryTree {
	public static Scanner scn = new Scanner(System.in);
	
	public static class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	
	    TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	public static void width(TreeNode root, int lvl, int[]res) {
		if (root == null) return;
		res[0] = Math.min(res[0], lvl);
		res[1] = Math.max(res[1], lvl);
		
		width(root.left, lvl - 1, res);
		width(root.right, lvl + 1, res);
	}

    public static int width(TreeNode root) {
       int res[] = new int[2];
       width(root, 0, res);
       return res[1] - res[0] + 1;
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

        System.out.println(width(root));
    }

    public static void main(String[] args) {
        solve();
    }
}