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
	int index;
	int start;
	int end;
	
	public Friend(int index, int start, int end) {
		this.index = index;
		this.start = start;
		this.end = end;
	}
}
public class BJ14588 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		Friend[] friends = new Friend[n];
		final int INF = 300 * 300 + 1;
		int[][] dist = new int[n][n];
		StringTokenizer st = null;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			friends[i] = new Friend(i, start, end);
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}
		
		for (int i = 0; i < n; i++) {
			Queue<Friend> q = new LinkedList<>();
			boolean[] visited = new boolean[n];
			
			q.offer(friends[i]);
			visited[i] = true;
			dist[i][i] = 0;
			
			while (!q.isEmpty()) {
				Friend cur = q.poll();
				
				for (int j = 0; j < n; j++) {
					if (cur.index == j) {
						continue;
					}
					Friend next = friends[j];
					
					if ((cur.start > next.start && cur.start > next.end) || (cur.end < next.end && cur.end < next.start)) {
						continue;
					} else if (visited[next.index]) {
						continue;
					}
					
					q.offer(next);
					visited[next.index] = true;
					dist[i][next.index] = dist[i][cur.index] + 1;
				}
			}
		}
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			if (dist[start - 1][end - 1] == INF) {
				dist[start - 1][end - 1] = -1;
			}
			bw.write(dist[start - 1][end - 1] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
}