package Graph;
import java.util.*;
import java.io.*;

public class Main {
	public static class Edge {
		int src, nbr, wt;
		public Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	
	public static void display(ArrayList<Edge>[] graph) {
		for (int i = 0; i < graph.length; i++) {
			System.out.print(i + " -> ");
			for (Edge e : graph[i]) {
				int src = i;
				int nbr = e.nbr;
				int wt = e.wt;
				System.out.print(src + "-" + nbr + ", ");
			}
			System.out.println();
		}
	}
	
	public static void printPaths(ArrayList<Edge> []graph, int src, int dest, boolean[] visited, String psf) {
		if (src == dest) {
			System.out.println(psf);
			return;
		}
		visited[src] = true;
		for (Edge e : graph[src]) {
			if (!visited[e.nbr]) {
				printPaths(graph, e.nbr, dest, visited, psf + " " +e.nbr);
			}
		}
		visited[src] = false;
	}
	
	public static boolean hasPath(ArrayList<Edge> []graph, int src, int dest, boolean[] visited) {
		if (src == dest) {
			return true;
		}
		visited[src] = true;
		for (Edge e : graph[src]) {
			if (!visited[e.nbr]) {
				boolean path = hasPath(graph, e.nbr, dest, visited);
				if (path) return true;
			}
		}
		return false;
	}
	
	public static void getConnectedComponents(ArrayList<Edge>[] graph, int src, ArrayList<Integer> comp, boolean[] visited) {
		visited[src] = true;
		comp.add(src);
		
		for (Edge e : graph[src]) {
			if (!visited[e.nbr]) {
				getConnectedComponents(graph, e.nbr, comp, visited);
			}
		}
	}
	
	public static void noOfIslands(int i, int j, int grid[][]) {
		if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 1) return;
		
		grid[i][j] = 1;
		noOfIslands(i + 1, j, grid);
		noOfIslands(i - 1, j, grid);
		noOfIslands(i, j + 1, grid);
		noOfIslands(i, j - 1, grid);
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int vtces = Integer.parseInt(br.readLine());
		int edges = Integer.parseInt(br.readLine());
		
		ArrayList<Edge> []graph = new ArrayList[vtces];
		
		for (int i = 0; i < vtces; i++) graph[i] = new ArrayList<>();

		for (int i = 0; i < edges; i++) {
			String[] parts = br.readLine().split(" ");
			int v1 = Integer.parseInt(parts[0]);
			int v2 = Integer.parseInt(parts[1]);
			int wt = Integer.parseInt(parts[2]);
			graph[v1].add(new Edge(v1, v2, wt));
			graph[v2].add(new Edge(v2, v1, wt));
		}
//		int src = Integer.parseInt(br.readLine());
//		int dest = Integer.parseInt(br.readLine());
		
		boolean []visited = new boolean[vtces];
//		printPaths(graph, src, dest, visited, src+"");
//		System.out.println(hasPath(graph, src, dest, visited));
		
		ArrayList<ArrayList<Integer>> comps = new ArrayList<>();
		for (int i = 0 ; i < vtces; i++) {
			if(!visited[i]) { 
				ArrayList<Integer> comp = new ArrayList<>();
				getConnectedComponents(graph, i, comp, visited);
				comps.add(comp);
			}
		}
		System.out.println(comps);
	}
	
//	public static void main(String args[]) {
//		int arr[][] = {
//							{0, 0, 1, 1, 1, 1, 1, 1},
//							{0, 0, 1, 1, 1, 1, 1, 1},
//							{1, 1, 1, 1, 1, 1, 1, 0},
//							{1, 1, 0, 0, 0, 1, 1, 0},
//							{1, 1, 1, 1, 0, 1, 1, 0},
//							{1, 1, 1, 1, 0, 1, 1, 0},
//							{1, 1, 1, 1, 1, 1, 1, 0},
//							{1, 1, 1, 1, 1, 1, 1, 0},
//					  };
//		int count = 0;
//		for (int i = 0; i < arr.length; i++) 
//			for (int j = 0; j < arr[0].length; j++) 
//				if (arr[i][j] != 1) {
//					noOfIslands(i, j, arr);
//					count++;
//				}
//		System.out.println(count);
//	}
}
