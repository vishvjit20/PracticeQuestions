package Geometry;

import java.util.*;

public class PolygonAreaCSES {
	public static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Pair> points = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int x, y;
			x = sc.nextInt();
			y = sc.nextInt();
			points.add(new Pair(x, y));
		}
		
		long ans = 0;
		for (int i = 0; i < n; i++) {
			int x1 = points.get(i).x;
			int y1 = points.get(i).y;
			int x2 = points.get((i + 1) % n).x;
			int y2 = points.get((i + 1) % n).y;	
			ans += ( (x1 * y2) - (x2 * y1) );
		}
		System.out.println(Math.abs(ans));
		sc.close();
	}
}

//4
//1 1
//4 2
//3 5
//1 4

