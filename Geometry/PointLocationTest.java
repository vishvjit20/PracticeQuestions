package Geometry;
import java.util.*;

public class PointLocationTest {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int x1, y1, x2, y2, x3, y3;
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			x3 = sc.nextInt();
			y3 = sc.nextInt();
			
			int val = (x3 - x2)*(y2 - y1) - (x2 - x1)*(y3 - y2);
			if (val < 0) System.out.println("LEFT");
			else if (val > 0) System.out.println("RIGHT");
			else System.out.println("TOUCH");
		}
		
		sc.close();
	}
}
