package Trees;
import java.util.*;

public class LongestZigzagPath {
	public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    
    public static class Pair {
    	int backSlope = -1;
    	int forwardSlope = -1;
    	int maxLen = 0;
    }
    
    public static Pair helper (TreeNode root) {
    	if (root == null) return new Pair();
    	
    	Pair left = helper(root.left);
    	Pair right = helper(root.right);
    	
    	Pair myAns = new Pair();
    	myAns.maxLen = Math.max(Math.max(left.maxLen, right.maxLen), Math.max(left.backSlope, right.forwardSlope) + 1);
    	
    	myAns.forwardSlope = left.backSlope + 1;
    	myAns.backSlope = right.forwardSlope + 1;
    	
    	return myAns;
    }

    public static int longestZigZagPath(TreeNode root) {
        Pair res = helper(root);
        return res.maxLen;
    }

    
    public static TreeNode createTree(int[] arr, int[] IDX) {
        if (IDX[0] > arr.length || arr[IDX[0]] == -1){
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

        System.out.println(longestZigZagPath(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
