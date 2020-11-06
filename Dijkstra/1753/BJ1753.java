import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int v;
	int dist;
	
	public Node(int v, int dist) {
		this.v = v;
		this.dist = dist;
	}
}
public class BJ1753 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(br.readLine());
		List<Node>[] adjList = new LinkedList[V + 1];
		Queue<Node> heap = new PriorityQueue<Node>((o1, o2) -> (o1.dist - o2.dist));
		int[] table = new int[V + 1];
		final int INF = 30000000 + 1;
		
		for (int i = 1; i <= V; i++) {
			adjList[i] = new LinkedList<Node>();
			table[i] = INF;
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int depart = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			adjList[depart].add(new Node(dest, dist));
		}
		
		
		heap.offer(new Node(start, 0));
		table[start] = 0;
		
		while (!heap.isEmpty()) {
			Node cur = heap.poll();
			if (table[cur.v] != cur.dist) {
				continue;
			}
			
			for (Node next : adjList[cur.v]) {
				if (table[next.v] > next.dist + cur.dist) {
					table[next.v] = next.dist + cur.dist;
					heap.offer(new Node(next.v, table[next.v]));
				}
			}
		}
		
		for (int i = 1; i <= V; i++) {
			if (table[i] != INF) {
				bw.write(table[i] + "\n");
			} else {
				bw.write("INF\n");
			}
		}
		
		bw.flush();
		bw.close();
	}
}