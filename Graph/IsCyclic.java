package Graph;
import java.io.*;
import java.util.*;

public class IsCyclic {
	static class Edge {
		int src;
	    int nbr;

	    Edge(int src, int nbr) {
	    	this.src = src;
	        this.nbr = nbr;
        }
	}
	
	
	public static boolean visitGraph(ArrayList<Edge>[] graph, int src) {
		boolean visited[] = new boolean[graph.length];
		Queue<Integer> que = new ArrayDeque<>();
		que.add(src);
		
		while (que.size() > 0) {
			int val = que.remove();
			if (visited[val]) return true;
			visited[val] = true;
			
			for (Edge e : graph[val]) {
				if (!visited[e.nbr]) que.add(e.nbr);
			}
		}
		
		return false;
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

	    boolean []visited = new boolean[vtces];
	    for (int i = 0; i < vtces; i++) {
	    	if (!visited[i]) {
	    		boolean result = visitGraph(graph, i);
	    		if (result) {
	    			System.out.println("true");
	    			return;
	    		}
	    	}
	    }
	    System.out.println("false");
	}
}
