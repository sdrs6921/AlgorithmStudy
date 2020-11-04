import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Friend {
	int start;
	int end;
	
	public Friend(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class BJ14588 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		Friend[] friends = new Friend[n + 1];
		final int INF = 300 * 300 + 1;
		int[][] map = new int[n + 1][n + 1];
		int[][] dist = new int[n + 1][n + 1];
		StringTokenizer st = null;
		
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			friends[i] = new Friend(start, end);
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = i + 1; j <= n; j++) {
				Friend f1 = friends[i];
				Friend f2 = friends[j];
				
				if ((f1.end < f2.start && f1.end < f2.end) || (f1.start > f2.start && f1.start > f2.end)) {
					continue;
				} else {
					map[i][j] = 1;
					map[j][i] = 1;
					dist[i][j] = 1;
					dist[j][i] = 1;
				}
			}
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if (dist[start][end] == INF) {
				dist[start][end] = -1;
			}
			
			bw.write(dist[start][end] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}