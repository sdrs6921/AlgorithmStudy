import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BJ2623 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] buffer = br.readLine().split(" ");
		int n = Integer.parseInt(buffer[0]);
		int m = Integer.parseInt(buffer[1]);
		Queue<Integer> q = new LinkedList<Integer>();
		List<Integer>[] adjList = new LinkedList[n + 1];
		List<Integer> result = new ArrayList<>();
		int[] indegree = new int[n + 1];
		boolean[] check = new boolean[n + 1];
		
		for (int i = 1; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			buffer = br.readLine().split(" ");
			int num = Integer.parseInt(buffer[0]);
			
			for (int j = 1; j < num; j++) {
				int start = Integer.parseInt(buffer[j]);
				
				for (int k = j + 1; k <= num; k++) {
					int to = Integer.parseInt(buffer[k]);
					
					adjList[start].add(to);
					indegree[to]++;
				}
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0 && !check[i]) {
				q.offer(i);
				check[i] = true;
			}
			
			while (!q.isEmpty()) {
				int cur = q.poll();
				result.add(cur);
				
				for (int next : adjList[cur]) {
					indegree[next]--;
					if (indegree[next] == 0 && !check[next]) {
						q.offer(next);
						check[next] = true;
					}
				}
			}
		}
		
		if (result.size() != n) {
			bw.write(0 + "\n");
		} else {
			for (int i : result) {
				bw.write(i + "\n");
			}
		}
		
		
		bw.flush();
		bw.close();
	}
	
}