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
	int start;
	int end;
	int weight;
	
	public Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}

class Node {
	int end;
	int weight;
	
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
}

public class BJ1197 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] buffer = br.readLine().split(" ");
		int V = Integer.parseInt(buffer[0]);
		int E = Integer.parseInt(buffer[1]);
		List<Node>[] adjList = new LinkedList[V + 1];
		Queue<Edge> heap = new PriorityQueue<>((o1, o2) -> (o1.weight - o2.weight));
		boolean[] check = new boolean[V + 1];
		int answer = 0;
		
		for (int i = 1; i <= V; i++) {
			adjList[i] = new LinkedList<Node>();
		}
		
		for (int i = 0; i < E; i++) {
			buffer = br.readLine().split(" ");
			int first = Integer.parseInt(buffer[0]);
			int second = Integer.parseInt(buffer[1]);
			int weight = Integer.parseInt(buffer[2]);
			adjList[first].add(new Node(second, weight));
			adjList[second].add(new Node(first, weight));
		}
		
		for (Node node : adjList[1]) {
			heap.offer(new Edge(1, node.end, node.weight));
		}
		check[1] = true;
		
		for (int i = 0; i < E; i++) {
			Edge cur = heap.poll();
			
			if (check[cur.end]) {
				continue;
			}
			
			check[cur.end] = true;
			answer += cur.weight;
			for (Node next : adjList[cur.end]) {
				if (!check[next.end]) {
					heap.offer(new Edge(cur.end, next.end, next.weight));
				}
			}
		}
		
		bw.write(answer + "\n");
		bw.flush();
		bw.close();
	}
	
}