import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11780 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int[][] d = new int [n + 1][n + 1];
		int[][] next = new int[n + 1][n + 1];
		final int INF = 100000001;
		
		for (int i = 1; i <= n; i++) {
			Arrays.fill(d[i], INF);
			d[i][i] = 0;
		}
		
		for (int i = 0; i < m; i ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			d[start][end] = Math.min(d[start][end], dist);
			next[start][end] = end;
		}
		
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (d[i][j] > d[i][k] + d[k][j]) {
						d[i][j] = d[i][k] + d[k][j];
						next[i][j] = next[i][k];
					}
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == INF) {
					d[i][j] = 0;
				}
				bw.write(d[i][j] + " ");
			}
			bw.newLine();
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (d[i][j] == 0) {
					bw.write("0\n");
					continue;
				}
				ArrayList<Integer> path = new ArrayList<>();
				int cur = i;
				
				while (cur != j) {
					path.add(cur);
					cur = next[cur][j];
				}
				path.add(cur);
				
				bw.write(path.size() + " ");
				for (int p : path) {
					bw.write(p + " ");
				}
				bw.newLine();
			}
		}
		bw.flush();
		bw.close();
	}
}