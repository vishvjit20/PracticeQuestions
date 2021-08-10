package Graph;
import java.io.*;
import java.util.*;

public class MinCostToConnect {
	public static class Edge implements Comparable<Edge> {
		int v, wt;
		public Edge(int v, int wt) {
			this.v = v;
			this.wt = wt;
		}
		public int compareTo(Edge e) {
			return this.wt - e.wt;
		}
	}
	
	
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int vtces = Integer.parseInt(br.readLine());
		int edges = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
		for (int i = 0; i < vtces; i++) graph.add(new ArrayList<>());
		
		for (int i = 0; i < edges; i++) {
			String parts[] = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph.get(v1).add(new Edge(v2, wt));
			graph.get(v2).add(new Edge(v1, wt));
		}
		
		int res = 0;
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		boolean []visited = new boolean[vtces];
		pq.add(new Edge(0, 0));
		
		
		while (pq.size() > 0) {
			Edge rem = pq.remove();
			if (visited[rem.v]) continue;
			visited[rem.v] = true;
			
			res += rem.wt;
			ArrayList<Edge> nbrs = graph.get(rem.v);
			for (Edge nbr : nbrs) {
				if (!visited[nbr.v]) pq.add(nbr);
			}
		}
		
		System.out.println(res);
	}
}