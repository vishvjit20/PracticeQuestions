package LeetcodeHard;

public class MaximumPointsInALine {
	public static int maxPoints(int[][] points) {
		int n = points.length;
		if (n <= 2) return n;
		int maxPts = 2;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				int count = 2;
				for (int k = 0; k < n; k++) {
					if (k != i && k != j) {
						if ((points[j][1] - points[i][1]) * (points[k][0] - points[i][0]) == (points[k][1] - points[i][1]) * (points[j][0] - points[i][0])) count++;
					}
				}
				maxPts = Math.max(maxPts, count);
			}
		}
		return maxPts;
	}
	public static void main(String args[]) {
		int[][] points = {	
							{1,1}, 
							{3,2}, 
							{5,3}, 
							{4,1}, 
							{2,3}, 
							{1,4}
						 };
		System.out.println(maxPoints(points));
	}
}
