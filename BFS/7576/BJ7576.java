import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BJ7576 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		class Point {
			int x;
			int y;
			
			public Point(int x, int y) {
				this.x = x;
				this.y = y;
			}

			@Override
			public String toString() {
				return "(" + x + "," + y + ")";
			}
			
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] buffer = br.readLine().split(" ");
		int m = Integer.parseInt(buffer[0]);
		int n = Integer.parseInt(buffer[1]);
		int[][] box = new int[n][m];
		int[][] dist = new int[n][m];
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		Queue<Point> q = new LinkedList<>();
		
		
		
		for (int i = 0; i < n; i++) {
			buffer = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				box[i][j] = Integer.parseInt(buffer[j]);
				if (box[i][j] == 1) {
					q.offer(new Point(i, j));
					dist[i][j] = -2;
				} else if (box[i][j] == -1) {
					dist[i][j] = -1;
				}
			}
		}
		
		while (!q.isEmpty()) {
			Point curPoint = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int x_index = curPoint.x + dx[i];
				int y_index = curPoint.y + dy[i];
				
				if (x_index < 0 || x_index >= n || y_index < 0 || y_index >= m) {
					continue;
				} else if (dist[x_index][y_index] != 0) {
					continue;
				} else {
					if (dist[curPoint.x][curPoint.y] == -2) {
						dist[x_index][y_index] = 1;
						q.offer(new Point(x_index, y_index));
					} else {
						dist[x_index][y_index] = dist[curPoint.x][curPoint.y] + 1;
						q.offer(new Point(x_index, y_index));
					}
				}
			}
		}
		
		int max = 0;
		boolean flag = false;
		
		for (int i = 0; i < n; i++) {
			if (flag) {
				break;
			}
			for (int j = 0; j < m; j++) {
				if (dist[i][j] > max) {
					max = dist[i][j];
				} else if (dist[i][j] == 0) {
					max = -1;
					flag = true;
					break;
				}
			}
		}
		
		
		bw.write(max + "\n");
		bw.flush();
		bw.close();
	}
}