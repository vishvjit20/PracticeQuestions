package Geometry;
import java.util.*;

public class PointInPolygonCSES {
	public static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int orientation(Pair a, Pair b, Pair c) {
		int val = (b.y - a.y) * (c.x - b.x) - (c.y - b.y) * (b.x - a.x);
		if (val == 0) return 0;
		return val > 0 ? 1 : 2;
	}    
	
	
	public static boolean onSegment(Pair a, Pair b, Pair c) {
		return c.x <= Math.max(a.x, b.x) && c.x >= Math.min(a.x, b.x) && c.y <= Math.max(a.y, b.y) && c.y >= Math.min(a.y, b.y);
	}
	
	public static boolean intersection(Pair a, Pair b, Pair c, Pair d) {
		int o1 = orientation(a, b, c);
		int o2 = orientation(a, b, d);
		int o3 = orientation(c, d, a);
		int o4 = orientation(c, d, b);
		
		if (o1 != o2 && o3 != o4) return true;
		return false;
	}


	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		ArrayList<Pair> vtcs = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			vtcs.add(new Pair(x, y));
		}
		
		ArrayList<Pair> points = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			points.add(new Pair(x, y));
		}
		
		for (Pair cp : points) {
			Pair endP = new Pair(Integer.MAX_VALUE - 1, Integer.MAX_VALUE);
			int intersectionCount = 0;
			boolean boundary = false;
			for (int i = 0; i < n; i++) {
				Pair a = vtcs.get(i);
				Pair b = vtcs.get((i + 1) % n);
				if (orientation(a, b, cp) == 0 && onSegment(a, b, cp)) {
					boundary = true;
					break;
				}
				if (intersection(a, b, cp, endP)) intersectionCount++;
			}
			if (boundary) System.out.println("BOUNDARY");
			else if (intersectionCount % 2 == 1) System.out.println("INSIDE");
			else System.out.println("OUTSIDE");
		}
		
		sc.close();
	}
}
