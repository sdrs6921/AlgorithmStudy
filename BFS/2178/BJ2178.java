import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BJ2178 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int n, m;
		int[][] map;
		int[][] dist;
		int answer = 0;
		class Point {
			int x;
			int y;
			
			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
		}
		Queue<Point> q = new LinkedList<>();
		final int[] dx = {1, 0, -1, 0};
		final int[] dy = {0, 1, 0, -1};
		
		
		n = scanner.nextInt();
		m = scanner.nextInt();
		map = new int[n][m];
		dist = new int[n][m];
		
		for (int i = 0; i < n; i++) {
			String s = scanner.next();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j) - '0';
				dist[i][j] = -1;
			}
		}
		
		q.add(new Point(0, 0));
		dist[0][0] = 1;
		
		while (!q.isEmpty()) {
			int count = 0;
			Point cur_p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int x_idx = cur_p.x + dx[i];
				int y_idx = cur_p.y + dy[i];
				
				if (x_idx < 0 || x_idx >= n || y_idx< 0 || y_idx >= m) {
					continue;
				} else if (map[x_idx][y_idx] == 1 && dist[x_idx][y_idx] < 0) {
					q.add(new Point(x_idx, y_idx));
					dist[x_idx][y_idx] = dist[cur_p.x][cur_p.y] + 1;
					count++;
				}
			}
			
		}
				
		System.out.println(dist[n-1][m-1]);
	}
}