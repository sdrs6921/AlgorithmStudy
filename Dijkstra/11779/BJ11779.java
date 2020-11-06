import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
public class BJ11779 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		List<Node>[] adjList = new LinkedList[n + 1];
		Queue<Node> heap = new PriorityQueue<Node>((o1, o2) -> (o1.dist - o2.dist));
		StringTokenizer st = null;
		int[] table = new int[n + 1];
		int[] prev = new int[n + 1];
		final int INF = 100000 * 1000 + 1;
		List<Integer> path = new ArrayList<>(); 
		
		for (int i = 1; i <= n; i++) {
			adjList[i] = new LinkedList<Node>();
			table[i] = INF;
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int dep = Integer.parseInt(st.nextToken());
			int des = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			adjList[dep].add(new Node(des, dist));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		heap.offer(new Node(start, 0));
		table[start] = 0;
		
		while (!heap.isEmpty()) {
			Node cur = heap.poll();
			
			if (cur.dist != table[cur.v]) {
				continue;
			}
			
			for (Node next : adjList[cur.v]) {
				if (table[next.v] > cur.dist + next.dist) {
					table[next.v] = cur.dist + next.dist;
					prev[next.v] = cur.v;
					heap.offer(new Node(next.v, table[next.v]));
				}
			}
		}
		
		int cur = end;
		int count = 1;
		
		path.add(end);
		while(cur != start) {
			path.add(prev[cur]);
			cur = prev[cur];
			count++;
		}
		
		
		bw.write(table[end] + "\n" + count + "\n");
		for (int i = path.size() - 1; i >= 0; i--) {
			bw.write(path.get(i) + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}