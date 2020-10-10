import java.util.Scanner;
import java.util.*;

public class BJ1926 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		class Point {
			int x;
			int y;
			
			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}
			
		}
		Scanner scanner = new Scanner(System.in);
		int n, m;
		int[][] map;
		boolean[][] visited;
		int max = 0, picture_count = 0;
		final int[] dx = {1,0,-1,0};
		final int[] dy = {0,1,0,-1};
		
		n=scanner.nextInt();
		m = scanner.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m];
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = scanner.nextInt();
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					int width = 0;
					picture_count++;
					Queue<Point> q = new LinkedList<>();
					q.add(new Point(i, j));
					visited[i][j] = true;
					
					while (!q.isEmpty()) {
						width++;
						Point cur_point = q.poll();
						
						for (int k = 0; k < dx.length; k++) {
							int x_index = cur_point.x + dx[k];
							int y_index = cur_point.y + dy[k];
							
							if (x_index < 0 || x_index >= n || y_index >= m || y_index < 0) {
								continue;
							} else if (!visited[x_index][y_index] && map[x_index][y_index] == 1) {
								q.add(new Point(x_index, y_index));
								visited[x_index][y_index] = true;
							}
						}
					}
					
					max = Math.max(max, width);
				}
			}
		}
		System.out.println(picture_count);
		System.out.println(max);
	}
}