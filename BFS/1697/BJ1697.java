import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.awt.Point;

public class BJ1697 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] buffer = br.readLine().split(" ");
		int n = Integer.parseInt(buffer[0]);
		int k = Integer.parseInt(buffer[1]);
		int[] dist = new int[100002];
		Queue<Integer> q = new LinkedList<>();
		Arrays.fill(dist, -1);
		
		q.add(n);
		dist[n] = 0;
		
		while (dist[k] == -1) {
			int cur = q.poll().intValue();
			int[] tmp = {cur + 1, cur - 1, cur * 2};
			
			for (int next : tmp) {
				if (next < 0 || next > 100001) {
					continue;
				} else if (dist[next] != -1) {
					continue;
				}
				
				dist[next] = dist[cur] + 1;
				q.offer(next);
			}
		}
		
		bw.write(dist[k] + "\n");
		bw.flush();
		bw.close();
	}
}