package Graph2;
import java.util.*;

public class BusRoutes {
	public static class Pair {
		int bus_stop;
		int level;
		public Pair(int bus_stop, int level) {
			this.bus_stop = bus_stop;
			this.level = level;
		}
	}
	public static int numBusesToDestination(int[][] routes, int source, int target) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
        	for (int j = 0; j < routes[i].length; j++) {
        		int bus_no = i;
        		int bus_stop_no = routes[i][j];
        		if (!map.containsKey(bus_stop_no)) {
        			ArrayList<Integer> list = new ArrayList<>();
        			list.add(bus_no);
        			map.put(bus_stop_no, list);
        		}
        		else {
        			ArrayList<Integer> list = map.get(bus_stop_no);
        			list.add(bus_no);
        			map.put(bus_stop_no, list);
        		}
        	}
        }
        
        return bfs(routes, source, target, map);
    }
	public static int bfs(int[][] routes, int src, int dest, Map<Integer, ArrayList<Integer>> map) {
		Set<Integer> bus_stop_vis = new HashSet<>();
		Set<Integer> bus_vis = new HashSet<>();
		
 		ArrayDeque<Pair> q = new ArrayDeque<>();
		q.add(new Pair(src, 0));
		bus_stop_vis.add(src);
		
		while (q.size() > 0) {
			Pair rem = q.remove();
			
			if (rem.bus_stop == dest) {
				return rem.level;
			}
			
			ArrayList<Integer> buses = map.get(rem.bus_stop);
			for (int bus : buses) {
				if (!bus_vis.contains(bus)) {
					bus_vis.add(bus);
					for (int bus_stop : routes[bus]) {
						if (!bus_stop_vis.contains(bus_stop)) {
							q.add(new Pair(bus_stop, rem.level + 1));
							bus_stop_vis.add(bus_stop);
						}
					}
				}
			}
		}
		return -1;
	}
}
