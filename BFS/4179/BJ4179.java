import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;

public class BJ4179 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] buffer = br.readLine().split(" ");
		int n = Integer.parseInt(buffer[0]);
		int m = Integer.parseInt(buffer[1]);
		String[] map = new String[n];
		int dist[][] = new int[n][m];
		int distP[][] = new int[n][m];
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		
		Queue<Point> q = new LinkedList<>();
		Point pPoint = null;
		
		
		for (int i = 0; i < n; i++) {
			map[i] = br.readLine();
			for (int j = 0; j < m; j++) {
				dist[i][j] = -1;
				distP[i][j] = -1;
				if (map[i].charAt(j) == 'J') {
					pPoint = new Point(i, j);
				} else if (map[i].charAt(j) == 'F') {
					q.offer(new Point(i, j));
					dist[i][j] = 0;
				}
			}
		}
				
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				
				if (x < 0 || y < 0 || x >= n || y >= m) {
					continue;
				} else if (dist[x][y] >= 0 || map[x].charAt(y) == '#') {
					continue;
				} else {
					dist[x][y] = dist[cur.x][cur.y] + 1;
					q.offer(new Point(x, y));
				}
			}
		}
		
		boolean flag = false;
		q.offer(pPoint);
		distP[pPoint.x][pPoint.y] = 0;

		
		while (!q.isEmpty()) {
			Point cur = q.poll();
			
			for (int i = 0; i < dx.length; i++) {
				int x = cur.x + dx[i];
				int y = cur.y + dy[i];
				
				if (x < 0 || y < 0 || x >= n || y >= m) {
					flag = true;
					bw.write(distP[cur.x][cur.y] +1 + "\n");
					q.clear();
					break;
				} else if (distP[x][y] >= 0 || map[x].charAt(y) == '#') {
					continue;
				} else if (dist[x][y] != -1 && dist[x][y] <= distP[cur.x][cur.y] + 1) {
					continue;
				} else {
					distP[x][y] = distP[cur.x][cur.y] + 1;
					q.offer(new Point(x, y));
				}
			}
		}
		
		if (!flag) {
			bw.write("IMPOSSIBLE" + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}