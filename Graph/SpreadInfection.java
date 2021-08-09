package Graph;
import java.io.*;
import java.util.*;

public class SpreadInfection {
	static class Edge {
	      int src;
	      int nbr;

	      Edge(int src, int nbr) {
	         this.src = src;
	         this.nbr = nbr;
	      }
	}
	
	public static class Pair {
		int data;
		int level;
		public Pair(int data, int level) {
			this.data = data;
			this.level = level;
		}
	}
	
	public static int spreadInfection(ArrayList<Edge> []graph, int src, int t, boolean []visited) {
		Queue<Pair> que = new ArrayDeque<>();
		que.add(new Pair(src, 1));
		int count = 0;
		while (que.size() > 0) {
			Pair rem = que.remove();
			if (visited[rem.data]) continue;
			visited[rem.data] = true;
			if (rem.level > t) break;
			count++;
			for (Edge e : graph[rem.data]) {
				if (!visited[e.nbr]) {
					que.add(new Pair(e.nbr, rem.level + 1));
				}
			}
		}
		
		return count;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int vtces = Integer.parseInt(br.readLine());
	    ArrayList<Edge>[] graph = new ArrayList[vtces];
	    for (int i = 0; i < vtces; i++) {
	    	graph[i] = new ArrayList<>();
	    }

	    int edges = Integer.parseInt(br.readLine());
	    for (int i = 0; i < edges; i++) {
	    	String[] parts = br.readLine().split(" ");
	        int v1 = Integer.parseInt(parts[0]);
	        int v2 = Integer.parseInt(parts[1]);
	        graph[v1].add(new Edge(v1, v2));
	        graph[v2].add(new Edge(v2, v1));
	    }

	    int src = Integer.parseInt(br.readLine());
	    int t = Integer.parseInt(br.readLine());
	    
	    boolean[] visited = new boolean[vtces];
	    int res = spreadInfection(graph, src, t, visited);
	    System.out.println(res);
	}
}
