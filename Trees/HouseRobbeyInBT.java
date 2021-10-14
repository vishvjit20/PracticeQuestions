package Trees;
import java.util.*;

public class HouseRobbeyInBT {
	public static Scanner scn = new Scanner(System.in);

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    
    private static int[] helper(TreeNode node) {
    	if (node == null) return new int[2];
    	
    	int[] left = helper(node.left);
    	int[] right = helper(node.right);
    	
    	int[] res = new int[2];
    	res[0] = left[1] + node.val + right[1];
    	res[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    	
    	return res;
    }

    public static int HouseRobber(TreeNode root) {
        int[] res = helper(root);
        return Math.max(res[0], res[1]);
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
        System.out.println(HouseRobber(root));
    }

    public static void main(String[] args) {
        solve();
    }
}
