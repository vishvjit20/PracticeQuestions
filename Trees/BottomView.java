package Trees;
import java.util.*;

import Trees.TopViewOfABinaryTree.Pair;
import Trees.TopViewOfABinaryTree.TreeNode;

public class BottomView {
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
    	TreeNode node = null;
    	int vl = 0;
    	public Pair (TreeNode node, int vl) {
    		this.node = node;
    		this.vl = vl;
    	}
    }
    
    public static void width(TreeNode node, int vl, int[] minMax) {
    	if (node == null) return;
    	
    	minMax[0] = Math.min(minMax[0], vl);
    	minMax[1] = Math.max(minMax[1], vl);
    	
    	width(node.left, vl - 1, minMax);
    	width(node.right, vl + 1, minMax);
    }

    public static ArrayList<Integer> BottomView(TreeNode root) {
    	ArrayList<Integer> res = new ArrayList<>();
    	int []minMax = new int[2];
    	width(root, 0, minMax);
    	int len = minMax[1] - minMax[0] + 1;
    	for (int i = 0; i < len; i++) res.add(null);
    	ArrayDeque<Pair> q = new ArrayDeque<>();
    	q.add(new Pair(root, -minMax[0]));
    	while (q.size() > 0) {
    		int size = q.size();
    		while (size-- > 0) {
    			Pair rem = q.remove();
    			TreeNode node = rem.node;
    			int vl = rem.vl;
    			res.set(vl, node.val);
    			
    			if (node.left != null) q.add(new Pair(node.left, vl - 1));
    			if (node.right != null) q.add(new Pair(node.right, vl + 1));
    		}
    	}
    	return res;
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

        ArrayList<Integer> ans = BottomView(root);
        for (Integer i : ans)
            System.out.print(i + " ");

    }

    public static void main(String[] args) {
        solve();
    }
}
