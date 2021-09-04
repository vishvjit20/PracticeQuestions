package DesignQuestions;

import java.util.*;

public class PriorityQueueDesign {
	public static class PriorityQueue {
		ArrayList<Integer> data;
		boolean min_pq;
		
		public PriorityQueue(boolean type) {
			data = new ArrayList<>();
			min_pq = type;
		}
		
		private int priority(int v1, int v2) {
			if (min_pq == true) return v2 - v1;
			return v1 - v2;
		}
		
		public void add(int val) {
			data.add(val);
			upheapify(data.size() - 1);
		}
		
		public void upheapify(int ci) {
			if (ci == 0) return;
			else {
				int pi = (ci - 1) / 2;
				if (priority(data.get(ci), data.get(pi)) > 0) {
					swap(pi, ci);
					upheapify(pi);
				}
			}
		}
		
		public void swap(int i, int j) {
			int i_val = data.get(i);
			int j_val = data.get(j);
			
			data.set(i, j_val);
			data.set(j, i_val);
		}
		
		public int remove() {
			if (data.size() == 0) {
				System.out.println("Queue is empty");
				return -1;
			}
			else {
				int li = data.size() - 1;
				swap(0, li);
				int val = data.remove(li);
				downheapify(0);
				return val;
			}
		}
		
		public void downheapify(int pi) {
			int min = pi;
			int lci = 2 * pi + 1;
			int rci = 2 * pi + 2;
			if (lci < data.size() && priority(data.get(lci), data.get(min)) > 0) min = lci;
			if (rci < data.size() && priority(data.get(rci), data.get(min)) > 0) min = rci;
			if (pi != min) {
				swap(pi, min);
				downheapify(min);
			}
		}
		
		public int size() {
			return data.size();
		}
	}
	
	public static void main(String args[]) {
		PriorityQueue pq = new PriorityQueue(false);
		pq.add(17);
		pq.add(9);
		pq.add(53);
		pq.add(44);
		pq.add(27);
		pq.add(5);
		pq.add(19);
		pq.add(99);
		pq.add(84);
		
		while (pq.size() > 0) System.out.println(pq.remove());
	}
}