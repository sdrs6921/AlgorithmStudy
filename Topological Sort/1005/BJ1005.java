import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ1005 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int testCase = Integer.parseInt(br.readLine());
		
		for (int test = 0; test < testCase; test++) {
			String[] buffer = br.readLine().split(" ");
			int n = Integer.parseInt(buffer[0]);
			int k = Integer.parseInt(buffer[1]);
			int[] indegree = new int[n + 1];
			List<Integer>[] adjList = new LinkedList[n + 1];
			int[] timeSpent = new int[n + 1];
			boolean[] check = new boolean[n + 1];
			Queue<Integer> q = new LinkedList<>();
			int time = 0;
			int[] result = new int[n + 1];
			
			buffer = br.readLine().split(" ");
			
			for (int i = 1; i <= n; i++) {
				adjList[i] = new LinkedList<Integer>();
				timeSpent[i] = Integer.parseInt(buffer[i - 1]);
			}
			
			for (int i = 0; i < k; i++) {
				buffer = br.readLine().split(" ");
				int start = Integer.parseInt(buffer[0]);
				int end = Integer.parseInt(buffer[1]);
				
				adjList[start].add(end);
				indegree[end]++;
			}
			
			int w = Integer.parseInt(br.readLine());
			
			for (int i = 1; i <= n; i++) {
				result[i] = timeSpent[i];
				if (!check[i] && indegree[i] == 0) {
					q.offer(i);
					check[i] = true;
				}
			}
			
			while (!check[w] && !q.isEmpty()) {
				int cur = q.poll();
				
				for (int i : adjList[cur]) {
					result[i] = Math.max(result[i], result[cur] + timeSpent[i]);
					if (--indegree[i] == 0) {
						check[cur] = true;
						q.offer(i);
					}
				}
			}
			
			bw.write(result[w] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
}