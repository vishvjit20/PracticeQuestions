package Graph;

import java.util.*;

public class GraphCreation {
	public static class Edge {
		int src, nbr, wt;
		public Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	
	public static void addEdge(ArrayList<Edge> []graph, int u, int v, int wt) {
		Edge e1 = new Edge(u, v, wt);
		Edge e2 = new Edge(v, u, wt);
		
		graph[u].add(e1);
		graph[v].add(e2);
	}
	
	public static void display(ArrayList<Edge>[] graph) {
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + " -> ");
			for (Edge ne : graph[i]) {
				int src = i;
				int nbr = ne.nbr;
				int wt = ne.wt;
				
				System.out.print(src + " - "+ nbr + " @ " + wt + ", ");
			}
			System.out.println();
		}
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		
		ArrayList<Edge> []graph = new ArrayList[v];
		for (int i = 0; i < graph.length; i++) {
			graph[i] = new ArrayList<>();
		}
 		
		while (e-- > 0) {
			int src = sc.nextInt();
			int nbr = sc.nextInt();
			int wt = sc.nextInt();
			
			addEdge(graph, src, nbr, wt);
		}
		
		display(graph);
		
		sc.close();
	}
}
