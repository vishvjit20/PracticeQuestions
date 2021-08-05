package Graph;
import java.util.*;
import java.io.*;

public class GetConnectedComponent {
	public static class Edge {
		int src, nbr, wt;
		public Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	
	public static void getConnectedComponent(ArrayList<Edge>[] graph, ArrayList<Integer> comp, int src, boolean []visited) {
		
		visited[src] = true;
		comp.add(src);
		for (Edge e : graph[src])
			if (!visited[e.nbr]) getConnectedComponent(graph, comp, e.nbr, visited);
	}
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int vtces = Integer.parseInt(br.readLine());
		int edges = Integer.parseInt(br.readLine());
		
		ArrayList<Edge>[] graph = new ArrayList[vtces];
		for (int i = 0; i < vtces; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < edges; i++) {
			String edge[] = br.readLine().split(" ");
			int v1 = Integer.parseInt(edge[0]);
			int v2 = Integer.parseInt(edge[1]);
			int wt = Integer.parseInt(edge[2]);
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}
		
		boolean[] visited = new boolean[vtces];
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		for (int i = 0; i < vtces; i++) {
			if (!visited[i]) {
				ArrayList<Integer> comp = new ArrayList<>();
				getConnectedComponent(graph, comp, i, visited);
				
				result.add(comp);
			}
		}
		System.out.println(result);
	}
}
