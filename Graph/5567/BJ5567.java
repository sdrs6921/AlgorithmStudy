import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;


public class BJ5567 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<Integer>[] adjList = new LinkedList[n + 1];
		Stack<Integer> stack = new Stack<>();
		int[] dist = new int[n + 1];
		int answer = 0;
		
		for (int i = 1; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		Arrays.fill(dist, -1);
		
		for (int i = 0; i < m; i++) {
			String[] buffer = br.readLine().split(" ");
			int first = Integer.parseInt(buffer[0]);
			int second = Integer.parseInt(buffer[1]);
			
			adjList[first].add(second);
			adjList[second].add(first);
		}
		
		stack.add(1);
		dist[1] = 0;
		
		while (!stack.isEmpty()) {
			int cur = stack.pop();
			
			for (int i : adjList[cur]) {
				if (dist[i] < 0 || dist[cur] + 1 < dist[i]) {
					stack.add(i);
					dist[i] = dist[cur] + 1;
				}
			}
		}
		
		for (int i = 1; i < dist.length; i++) {
			if (dist[i] > 0 && dist[i] < 3) { 
				answer++;
			}
		}
		bw.write(answer + "\n");
		
		bw.flush();
		bw.close();
	}
	
}