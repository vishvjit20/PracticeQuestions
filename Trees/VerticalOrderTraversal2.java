package Trees;
import java.util.*;

public class VerticalOrderTraversal2 {
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
    	int hl = 0;
    	public Pair (TreeNode node, int hl) {
    		this.node = node;
    		this.hl = hl;
    	}
    }
    
    public static void width(TreeNode node, int hl, int[]minMax) {
    	if (node == null) return;
    	minMax[0] = Math.min(minMax[0], hl);
    	minMax[1] = Math.max(minMax[1], hl);
    	
    	width(node.left, hl - 1, minMax);
    	width(node.right, hl + 1, minMax);
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
    	PriorityQueue<Pair> pQ = new PriorityQueue<>((a, b) -> a.node.val - b.node.val);
    	PriorityQueue<Pair> cQ = new PriorityQueue<>((a, b) -> a.node.val - b.node.val);
    	
    	int[] minMax = new int[2];
    	width(root, 0, minMax);
    	
    	int w = minMax[1] - minMax[0] + 1;
    	
    	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    	for (int i = 0; i < w; i++) {
    		res.add(new ArrayList<>());
    	}
    	
    	pQ.add(new Pair(root, Math.abs(minMax[0])));
    	
    	while (pQ.size() > 0) {
    		int size = pQ.size();
    		while (size-- > 0) {
    			Pair rem = pQ.remove();
    			TreeNode node = rem.node;
    			int hl = rem.hl;
    			
    			res.get(hl).add(node.val);
    			if (node.left != null) cQ.add(new Pair(node.left, rem.hl - 1));
    			if (node.right != null) cQ.add(new Pair(node.right, rem.hl + 1));
    		}
    		PriorityQueue<Pair> temp = pQ;
    		pQ = cQ;
    		cQ = temp;
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

        ArrayList<ArrayList<Integer>> ans = verticalOrderTraversal(root);
        int idx = 0;
        for (ArrayList<Integer> i : ans) {
            System.out.print(idx++ + " -> ");
            for (Integer j : i)
                System.out.print(j + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        solve();
    }
}