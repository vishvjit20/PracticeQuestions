package Graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class KnightsDistance {
    public static class Pair {
        int x, y, distance;
        public Pair(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
    public static int knightsDistance(int sr, int sc, int dr, int dc, int n, int m, boolean[][] visited) {
        int dx[] = {-2, -1, 1, 2, 2, 1, -1, -2};
        int dy[] = {1, 2, 2, 1, -1, -2, -2, -1};
        Queue<Pair> que = new ArrayDeque<>();
        que.add(new Pair(sr, sc, 0));
        while (que.size() > 0) {
            Pair rem = que.remove();
            if (visited[rem.x][rem.y]) continue;
            visited[rem.x][rem.y] = true;
            if (rem.x == dr && rem.y == dc) return rem.distance;
            
            for (int i = 0; i < 8; i ++) {
                if (isItSafeToVisit(rem.x + dx[i], rem.y + dy[i], n, m)) {
                    que.add(new Pair(rem.x + dx[i], rem.y + dy[i], rem.distance + 1));
                }
            }
        }
        return -1;
    }
    public static boolean isItSafeToVisit(int x, int y, int n, int m) {
        if (x < 0 || y < 0 || x >= n || y >= m) return false;
        return true;
    }

    public static void main(String[] args) {
        int distance = knightsDistance(0, 0, 29, 29, 30, 30, new boolean[30][30]);
        System.out.println(distance);
    }
}
