import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Stack;

public class BJ11724 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] buffer = br.readLine().split(" ");
		int n = Integer.parseInt(buffer[0]);
		int m = Integer.parseInt(buffer[1]);
		int answer = 0;
		LinkedList<Integer>[] list = new LinkedList[n + 1];
		Stack<Integer> s = new Stack<>();
		boolean[] visited = new boolean[n + 1];
		
		for (int i = 1; i < n + 1; i++) {
			list[i] = new LinkedList<Integer>();
		}
		
		for (int i = 0; i < m; i++) {
			buffer = br.readLine().split(" ");
			int start = Integer.parseInt(buffer[0]);
			int end = Integer.parseInt(buffer[1]);	
			list[start].add(end);
			list[end].add(start);
		}
		
		for (int i = 1; i < n + 1; i++) {
			if (!visited[i]) {
				answer++;
				visited[i] = true;
				s.push(i);
			}
			
			while (!s.isEmpty()) {
				int cur = s.pop();
				
				for (int j : list[cur]) {
					if (!visited[j]) {
						visited[j] = true;
						s.push(j);
					}
				}
				
			}
		}
		
		bw.write(answer + "\n");
		
		bw.flush();
		bw.close();
	}
	
}