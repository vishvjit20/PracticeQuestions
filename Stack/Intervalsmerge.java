package Stack;
import java.io.*;
import java.util.*;

public class Intervalsmerge {
	/*
	 * Input format
	 * 1  -  8
	 * 5  - 12 
	 * 14 - 19
	 * 22 - 28
	 * 25 - 27
	 * 27 - 30
	 * 
	 * Output format
	 * 1  - 12
	 * 14 - 19
	 * 22 - 30
	 * */
	
	 public static class Pair implements Comparable <Pair> {
	        int start, end;
	        public Pair (int start, int end) {
	            this.start = start;
	            this.end = end;
	        }
	        public int compareTo(Pair o) {
	            if (this.start != o.start) {
	                return this.start - o.start;
	            }
	            return this.end - o.end;
	        }
	    }
	
	public static void mergeOverlappingInterval(int[][] intervals) {
		Pair []pairs = new Pair[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            pairs[i] = new Pair(intervals[i][0], intervals[i][1]);
        }
        Arrays.sort(pairs);
        LinkedList<Pair> que = new LinkedList<Pair>();
        
        for (int i = 0; i < intervals.length; i++) {
            if (i == 0)	que.add(pairs[i]);
            else {
                Pair p = ((LinkedList<Pair>) que).getLast();
                if (p.end < pairs[i].start) que.add(pairs[i]);
                else {
                    p.end = Math.max(p.end, pairs[i].end);
                }
            }
        }
		while (!que.isEmpty()) {
			Pair val = que.remove();
			System.out.println(val.start + " " + val.end);
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int j = 0; j < n; j++) {
            String line = br.readLine();
            arr[j][0] = Integer.parseInt(line.split(" ")[0]);
            arr[j][1] = Integer.parseInt(line.split(" ")[1]);
        }
		mergeOverlappingInterval(arr);
	}
}
