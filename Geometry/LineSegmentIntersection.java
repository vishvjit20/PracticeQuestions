package Geometry;

public class LineSegmentIntersection {
	public static class Point {
		int x, y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int orientation(Point p1, Point p2, Point p3) {
		int val = (p2.y - p1.y) * (p3.x - p2.x) - (p3.y - p2.y) * (p2.x - p1.x);
		if (val == 0) return 0;
		return val > 0 ? 1 : 2;
	}   
	
	public static void swap(int a, int b) {
		int temp = a;
		a = b;
		b = temp;
	}
	
	public static boolean validProjection(int a, int b, int c, int d) {
		if (a > b) swap(a, b);
		if (c > d) swap(c, d);
		return Math.max(a, c) <= Math.min(b, d);
	}
	
	public static boolean doIntersect(Point a, Point b, Point c, Point d) {
		int o1 = orientation(a, b, c);
		int o2 = orientation(a, b, d);
		int o3 = orientation(c, d, a);
		int o4 = orientation(c, d, b);
		
		if (o1 != o2 && o3 != o4) return true;
		
		if (o1 == 0 && o4 == 0) {
			if (validProjection(a.x, b.x, c.x, d.x) && validProjection(a.y, b.y, c.y, d.y)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String args[]) {
		Point p1 = new Point(10, 0);
		Point p2 = new Point(0, 10);
		Point p3 = new Point(0, 0);
		Point p4 = new Point(10, 10);
		System.out.println(doIntersect(p1, p2, p3, p4));
	}
}
