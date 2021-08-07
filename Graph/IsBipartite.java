package Graph;
import java.io.*;
import java.util.*;

public class IsBipartite {
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
		int state;
		public Pair(int data, int state) {
			this.data = data;
			this.state = state;
		}
	}
	
	public static boolean isBipartite(ArrayList<Edge>[] graph, int src, int[] visited) {
		Queue<Pair> que = new ArrayDeque<>();
		que.add(new Pair(src, 1));
		
		while (que.size() > 0) {
			Pair rem = que.remove();
			if (visited[rem.data] != 0) 
			if (rem.state != visited[rem.data]) return false;
			
			visited[rem.data] = rem.state;
			
			for (Edge e : graph[rem.data]) {
				if (visited[e.nbr] == 0) {
					int newState = rem.state == 1 ? 2 : 1;
					que.add(new Pair(e.nbr, newState));
				}
			}
		}
		return true;
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

	    int[] visited = new int[vtces];
	    for (int i = 0; i < vtces; i++) {
	    	if (visited[i] == 0) {
	    		boolean result = isBipartite(graph, i, visited);
	    		if (!result) {
	    			System.out.println("false");
	    			return;
	    		}
	    	}
	    }
	    System.out.println("true");	    
	}
}
