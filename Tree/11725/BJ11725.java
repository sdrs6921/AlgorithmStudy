import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class BJ11725 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		List<Integer>[] adjList = new LinkedList[n + 1];
		boolean[] visited = new boolean[n + 1];
		int[] parentInfo = new int[n + 1];
		Queue<Integer> q = new LinkedList<>();
		
		for (int i = 1; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < n - 1; i++) {
			String[] buffer = br.readLine().split(" ");
			int first = Integer.parseInt(buffer[0]);
			int second = Integer.parseInt(buffer[1]);
			
			adjList[first].add(second);
			adjList[second].add(first);
		}
		
		q.offer(1);
		visited[1] = true;
		
		while (!q.isEmpty()) {
			int cur = q.poll();
			
			for (int i : adjList[cur]) {
				if (!visited[i]) {
					q.offer(i);
					visited[i] = true;
					parentInfo[i] = cur;
				}
			}
		}
		
		for (int i = 2; i <= n; i++) {
			bw.write(parentInfo[i] + "\n");
		}
		
		bw.flush();
		bw.close();
	}
	
}