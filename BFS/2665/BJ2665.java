import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2665 {
	public static int[] dx = {1, 0 , -1, 0};
	public static int[] dy = {0, 1, 0, -1};
	public static final int WHITE = 1;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][n];
		int[][] map = new int[n][n];
		Queue<Point> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			String[] buffer= br.readLine().split("");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(buffer[j]);
				map[i][j] = Integer.MAX_VALUE;
			}
		}

		queue.offer(new Point(0, 0));
		map[0][0] = 0;

		while (!queue.isEmpty()) {
			Point cur = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = cur.x + dx[i];
				int nextY = cur.y + dy[i];

				if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < n && map[cur.x][cur.y] < map[nextX][nextY]) {
					if (arr[nextX][nextY] == WHITE) {
						queue.offer(new Point(nextX, nextY));
						map[nextX][nextY] = map[cur.x][cur.y];
					} else {
						queue.offer((new Point(nextX, nextY)));
						map[nextX][nextY] = map[cur.x][cur.y] + 1;
					}
				}
			}
		}

		bw.write(map[n-1][n-1] + "\n");
		bw.flush();
		br.close();
		bw.close();
	}
}