package Trees;
import java.util.*;

public class VerticalOrderTraversal {
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
    	TreeNode node;
    	int vl;
    	public Pair(TreeNode node, int vl) {
    		this.node = node;
    		this.vl = vl;
    	}
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root) {
    	ArrayDeque<Pair> q = new ArrayDeque<>();
    	q.add(new Pair(root, 0));
    	
    	int min = Integer.MAX_VALUE;
    	int max = Integer.MIN_VALUE;
    	
    	HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    	
    	while (q.size() > 0) {
    		Pair rem = q.remove();
    		min = Math.min(min, rem.vl);
    		max = Math.max(max, rem.vl);
    		
    		if (!map.containsKey(rem.vl)) {
    			ArrayList<Integer> ls = new ArrayList<>();
    			ls.add(rem.node.val);
    			map.put(rem.vl, ls);
    		}
    		
    		else {
    			ArrayList<Integer> ls = map.get(rem.vl);
    			ls.add(rem.node.val);
    			map.put(rem.vl, ls);
    		}
    		
    		if (rem.node.left != null) q.add(new Pair(rem.node.left, rem.vl - 1));
    		if (rem.node.right != null) q.add(new Pair(rem.node.right, rem.vl + 1));
    	}
    	
    	ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    	for (int i = min; i <= max; i++) res.add(map.get(i));
    	
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
