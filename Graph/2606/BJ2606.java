import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class BJ2606 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<Integer>[] adjList = new LinkedList[n + 1];
		boolean[] visited = new boolean[n + 1];
		Stack<Integer> s = new Stack<>();
		int answer = 0;
		
		for (int i = 1; i <= n; i++) {
			adjList[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			String[] buf = br.readLine().split(" ");
			int first = Integer.parseInt(buf[0]);
			int second = Integer.parseInt(buf[1]);
			
			adjList[first].add(second);
			adjList[second].add(first);
		}
		
		s.push(1);
		visited[1] = true;
		
		while (!s.isEmpty()) {
			int cur = s.pop();
			answer++;
			
			for (int i : adjList[cur]) {
				if (!visited[i]) {
					s.push(i);
					visited[i] = true;
 				}
			}
		}
		
		bw.write(answer - 1 + "\n");
		
		
		bw.flush();
		bw.close();
	}
	
}