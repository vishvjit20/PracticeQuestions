package Graph;
import java.util.*;
import java.io.*;

public class Multisolver {
	public static class Edge {
		int src, nbr, wt;
		public Edge(int src, int nbr, int wt) {
			this.src = src;
			this.nbr = nbr;
			this.wt = wt;
		}
	}
	
	public static class Pair implements Comparable<Pair> {
		int wsf;
	    String psf;

	    Pair(int wsf, String psf){
	       this.wsf = wsf;
	       this.psf = psf;
	    }

	    public int compareTo(Pair o){
	       return this.wsf - o.wsf;
	    }
	}
	
	public static String spath;
	public static Integer spathwt = Integer.MAX_VALUE;
	public static String lpath;
	public static Integer lpathwt = Integer.MIN_VALUE;
	public static String cpath;
	public static Integer cpathwt = Integer.MAX_VALUE;
	public static String fpath;
	public static Integer fpathwt = Integer.MIN_VALUE;
	public static PriorityQueue<Pair> pq = new PriorityQueue<>();
	   
	public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
		if (src == dest) {
			
			if (spathwt > wsf) {
				spath = psf;
				spathwt = wsf;
			}
			
			if (lpathwt < wsf) {
				lpath = psf;
				lpathwt = wsf;
			}
			
			// ceil path
			if (wsf > criteria && wsf < cpathwt) {
				cpath = psf;
				cpathwt = wsf;
			}
			
			// floor path 
			if (wsf < criteria && wsf > fpathwt) {
				fpath = psf;
				fpathwt = wsf;
			}
			
			Pair p = new Pair(wsf, psf);
			if (pq.size() < k) {
				pq.add(p);
			}
			else if (pq.peek().wsf < wsf) {
				pq.remove();
				pq.add(p);
			}
		}
		visited[src] = true;
		for (Edge e : graph[src]) {
			int nbr = e.nbr;
			if (!visited[nbr]) {
				multisolver(graph, nbr, dest, visited, criteria, k, psf + nbr, wsf + e.wt);
				visited[nbr] = false;
			}
		}
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
	         int wt = Integer.parseInt(parts[2]);
	         graph[v1].add(new Edge(v1, v2, wt));
	         graph[v2].add(new Edge(v2, v1, wt));
	      }

	      int src = Integer.parseInt(br.readLine());
	      int dest = Integer.parseInt(br.readLine());

	      int criteria = Integer.parseInt(br.readLine());
	      int k = Integer.parseInt(br.readLine());

	      boolean[] visited = new boolean[vtces];
	      multisolver(graph, src, dest, visited, criteria, k, src + "", 0);
	      
	      System.out.println("Smallest Path = " + spath + "@" + spathwt);
	      System.out.println("Largest Path = " + lpath + "@" + lpathwt);
	      System.out.println("Just Larger Path than " + criteria + " = " + cpath + "@" + cpathwt);
	      System.out.println("Just Smaller Path than " + criteria + " = " + fpath + "@" + fpathwt);
	      System.out.println(k + "th largest path = " + pq.peek().psf + "@" + pq.peek().wsf);
	   }
}




// TC
// 7
// 9
// 0 1 10
// 1 2 10
// 2 3 10
// 0 3 40
// 3 4 2
// 4 5 3
// 5 6 3
// 4 6 8
// 2 5 5
// 0
// 6
// 30
// 4







