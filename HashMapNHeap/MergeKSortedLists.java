package HashMapNHeap;
import java.util.*;
import java.io.*;

public class MergeKSortedLists {
	public static class Pair implements Comparable<Pair>{
		int li;
		int di;
		int val;
		public Pair(int li, int di, int val) {
			this.li = li;
			this.di = di;
			this.val = val;
		}
		public int compareTo(Pair o) {
			return this.val - o.val;
		}
	}
	public static ArrayList<Integer> mergeKSorted(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> result = new ArrayList<>();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for (int i = 0; i < lists.size(); i++) {
			Pair pair = new Pair(i, 0, lists.get(i).get(0));
			pq.add(pair);
		}
		
		while (pq.size() > 0) {
			Pair pair = pq.remove();
			result.add(pair.val);
			pair.di++;
			if (pair.di < lists.get(pair.li).size()) {
				pair.val = lists.get(pair.li).get(pair.di);
				pq.add(pair);
			}
		}
		
		return result;
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			int n = Integer.parseInt(br.readLine());
			String elements[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				list.add(Integer.parseInt(elements[j]));
			}
			lists.add(list);
		}
		
		ArrayList<Integer> result = mergeKSorted(lists);
		for (int val : result) {
			System.out.print(val + " ");
		}
		System.out.println();
	}
}
