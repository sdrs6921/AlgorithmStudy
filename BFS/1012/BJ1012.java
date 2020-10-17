import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;

public class BJ1012 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int[][] map;
		int t = Integer.parseInt(br.readLine());
		Queue<Point> q = new LinkedList<>();
		
		for (int i = 0; i < t; i++) {
			String[] buf = br.readLine().split(" ");
			int col = Integer.parseInt(buf[0]);
			int row = Integer.parseInt(buf[1]);
			int worm = Integer.parseInt(buf[2]);
			int answer = 0;
			map = new int[row][col];
			boolean[][] visited = new boolean[row][col];
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, 1, 0, -1};
			
			for (int j = 0; j < worm; j++) {
				buf = br.readLine().split(" ");
				int x = Integer.parseInt(buf[0]);
				int y = Integer.parseInt(buf[1]);
				map[y][x] = 1;
			}
			
			for (int k = 0; k < row; k++) {
				for (int h = 0; h < col; h++) {
					if(map[k][h] == 1 && !visited[k][h]) {
						answer++;
						q.offer(new Point(k, h));
						visited[k][h] = true;
						
						while (!q.isEmpty()) {
							Point cur = q.poll();
							
							for (int index = 0; index < 4; index++) {
								int r = cur.x + dx[index];
								int c = cur.y + dy[index];
								
								if (r < 0 || c < 0 || r >= row|| c >= col) {
									continue;
								} else if (visited[r][c] || map[r][c] != 1) {
									continue;
								}
								
								visited[r][c] = true;
								q.offer(new Point(r, c));
							}
						}
					}
				}
			}
			
			bw.write(answer + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}