package RecursionNBacktracking;

import java.util.*;

public class KPartitions {
	public static void solution(int ci, int n, int k, int count, ArrayList<ArrayList<Integer>> res) {
		
		if (ci > n) {
			if (count == k) {
				for (int i = 0; i < k; i++) {
					System.out.println(res.get(i) + " ");
				}
			}
			return;
		}
		
		for (int i = 0; i < k; i++) {
			// participate in non empty subsets
			if (res.get(i).size() > 0) {
				res.get(i).add(ci);
				solution(ci + 1, n, k, count, res);
				int size = res.get(i).size();
				res.get(i).remove(size - 1);
			}
			// create first empty subset
			else {
				res.get(i).add(ci);
				solution(ci + 1, n, k, count + 1, res);
				int size = res.get(i).size();
				res.get(i).remove(size - 1);
				break;
			}
			
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			res.add(new ArrayList<>());
		}
		solution(1, n, k, 0, res);
		
		sc.close();
	}
}
