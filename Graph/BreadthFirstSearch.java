package Graph;
import java.io.*;
import java.util.*;

public class BreadthFirstSearch {
	static class Edge {
		int src;
	    int nbr;
	    Edge(int src, int nbr) {
	    	this.src = src;
	        this.nbr = nbr;
	    }
	}

	public static class Pair {
		int vtx;
		String psf;
		public Pair(int vtx, String psf) {
			this.vtx = vtx; 
			this.psf = psf;
		}
	}
	
	// BFS traversal
	public static void bfs(ArrayList<Edge>[] graph, int src) {
		boolean visited[] = new boolean[graph.length];
		Queue<Pair> que = new ArrayDeque<>();
		que.add(new Pair(src, src + ""));
		
		while (!que.isEmpty()) {
			Pair rem = que.remove();
			if (visited[rem.vtx]) continue;
			visited[rem.vtx] = true;
			
			System.out.println(rem.vtx + " @ " + rem.psf);
			for (Edge e : graph[rem.vtx])
			if (!visited[e.nbr]) que.add(new Pair(e.nbr, rem.psf + e.nbr));
		}
		System.out.println();
	}
	
	// Linewise bfs traversal
	public static void bfs2 (ArrayList<Edge>[] graph, int src) {
		boolean visited[] = new boolean[graph.length];
		Queue<Pair> que = new ArrayDeque<>();
		que.add(new Pair(src, src + ""));
		
		int level = 0;
		while (!que.isEmpty()) {
			int count = que.size();
			System.out.print(level + " -> ");
			while (count-- > 0) {
				Pair rem = que.remove();
				if (visited[rem.vtx]) continue;
				visited[rem.vtx] = true;
				System.out.print(rem.vtx + ", ");
				for (Edge e : graph[rem.vtx])
				if (!visited[e.nbr]) que.add(new Pair(e.nbr, rem.psf + e.nbr));
			}
			System.out.println();
			level++;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    int vtces = Integer.parseInt(br.readLine());
	    ArrayList<Edge>[] graph = new ArrayList[vtces];
	    
	    for (int i = 0; i < vtces; i++) graph[i] = new ArrayList<>();

	    int edges = Integer.parseInt(br.readLine());
	    for (int i = 0; i < edges; i++) {
	    	String[] parts = br.readLine().split(" ");
	        int v1 = Integer.parseInt(parts[0]);
	        int v2 = Integer.parseInt(parts[1]);
	        graph[v1].add(new Edge(v1, v2));
	        graph[v2].add(new Edge(v2, v1));
        }
	    
	    int src = Integer.parseInt(br.readLine());
	    bfs(graph, src);
	}
}
