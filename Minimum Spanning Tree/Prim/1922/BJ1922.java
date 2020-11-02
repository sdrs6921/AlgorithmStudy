import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

class Edge {
	int n1;
	int n2;
	int cost;
	
	public Edge(int n1, int n2, int cost) {
		this.n1 = n1;
		this.n2 = n2;
		this.cost = cost;
	}
}

class Node {
	int n2;
	int cost;
	
	public Node(int n2, int cost) {
		this.n2 = n2;
		this.cost = cost;
	}
}
public class BJ1922 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<Node>[] adjList = new LinkedList[n + 1];
		boolean[] visited = new boolean[n + 1];
		Queue<Edge> heap = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
		int answer = 0;
		
		for (int i = 1; i <= n; i++) {
			adjList[i] = new LinkedList<Node>();
		}
		
		for (int i = 0; i < m; i++) {
			String[] buffer = br.readLine().split(" ");
			int n1 = Integer.parseInt(buffer[0]);
			int n2 = Integer.parseInt(buffer[1]);
			int cost = Integer.parseInt(buffer[2]);
			
			if (n1 == n2) {
				continue;
			}
			
			adjList[n1].add(new Node(n2, cost));
			adjList[n2].add(new Node(n1, cost));
		}
		
		for (Node node : adjList[1]) {
			heap.offer(new Edge(1, node.n2, node.cost));
		}
		visited[1] = true;
		
		
		while (!heap.isEmpty()) {
			Edge cur = heap.poll();
			
			for (Node node : adjList[cur.n2]) {
				if (!visited[node.n2]) {
					heap.offer(new Edge(cur.n2, node.n2, node.cost));
				}
			}
			
			if (!visited[cur.n2]) { 
				answer += cur.cost;
				visited[cur.n2] = true;
			}
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
}